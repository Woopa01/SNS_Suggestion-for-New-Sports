package dsm2017.com.sns

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import dsm2017.com.sns.retrofit.Connect
import kotlinx.android.synthetic.main.activity_feedback.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class WriteFeedBackActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)


        feedback_back.setOnClickListener {
            val intent = Intent(WriteFeedBackActivity@this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        feedback_sendbtn.setOnClickListener {
         //   WritefeedbackRequest(feedback_title.text.toString(),feedback_content.text.toString())
        }

    }

    fun WritefeedbackRequest(feedback_title: String, feedback_context: String) {
        var user_token = getSharedPreferences("pref", Context.MODE_PRIVATE).getString("user_token","")
        var user_name = getSharedPreferences("pref", Context.MODE_PRIVATE).getString("user_name","")

        var map = hashMapOf<String,String>("feedback_title" to feedback_title, "feedback_context" to feedback_context
        ,"sport_name" to "sport_name","user_token" to user_token, "user_name" to user_name)

        Connect.api.WriteFeedBackRequset(map)
                .enqueue(object : retrofit2.Callback<ResponseBody>{
                    override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                        if(response!!.isSuccessful){
                            Toast.makeText(baseContext,"성공적으로 피드백 보내기를 마쳤습니다.",Toast.LENGTH_SHORT).show()
                            Log.d("DEBUG","success")
                        } else {
                            Log.d("DEBUG","failed1")
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                        Log.d("DEBUG","failed2")
                    }
                })
    }
}