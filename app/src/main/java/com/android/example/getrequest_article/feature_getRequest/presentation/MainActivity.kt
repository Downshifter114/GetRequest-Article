package com.android.example.getrequest_article.feature_getRequest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.example.getrequest_article.feature_getRequest.domain.models.Posts
import com.android.example.getrequest_article.feature_getRequest.domain.models.PostsItem
import com.android.example.getrequest_article.ui.theme.GetRequest_ArticleTheme
import com.android.example.getrequest_article.ui.theme.Purple200
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Monitor()
        }
    }
}

@Composable
fun Monitor(
    viewModel: MyViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    viewModel.getPostsOnScreen()
    LazyColumn(modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(state.myPosts) {post ->
            PostComposable(post)
        }
    }
}

@Composable
fun PostComposable(postsItem: PostsItem) {
    androidx.compose.material.Surface(color = Color.LightGray) {
        Column {
            Text(text = "ID: ${postsItem.id}")
            Text(text = "UserID: ${postsItem.userId}")
            Text(text = "Title: ${postsItem.title}")
            Text(text = "Body:\n${postsItem.body}")
        }
    }
}