package dsm2017.com.sns

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import dsm2017.com.sns.Recycler.Recycleitem
import dsm2017.com.sns.Recycler.Recycleradapter
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_showdetail.*

class ShowDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showdetail)

    showdetail_back.setOnClickListener {
        val intent = Intent(ShowDetailActivity@this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    }
}