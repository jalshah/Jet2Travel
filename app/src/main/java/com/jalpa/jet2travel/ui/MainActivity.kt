package com.jalpa.jet2travel.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.jalpa.jet2travel.R
import com.jalpa.jet2travel.viewmodel.ArticleResponse
import com.jalpa.jet2travel.viewmodel.ArticleViewModel

class MainActivity : AppCompatActivity() ,Observer<ArticleResponse>{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewModelMovieOutputs = ViewModelProvider(this@MainActivity as ViewModelStoreOwner)[ArticleViewModel::class.java]
        viewModelMovieOutputs.loadArticles().observe(this@MainActivity as LifecycleOwner, this@MainActivity)
    }

    override fun onChanged(t: ArticleResponse?) {

    }
}