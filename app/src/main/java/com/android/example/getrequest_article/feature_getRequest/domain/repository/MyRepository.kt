package com.android.example.getrequest_article.feature_getRequest.domain.repository

import com.android.example.getrequest_article.feature_getRequest.domain.models.Posts

interface MyRepository {
    suspend fun getPosts() : Posts?
}