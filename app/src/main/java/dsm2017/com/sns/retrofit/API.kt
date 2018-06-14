package dsm2017.com.sns.retrofit

import dsm2017.com.sns.WriteFeedBackActivity
import dsm2017.com.sns.retrofit.Model.EmailCodeModel
import dsm2017.com.sns.retrofit.Model.FeedBackListModel
import dsm2017.com.sns.retrofit.Model.SportsLikeModel
import dsm2017.com.sns.retrofit.Model.UserDataModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface API {

    @POST("/show/feedback/list")
    @FormUrlEncoded
    fun ShowFeedBackListRequest(@FieldMap map: HashMap<String, String>) : Call<FeedBackListModel>

    @POST("/signup")
    @FormUrlEncoded
    fun SignupRequest(@FieldMap map : HashMap<String, String>) : Call<ResponseBody>

    @POST("/signin")
    @FormUrlEncoded
    fun SigninRequest(@FieldMap map : HashMap<String, String>) : Call<UserDataModel>

    @POST("/check/email")
    @FormUrlEncoded
    fun EmailCodeRequest(@FieldMap map : HashMap<String, String>) : Call<EmailCodeModel>

    @POST("/show/list/sports")
    @FormUrlEncoded
    fun ShowMainRequest(@FieldMap map: HashMap<String, String>) : Call<SportsLikeModel>

    @POST("/insert/sports")
    @FormUrlEncoded
    fun WriteSportsRequest(@FieldMap map: HashMap<String,String> ) : Call<ResponseBody>

    @POST("/insert/feedback")
    @FormUrlEncoded
    fun WriteFeedBackRequset(@FieldMap map: HashMap<String, String> ) : Call<ResponseBody>

    @POST("/update/name")
    @FormUrlEncoded
    fun ModifyNameRequest(@FieldMap map: HashMap<String, String>) : Call<Void>

    @POST("/update/password")
    @FormUrlEncoded
    fun ModifyPasswordRequest(@FieldMap map: HashMap<String, String>) : Call<Void>

}