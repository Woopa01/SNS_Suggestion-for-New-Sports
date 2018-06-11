package dsm2017.com.sns

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import dsm2017.com.sns.retrofit.Connect
import dsm2017.com.sns.retrofit.Model.UserDataModel
import kotlinx.android.synthetic.main.activity_write.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class WriteSportsActivty : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        val sharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE)
        var user_name = sharedPreferences.getString("user_name","null")
        var user_token = sharedPreferences.getString("user_token","null")

        write_back.setOnClickListener {
            val intent = Intent(WriteActivty@this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        write_ok.setOnClickListener {
            InsertNewSportsRequest(write_title.text.toString(),write_content.text.toString(),user_name,user_token)
        }

    }

    fun InsertNewSportsRequest(sports_name: String, sports_rule: String, user_name : String, user_token : String) {
        val map = hashMapOf<String,String>("sports_name" to sports_name, "sprots_rule" to sports_rule,"user_token" to user_token,
                "sports_category" to "sports_category", "user_name" to user_name)

        Connect.api.WriteSportsRequest(map)
                .enqueue(object :retrofit2.Callback<ResponseBody>{
                    override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                        if(response!!.code() == 200){
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