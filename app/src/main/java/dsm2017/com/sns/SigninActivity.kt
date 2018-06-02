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
<<<<<<< HEAD
            val intent = Intent(SigninActivity@this,MainActivity::class.java)
=======
            val intent = Intent(SigninActivity@this,ShowDetailActivity::class.java)
>>>>>>> 641074ced2c74c62738e9b5351a1a8da1307045a
            startActivity(intent)
        }

        signin_signup_button.setOnClickListener {
            val intent = Intent(SigninActivity@this,SignupActivity::class.java)
            startActivity(intent)
        }


    }
}