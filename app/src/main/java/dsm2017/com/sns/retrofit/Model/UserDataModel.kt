package dsm2017.com.sns.retrofit.Model

class UserDataModel {

    lateinit var user : List<UserDatas>

    inner class UserDatas{
        var user_token : String = ""
        var user_name : String = ""
    }
}