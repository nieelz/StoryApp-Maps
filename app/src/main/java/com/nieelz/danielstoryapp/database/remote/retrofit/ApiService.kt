package com.nieelz.danielstoryapp.database.remote.retrofit

import com.nieelz.danielstoryapp.database.remote.body.BodyLogin
import com.nieelz.danielstoryapp.database.remote.body.BodyRegister
import com.nieelz.danielstoryapp.database.remote.response.FileUploadResponse
import com.nieelz.danielstoryapp.database.remote.response.LoginResponse
import com.nieelz.danielstoryapp.database.remote.response.LoginResult
import com.nieelz.danielstoryapp.database.remote.response.RegisterResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("/v1/login")
    fun loginStory(@Body bodyLogin: BodyLogin): Call<LoginResponse>

    @POST("/v1/register")
    fun registerStory(@Body body: BodyRegister): Call<RegisterResponse>


    @Multipart
    @POST("/v1/stories/guest")
    fun postImage(
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
    ): Call<FileUploadResponse>

}