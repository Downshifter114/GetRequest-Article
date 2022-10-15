package com.android.example.getrequest_article.feature_getRequest.data.repository

import com.android.example.getrequest_article.feature_getRequest.data.data_source.MyAPI
import com.android.example.getrequest_article.feature_getRequest.domain.models.Posts
import com.android.example.getrequest_article.feature_getRequest.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: MyAPI
) : MyRepository {
    override suspend fun getPosts(): Posts? {
        return api.getPosts()
    }
}