package dsm2017.com.sns

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import dsm2017.com.sns.retrofit.Connect
import kotlinx.android.synthetic.main.activity_mypage.*
import kotlinx.android.synthetic.main.dialog_modifyname.*
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
            val modify_name = layoutInflater.inflate(R.layout.dialog_modifyname, null)
            dialog.setContentView(modify_name)
            val modify_name_cancel = dialog.findViewById<Button>(R.id.dialog_modifyname_cancel)
            val modify_name_ok = dialog.findViewById<Button>(R.id.dialog_modifyname_ok)
            dialog.setCanceledOnTouchOutside(false)
            dialog.show()

            modify_name_cancel.setOnClickListener { dialog.dismiss() }

            modify_name_ok.setOnClickListener {
                ModifynameRequest(dialog_modifyname_input.text.toString())
            }


            var window = dialog.window
            window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }


        mypage_logout.setOnClickListener {
            SigninSharedPreferences.setLogout(context = MyPageActivity@ this)
            val intent = Intent(MyPageActivity@ this, SigninActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun ModifynameRequest(user_password: String) {
        var user_token = getSharedPreferences("pref", Context.MODE_PRIVATE).getString("user_token", "")

        var map = hashMapOf<String, String>("user_password" to user_password, "user_token" to user_token)

        Connect.api.ModifyNameRequest(map)
                .enqueue(object : retrofit2.Callback<Void> {

                    override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                        if (response!!.isSuccessful) {
                            Log.d("DEBUG", "success")
                        } else {

                        }
                    }

                    override fun onFailure(call: Call<Void>?, t: Throwable?) {

                    }
                })
    }
}