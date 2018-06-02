package dsm2017.com.sns

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signin.*

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        signin_main_button.setOnClickListener {
            val intent = Intent(SigninActivity@this,MainActivity::class.java)
            startActivity(intent)
        }

        signin_signup_button.setOnClickListener {
            val intent = Intent(SigninActivity@this,SignupActivity::class.java)
            startActivity(intent)
        }


    }
}