package dsm2017.com.sns

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import dsm2017.com.sns.R.id.*
import dsm2017.com.sns.retrofit.Connect
import dsm2017.com.sns.retrofit.Model.UserDataModel
import kotlinx.android.synthetic.main.activity_signin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class SigninActivity : AppCompatActivity() {

    lateinit var username : String
    lateinit var usertoken : String
    val context = SigninActivity@this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        SigninSharedPreferences.CheckLogin(context)

        signin_main_button.setOnClickListener {
           //SignInRequest(signin_id.text.toString(),signin_password.text.toString())
            val intent = Intent(SigninActivity@this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        signin_signup_button.setOnClickListener {
            val intent = Intent(SigninActivity@this,SignupActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    fun SignInRequest(user_id : String, user_password : String) {
        val map = hashMapOf<String,String>("user_id" to user_id, "user_password" to user_password)

        Connect.api.SigninRequest(map)
                .enqueue(object : retrofit2.Callback<UserDataModel>{
                    override fun onResponse(call: Call<UserDataModel>?, response: Response<UserDataModel>?) {
                        var userDataModel = response!!.body()

                             username = userDataModel!!.UserDatas().user_name
                             usertoken = userDataModel.UserDatas().user_token

                        SigninSharedPreferences.setLogin(context, user_id, user_password, username, usertoken)

                        Log.d("DEBUG",usertoken)
                        Log.d("DEBUG",username)

                        Toast.makeText(baseContext,"성공적으로 로그인 되었습니다.",Toast.LENGTH_SHORT).show()

                    }

                    override fun onFailure(call: Call<UserDataModel>?, t: Throwable?) {

                    }

                })
    }
}

