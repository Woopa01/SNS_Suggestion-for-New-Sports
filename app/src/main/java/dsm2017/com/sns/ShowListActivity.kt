package dsm2017.com.sns

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dsm2017.com.sns.Recycler.Recycleitem
import dsm2017.com.sns.Recycler.Recycleradapter
import kotlinx.android.synthetic.main.activity_list.*

class ShowListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        val context = MainActivity@this
        val recyclerdata = arrayListOf<Recycleitem>()

        for (i in 1..15)
        recyclerdata.add(Recycleitem("title","name","30","0000.00.00."))


        var adapter = Recycleradapter(recyclerdata,context)
        list_recycler?.adapter = adapter

    }
}