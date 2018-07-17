package dsm2017.com.sns

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import dsm2017.com.sns.retrofit.Connect
import kotlinx.android.synthetic.main.activity_mypage.*
import kotlinx.android.synthetic.main.dialog_modifyname.*
import kotlinx.android.synthetic.main.dialog_modifypassword.*
import retrofit2.Call
import retrofit2.Response

class MyPageActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        val dialog = Dialog(MyPageActivity@ this)

        mypage_back.setOnClickListener {
            val intent = Intent(MyPageActivity@ this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        mypage_modifyname.setOnClickListener {
            val modify_name_view = layoutInflater.inflate(R.layout.dialog_modifyname, null)
            dialog.setContentView(modify_name_view)
            val modify_name_cancel = dialog.findViewById<Button>(R.id.dialog_modifyname_cancel)
            val modify_name_ok = dialog.findViewById<Button>(R.id.dialog_modifyname_ok)
            dialog.setCanceledOnTouchOutside(false)
            dialog.show()

            modify_name_cancel.setOnClickListener { dialog.dismiss() }

            modify_name_ok.setOnClickListener { ModifynameRequest(dialog_modifyname_input.text.toString()) }


            dialog.window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }

        mypage_modifypassword.setOnClickListener {
            val modify_password_view = layoutInflater.inflate(R.layout.dialog_modifypassword,null)
            dialog.setContentView(modify_password_view)
            val modify_password_cancel = dialog.findViewById<Button>(R.id.dialog_modifypassword_cancel)
            val modify_password_ok = dialog.findViewById<Button>(R.id.dialog_modifypassword_ok)
            dialog.setCanceledOnTouchOutside(false)
            dialog.show()
            
            modify_password_cancel.setOnClickListener { dialog.dismiss() }
            
            modify_password_ok.setOnClickListener { ModifypasswordRequest(dialog_modifypassword_input.text.toString()) }
            
            dialog.window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        }

        mypage_showfeedback.setOnClickListener {
            val intent = Intent(MyPageActivity@this, ShowFeedBackListActivity::class.java)
            startActivity(intent)
            finish()
        }

        mypage_logout.setOnClickListener {
            SigninSharedPreferences.setLogout(context = MyPageActivity@ this)
            val intent = Intent(MyPageActivity@ this, SigninActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun ModifypasswordRequest(user_password: String) {
        val user_token = getSharedPreferences("pref", Context.MODE_PRIVATE).getString("user_token", "")
        var map = hashMapOf<String,String>("user_password" to user_password, "user_toekn" to user_token)

        Connect.api.ModifyPasswordRequest(map)
                .enqueue(object : retrofit2.Callback<Void>{
                    override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                        if (response!!.isSuccessful) {
                            Log.d("DEBUG", "success")
                        } else {
                            Log.d("DEBUG","failed1")
                        }
                    }

                    override fun onFailure(call: Call<Void>?, t: Throwable?) {
                        Log.d("DEBUG","failed2")
                    }
                })


    }

    fun ModifynameRequest(user_name: String) {
        val user_token = getSharedPreferences("pref", Context.MODE_PRIVATE).getString("user_token", "")
        var map = hashMapOf<String, String>("user_name" to user_name, "user_token" to user_token)

        Connect.api.ModifyNameRequest(map)
                .enqueue(object : retrofit2.Callback<Void> {

                    override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                        if (response!!.isSuccessful) {
                            Log.d("DEBUG", "success")
                        } else {
                            Log.d("DEBUG","failed1")
                        }
                    }

                    override fun onFailure(call: Call<Void>?, t: Throwable?) {
                            Log.d("DEBUG","failed2")
                    }
                })
    }
}