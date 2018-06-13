package dsm2017.com.sns

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dsm2017.com.sns.Recycler.FeedBackListAdapter
import dsm2017.com.sns.Recycler.Recycleitem
import kotlinx.android.synthetic.main.activity_feedbacklist.*
import kotlinx.android.synthetic.main.activity_sportslist.*

class ShowFeedBackListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedbacklist)

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
}