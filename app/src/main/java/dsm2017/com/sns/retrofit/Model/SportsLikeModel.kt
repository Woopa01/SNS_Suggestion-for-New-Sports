package dsm2017.com.sns.retrofit.Model

class SportsLikeModel {

    lateinit var sports_like : List<SportsDatas>

    inner class SportsDatas{
        val sports_name : String = ""
        val sports_like : String = ""
        val user_name : String = ""
        val sports_date : String = ""
        val sports_serialnumber : String = ""
    }
}