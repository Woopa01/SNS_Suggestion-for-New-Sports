package dsm2017.com.sns

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dsm2017.com.sns.Recycler.Recycleitem
import dsm2017.com.sns.Recycler.SportsListAdapter
import kotlinx.android.synthetic.main.activity_sportslist.*

class ShowSportsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sportslist)


        val context = ShowSportsListActivity@this
        val recyclerdata = arrayListOf<Recycleitem>()

        for (i in 1..15)
        recyclerdata.add(Recycleitem("title","name","30","0000.00.00."))


        var adapter = SportsListAdapter(recyclerdata,context)
        list_recycler?.adapter = adapter

        list_back.setOnClickListener {
            val intent = Intent(ShowListActivity@this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}