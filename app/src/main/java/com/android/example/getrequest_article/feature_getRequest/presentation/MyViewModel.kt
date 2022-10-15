package com.android.example.getrequest_article.feature_getRequest.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.getrequest_article.feature_getRequest.domain.models.MyState
import com.android.example.getrequest_article.feature_getRequest.domain.models.Posts
import com.android.example.getrequest_article.feature_getRequest.domain.models.PostsItem
import com.android.example.getrequest_article.feature_getRequest.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {
    private val _state = mutableStateOf(MyState())
    val state: State<MyState> = _state

    fun getPostsOnScreen() {
        viewModelScope.launch {
            var response: Posts? = null
            try {
                response = repository.getPosts()
            } catch (e: Exception) {
                Log.i("MyTag", e.toString())
            }
            if (response != null) {
                _state.value = state.value.copy(myPosts = response.toList())
            }
            else
                _state.value = state.value.copy(myPosts = listOf(PostsItem("", 0,"",0)))
        }
    }
}