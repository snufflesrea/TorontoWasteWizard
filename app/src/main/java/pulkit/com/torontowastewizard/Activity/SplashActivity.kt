package pulkit.com.torontowastewizard.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

import pulkit.com.torontowastewizard.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        Handler().postDelayed({
            val sharedPreferences = getSharedPreferences("loginSharedPreference", Context.MODE_PRIVATE)
            val username = sharedPreferences.getString("username", null)
            if (username == null) {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this@SplashActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, SPLASH_TIME_OUT.toLong())
    }

    companion object {

        private val SPLASH_TIME_OUT = 3000
    }
}
