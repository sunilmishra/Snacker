package com.emctechlab.snacker

import android.os.Handler
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.content.res.AppCompatResources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import java.lang.ref.WeakReference

/**
 * Created by Sunil Mishra on 05/18/18.
 */
class Snacker private constructor(private val activity: AppCompatActivity,
                                  private var weakRootView: WeakReference<View>,
                                  private var duration: Long) {

    fun show() {
        if (activity.isFinishing || activity.isDestroyed) {
            return
        }
        val mainView = weakRootView.get()
        if (mainView != null) {

            mainView.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.slide_in_from_top))
            //start animation
            val decorView: ViewGroup = activity.window.decorView as ViewGroup
            decorView.addView(mainView)

            //stop animation and hide.
            val handler = Handler()
            handler.postDelayed({
                mainView.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.slide_out_to_top))
                decorView.removeView(mainView)
            }, duration)
        }
    }

    class Builder constructor(private val activity: AppCompatActivity) {
        private var weakRootView: WeakReference<View>

        init {
            val inflater = LayoutInflater.from(activity)
            val rootView = inflater.inflate(R.layout.view_snacker, null)
            weakRootView = WeakReference(rootView)
        }

        private var messageString: String = ""
        private var durationLength: Duration = Duration.LENGTH_SHORT

        enum class Duration(val duration: Long) {
            LENGTH_SHORT(2000L),
            LENGTH_LONG(4000L);
        }

        fun setMessage(message: String): Builder {
            this.messageString = message

            val messageTextView = weakRootView.get()?.findViewById<TextView>(R.id.messageTextView)
            messageTextView?.text = message
            return this
        }

        fun setIcon(@DrawableRes icon: Int, tintColor: Int? = null): Builder {
            val iconImageView = weakRootView.get()?.findViewById<ImageView>(R.id.iconImageView)
            iconImageView?.setImageResource(icon)
            tintColor?.let {
                val colorStateList = AppCompatResources.getColorStateList(activity, tintColor)
                iconImageView?.imageTintList = colorStateList
            }
            return this
        }

        fun setBackgroundColor(@ColorRes color: Int): Builder {
            val snackContainerLayout = weakRootView.get()?.findViewById<FrameLayout>(R.id.snackContainerLayout)
            snackContainerLayout?.setBackgroundColor(activity.resources.getColor(color))
            return this
        }

        fun setTextColor(@ColorRes color: Int): Builder {
            val messageTextView = weakRootView.get()?.findViewById<TextView>(R.id.messageTextView)
            messageTextView?.setTextColor(activity.resources.getColor(color))
            return this
        }

        fun setDuration(duration: Duration): Builder {
            this.durationLength = duration
            return this
        }

        fun build(): Snacker {
            return Snacker(activity, weakRootView, durationLength.duration)
        }
    }
}
