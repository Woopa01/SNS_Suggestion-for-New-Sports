package dsm2017.com.sns

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import dsm2017.com.sns.ViewPager.MainViewPageData
import dsm2017.com.sns.ViewPager.MainViewPagerAdapter
import dsm2017.com.sns.retrofit.Connect
import dsm2017.com.sns.retrofit.Model.SportsLikeModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val category : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // LoadingActivity()

        val viewpagerdata1 = arrayListOf<MainViewPageData>()
        val viewpagerdata2 = arrayListOf<MainViewPageData>()


        viewpagerdata1.add(MainViewPageData(1.toString(), "네발로 걸으며 원반 물기", "성민", "좋아요 : 564", "2018.06.02"))
        viewpagerdata1.add(MainViewPageData(2.toString(), "누가 빨리 구르나 경기", "우진", "좋아요 : 332", "2018.06.02"))
        viewpagerdata1.add(MainViewPageData(3.toString(), "코끼리 코 3번돌고 한바퀴 뛰기", "주용", "좋아요 : 225", "2018.06.02"))
        viewpagerdata1.add(MainViewPageData(4.toString(), "눈 감고 똑바로 걷기 넘어지면 푸쉬업", "재훈", "좋아요 : 134", "2018.06.02"))
        viewpagerdata1.add(MainViewPageData(5.toString(), "공 높이 던져서 입으로 받기", "성민", "좋아요 : 67", "2018.06.02"))

        viewpagerdata2.add(MainViewPageData(1.toString(), "네발로 걸으며 원반 물기", "성민", "좋아요 : 564", "2018.06.02"))
        viewpagerdata2.add(MainViewPageData(2.toString(), "누가 빨리 구르나 경기", "우진", "좋아요 : 332", "2018.06.02"))
        viewpagerdata2.add(MainViewPageData(3.toString(), "코끼리 코 3번돌고 한바퀴 뛰기", "주용", "좋아요 : 225", "2018.06.02"))
        viewpagerdata2.add(MainViewPageData(4.toString(), "눈 감고 똑바로 걷기 넘어지면 푸쉬업", "재훈", "좋아요 : 134", "2018.06.02"))
        viewpagerdata2.add(MainViewPageData(5.toString(), "공 높이 던져서 입으로 받기", "성민", "좋아요 : 67", "2018.06.02"))



        val mainViewPagerAdapter1 = MainViewPagerAdapter(MainActivity@ this, viewpagerdata1)
        main_viewpager1.adapter = mainViewPagerAdapter1

        val mainViewPageAdapter2 = MainViewPagerAdapter(MainActivity@ this, viewpagerdata2)
        main_viewpager2.adapter = mainViewPageAdapter2

        main_viewpager1_detail.setOnClickListener {
            val intent = Intent(MainActivity@this,ShowListActivity::class.java)
            startActivity(intent)
            finish()
        }

        main_viewpager2_detail.setOnClickListener {
            val intent = Intent(MainActivity@this,ShowListActivity::class.java)
            startActivity(intent)
            finish()
        }

        fab.setOnClickListener {
            val intent = Intent(MainActivity@this,WriteSportsActivty::class.java)
            startActivity(intent)
            finish()
        }

        main_mypage.setOnClickListener {
            val intent = Intent(MainActivity@this,MyPageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

     fun LoadingActivity() {
        val map = hashMapOf<String,String>("category" to category)

         Connect.api.ShowMainRequest(map)
                 .enqueue(object : retrofit2.Callback<SportsLikeModel>{

                     override fun onResponse(call: Call<SportsLikeModel>?, response: Response<SportsLikeModel>?) {
                         var res = response!!.body()
                         res!!.sports_like.forEach {
                             var sports_name = it.sports_name
                             var user_name = it.user_name
                             var sports_like = it.sports_like
                             var sports_date = it.sports_date
                             var sports_serialnumber = it.sports_serialnumber
                             Log.d("DEBUG","$sports_name")
                         }
                     }

                     override fun onFailure(call: Call<SportsLikeModel>?, t: Throwable?) {
                         Toast.makeText(baseContext,"안되잖아",Toast.LENGTH_SHORT).show()
                     }
                 })
     }
}
