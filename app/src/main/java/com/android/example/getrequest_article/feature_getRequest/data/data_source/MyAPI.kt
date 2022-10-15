package com.android.example.getrequest_article.feature_getRequest.data.data_source

import com.android.example.getrequest_article.feature_getRequest.domain.models.Posts
import retrofit2.http.GET

interface MyAPI {
    @GET("/posts")
    suspend fun getPosts() : Posts?
}