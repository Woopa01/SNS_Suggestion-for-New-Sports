package dsm2017.com.sns

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Thread.sleep(2000)

        val intent = Intent(SplashActivity@this,SigninActivity::class.java)
        startActivity(intent)
    }
}