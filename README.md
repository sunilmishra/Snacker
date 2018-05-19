# Snacker
This is Snacker, showing snack message from Top of the screen. 

<img src="https://github.com/sunilmishra/Snacker/blob/master/screenshots/0.png" width="200" height="400" /> <img src="https://github.com/sunilmishra/Snacker/blob/master/screenshots/1.png" width="200" height="400" /> <img src="https://github.com/sunilmishra/Snacker/blob/master/screenshots/2.png" width="200" height="400" /> <img src="https://github.com/sunilmishra/Snacker/blob/master/screenshots/3.png" width="200" height="400" />

https://www.youtube.com/watch?v=opQViiYseuI

**# Create Default Snacker message:**
```
val defaultSnacker = Snacker.Builder(activity as AppCompatActivity)
                       .setMessage("This is Default snacker message.")
                       .build()
            defaultSnacker.show()
```
**# Create Colored Snacker message:**
```
val coloredSnacker = Snacker.Builder(activity as AppCompatActivity)
                    .setMessage("This is Colored snacker message.")
                    .setBackgroundColor(R.color.pumpkin)
                    .setTextColor(R.color.silver)
                    .build()
            coloredSnacker.show()
```
**# Create Icon Snacker message:**
```
val iconSnacker = Snacker.Builder(activity as AppCompatActivity)
                    .setMessage("This is snacker message with icon.")
                    .setBackgroundColor(R.color.lightBlue)
                    .setTextColor(android.R.color.black)
                    .setIcon(R.drawable.icon)
                    .build()
            iconSnacker.show()
```
**# Create Duration Snacker message:**
```
val iconSnacker = Snacker.Builder(activity as AppCompatActivity)
                    .setMessage("This is snacker message with icon.")
                    .setBackgroundColor(R.color.lightBlue)
                    .setTextColor(android.R.color.black)
                    .setIcon(R.drawable.icon)
                    .setDuration(Snacker.Builder.Duration.LENGTH_LONG)
                    .build()
            iconSnacker.show()
```
