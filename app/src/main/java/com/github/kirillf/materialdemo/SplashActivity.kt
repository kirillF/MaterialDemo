package com.github.kirillf.materialdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle

/**
 * Created by k.filimonov on 11/04/2017.
 */

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        Thread(Runnable {
            try {
                Thread.sleep(2000)
                onTaskCompleted()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }).start()
    }

    private fun onTaskCompleted() {
        runOnUiThread {
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}
