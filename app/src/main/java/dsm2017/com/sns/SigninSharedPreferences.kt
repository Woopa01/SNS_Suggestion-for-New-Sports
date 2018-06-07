package dsm2017.com.sns

import android.content.Context
import android.content.Intent
import kotlin.coroutines.experimental.coroutineContext

object SigninSharedPreferences {
    fun setLogin(context: Context,user_id: String, user_password : String, user_name: String, user_token: String){
        var editor = context.getSharedPreferences("pref",Context.MODE_PRIVATE).edit()
        editor
                .putString("user_id",user_id)
                .putString("user_password",user_password)
                .putString("user_name",user_name)
                .putString("user_token",user_token)
                .apply()
    }

    fun setLogout(context: Context){
        var editor = context.getSharedPreferences("pref",Context.MODE_PRIVATE).edit()
        editor
                .putString("user_id","")
                .putString("user_password","")
                .putString("user_name","")
                .putString("user_token","")
                .apply()
    }

    fun CheckLogin(context: Context){
        var name = context.getSharedPreferences("pref",Context.MODE_PRIVATE).getString("user_name","")
        if(name != ""){
            val intent = Intent(context,MainActivity::class.java)
            context.startActivity(intent)
        } else {

        }
    }

}