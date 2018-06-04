package dsm2017.com.sns

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivty : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        write_back.setOnClickListener {
            val intent = Intent(WriteActivty@this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        write_ok.setOnClickListener {
            
        }

    }
}