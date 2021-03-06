package ctfz.trustarea.client.network.interfaces


import ctfz.trustarea.client.network.data.Response
import ctfz.trustarea.client.network.data.UserNetworkEntityResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


interface UserApi {

    @GET("users")
    fun user(@Header("Authorization") session_token: String, @Query("username") username: String?): Call<Response<UserNetworkEntityResponse>> // If user not exist - create

    @GET("users")
    fun users(@Header("Authorization") session_token: String): Call<Response<List<UserNetworkEntityResponse>>>

    @GET("users/me")
    fun profile(@Header("Authorization") session_token: String): Call<Response<UserNetworkEntityResponse>>  // Get user by token

}

