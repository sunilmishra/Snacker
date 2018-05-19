package com.emctechlab.snackerdemo

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emctechlab.snacker.Snacker
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        defaultSnackerButton.setOnClickListener {
            val defaultSnacker = Snacker.Builder(activity as AppCompatActivity)
                    .setMessage("This is Default snacker message.")
                    .build()
            defaultSnacker.show()
        }

        coloredSnackerButton.setOnClickListener {
            val coloredSnacker = Snacker.Builder(activity as AppCompatActivity)
                    .setMessage("This is Colored snacker message.")
                    .setBackgroundColor(R.color.pumpkin)
                    .setTextColor(R.color.silver)
                    .build()
            coloredSnacker.show()
        }

        iconSnackerButton.setOnClickListener {
            val iconSnacker = Snacker.Builder(activity as AppCompatActivity)
                    .setMessage("This is snacker message with icon.")
                    .setBackgroundColor(R.color.lightBlue)
                    .setTextColor(android.R.color.black)
                    .setIcon(R.drawable.icon)
                    .build()
            iconSnacker.show()
        }
    }
}
