package dsm2017.com.sns

import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import dsm2017.com.sns.retrofit.Connect
import dsm2017.com.sns.retrofit.Model.EmailCodeModel
import kotlinx.android.synthetic.main.activity_signup.*
import okhttp3.ResponseBody
import org.jetbrains.annotations.Nullable
import retrofit2.Call
import retrofit2.Response

class SignupActivity : AppCompatActivity() {

    lateinit var checkbool : String
    lateinit var emailcode : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        signup_checkemail_button.setOnClickListener {
            if (signup_email_input == null){
                Toast.makeText(baseContext,"이메일을 입력해주세요.",Toast.LENGTH_SHORT).show()
            } else {
                EmailCodeRequest(signup_email_input.text.toString())
            }
        }

        signup_signup_button.setOnClickListener{
            SignUpRequest(signup_email_input.text.toString(),signup_password.text.toString(),signup_nickname.text.toString(),checkbool)
        }
    }

    fun EmailCodeRequest(user_email : String) {
        val map = hashMapOf<String,String>("user_email" to user_email)
        Connect.api.EmailCodeRequest(map)
                .enqueue(object : retrofit2.Callback<EmailCodeModel>{
                    override fun onResponse(call: Call<EmailCodeModel>?, response: Response<EmailCodeModel>?) {
                        val emailCodeModel = response!!.body()

                            emailcode = emailCodeModel!!.code.toString()

                        Toast.makeText(baseContext,emailcode,Toast.LENGTH_SHORT).show()
                        Log.d("DEBUG","success")
                    }

                    override fun onFailure(call: Call<EmailCodeModel>?, t: Throwable?) {
                        Log.d("DEBUG","failed")
                    }

                })
    }

    fun SignUpRequest(user_id: String, user_password: String, user_name: String, check : String) {

        val map = hashMapOf<String,String>("user_id" to user_id, "user_password" to user_password, "user_name" to user_name ,
                "check_email" to check)

        Connect.api.SignupRequest(map)
                .enqueue(object : retrofit2.Callback<ResponseBody> {

                    override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                        if (response!!.code() == 200) {
                            Log.d("DEBUG", "success")
                        } else {

                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                        Log.d("DEBUG","failed2")
                    }

                })

    }
}