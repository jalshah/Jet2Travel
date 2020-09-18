package com.jalpa.jet2travel.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.jalpa.jet2travel.R
import com.jalpa.jet2travel.viewmodel.ArticleResponse
import com.jalpa.jet2travel.viewmodel.ArticleViewModel

class MainActivity : AppCompatActivity() ,Observer<ArticleResponse>{
    private var isLoading: Boolean = false

    private var pageNumber: Int = 0

    private lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadMore()

    }

    fun loadMore() {
        isLoading = true
        var viewModelMovieOutputs = ViewModelProvider(this@MainActivity as ViewModelStoreOwner)[ArticleViewModel::class.java]
        viewModelMovieOutputs.loadArticles(++pageNumber).observe(this@MainActivity as LifecycleOwner, this@MainActivity)
    }


    override fun onChanged(t: ArticleResponse?) {
        isLoading= false
        Log.e("onchange",t?.articles?.size.toString())
        if (t?.error == null) {
            if (pageNumber == 1) {
                if (t?.articles?.size!! > 0) {

                    findViewById<View>(R.id.empty_msg).visibility = View.GONE
                } else {
                    pageNumber--
                    findViewById<View>(R.id.empty_msg).visibility = View.VISIBLE
                }
            } else {
                if (t?.articles?.size!! == 0) {
                    pageNumber--
                    Toast.makeText(this@MainActivity, getString(R.string.no_more_items_found), Toast.LENGTH_LONG).show()
                }
                progress.visibility = View.GONE

            }
        } else {
            Toast.makeText(this@MainActivity, getString(R.string.error_msg), Toast.LENGTH_LONG).show()
        }
    }
}