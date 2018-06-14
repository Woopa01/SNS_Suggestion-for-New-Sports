package dsm2017.com.sns.retrofit.Model

class FeedBackListModel {

    lateinit var feedback : List<FeedBackDatas>

    inner class FeedBackDatas{
        val feedback_title =""
        val user_name = ""
        val sport_name = ""
        val feedback_context = ""
        val feedback_date = ""
        val feedback_serialnum = ""
        val user_token = ""
    }
}