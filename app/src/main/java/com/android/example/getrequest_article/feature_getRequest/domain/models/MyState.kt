package com.android.example.getrequest_article.feature_getRequest.domain.models

data class MyState(
    val myPosts: List<PostsItem> = listOf(PostsItem("", 0, "",0))
)
