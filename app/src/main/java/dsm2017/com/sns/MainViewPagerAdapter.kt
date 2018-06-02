package dsm2017.com.sns

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainViewPagerAdapter(mainActivity: MainActivity, viewpagerdata1: ArrayList<MainViewPageData>) : PagerAdapter() {

    var position = 0
    val mainViewPageData : ArrayList<MainViewPageData>
    val context: Context
    val layoutInflater: LayoutInflater

    init{
        this.mainViewPageData = viewpagerdata1
        this.context = mainActivity
        this.layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    }
//    constructor(context : Context , mainViewPageData: ArrayList<MainViewPageData> ) : this() {
    //}

    override fun getCount(): Int {
        return mainViewPageData.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = this.layoutInflater.inflate(R.layout.item_viewpager,container,false)

        this.position = position

            var number = view.findViewById<TextView>(R.id.main_viewpager_number)
            number.text = this.mainViewPageData.get(position).number

            var sport_name = view.findViewById<TextView>(R.id.main_sports_name)
            sport_name.text = this.mainViewPageData.get(position).sports_name

            var nickname = view.findViewById<TextView>(R.id.main_nickname)
            nickname.text = this.mainViewPageData.get(position).user_nickname

            var like = view.findViewById<TextView>(R.id.main_like)
            like.text = this.mainViewPageData.get(position).like

            var date = view.findViewById<TextView>(R.id.main_date)
            date.text = this.mainViewPageData.get(position).date

        container.addView(view)

        return view
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}