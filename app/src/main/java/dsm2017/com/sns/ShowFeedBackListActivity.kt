package dsm2017.com.sns

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dsm2017.com.sns.Recycler.FeedBackListAdapter
import dsm2017.com.sns.Recycler.Recycleitem
import dsm2017.com.sns.retrofit.Connect
import dsm2017.com.sns.retrofit.Model.FeedBackListModel
import kotlinx.android.synthetic.main.activity_feedbacklist.*
import kotlinx.android.synthetic.main.activity_sportslist.*
import retrofit2.Call
import retrofit2.Response

class ShowFeedBackListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedbacklist)

        initial(getSharedPreferences("pref", Context.MODE_PRIVATE).getString("user_token","").toString())

        val context = ShowFeedBackListActivity@this
        val recyclerdata = arrayListOf<Recycleitem>()

        for (i in 1..15)
            recyclerdata.add(Recycleitem("feedback_title","sports_name","user_name","0000.00.00."))


        var adapter = FeedBackListAdapter(recyclerdata,context)
        feedbacklist_recycler?.adapter = adapter

        feedbacklist_back.setOnClickListener {
            val intent = Intent(ShowFeedBackListActivity@this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun initial(user_token : String) {
        val map = hashMapOf<String,String>("user_token" to user_token)

        Connect.api.ShowFeedBackListRequest(map)
                .enqueue(object : retrofit2.Callback<FeedBackListModel>{
                    override fun onResponse(call: Call<FeedBackListModel>?, response: Response<FeedBackListModel>?) {
                    if(response!!.isSuccessful){
                        var res = response.body()
                        res!!.feedback.forEach {
                            var feedback_title = it.feedback_title
                            var sports_name = it.sport_name
                            var user_name = it.user_name
                            var feedback_context = it.feedback_context
                            var feedback_date = it.feedback_date
                            var feedback_serialnumber = it.feedback_serialnum
                        }
                    }
                    }

                    override fun onFailure(call: Call<FeedBackListModel>?, t: Throwable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })

    }
}