package com.devsdimension.android.debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "This is where the app crashed before.")
        //val helloTextView: TextView = findViewById(R.id.division_textview)
        Log.d(TAG, "This should be logged if the bug is fixed.")
        //helloTextView.text = "Hello, debugging!"

        logging()
        first()
        division()
    }

    fun first() {
        second()
        Log.v(TAG, "1")
    }

    fun second() {
        third()
        Log.v(TAG, "2")
        forth()
    }

    fun third() {
        Log.v(TAG, "3")
    }

    fun forth() {
        Log.v(TAG, "4")
    }

    fun division() {
        val numerator = 60
        var denominator = 4
        repeat(4) {
            Thread.sleep(3000)
            Log.d(TAG, "$denominator")
            Log.v(TAG, "${numerator / denominator}")
            findViewById<TextView>(R.id.division_textview).setText("${numerator / denominator}")
            denominator--
        }
    }

    fun logging() {
        Log.e(TAG, "ERROR: a serious error like an app crash")
        Log.w(TAG, "WARN: warns about the potential for serious errors")
        Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")

        /**
         * Log levels
         * ERROR logs report that something went seriously wrong, such as the reason why an app
         * crashed.
         */
        Log.e(TAG, "The cake was left in the oven for too long and burned.")

        /**
         * WARN logs are less severe than an error but still report something that should be fixed
         * to avoid a more serious error. An example might be if you call a function that's
         * deprecated, meaning that its use is discouraged in favor of a newer alternative.
         */
        Log.w(TAG, "This oven does not heat evenly." +
                "You may want to turn the cake around halfway through to promote even browning.")

        /**
         * INFO logs provide useful information, such as an operation being successfully completed.
         */
        Log.i(TAG, "The cake is ready to be served.")
        println("The cake has cooled.")

        /**
         * DEBUG logs contain information that may be useful when investigating an issue. These
         * logs are not present in release builds such as one you'd publish on the Google Play Store.
         */
        Log.d(TAG, "Cake was removed from the oven after 55 minutes. Recipe calls for the" +
                "cake to be removed after 50 - 60 minutes.")

        /**
         * As the name implies, verbose is the least specific log level. What's considered a debug
         * log, versus a verbose log, is a bit subjective, but generally, a verbose log is
         * something that can be removed after a feature is implemented, whereas a debug log may
         * still be useful for debugging. These logs are also not included in release builds.
         */
        Log.v(TAG, "Put the mixing bowl on the counter.")
        Log.v(TAG, "Grabbed the eggs from the refrigerator.")
        Log.v(TAG, "Plugged in the stand mixer.")
    }
}