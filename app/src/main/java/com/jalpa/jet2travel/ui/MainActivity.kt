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
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.jalpa.jet2travel.R
import com.jalpa.jet2travel.network.NetworkManager
import com.jalpa.jet2travel.viewmodel.ArticleResponse
import com.jalpa.jet2travel.viewmodel.ArticleViewModel

class MainActivity : AppCompatActivity() ,Observer<ArticleResponse>{
    private var isLoading: Boolean = false
    private var pageNumber: Int = 0
    private lateinit var progress: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageGridAdapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress = findViewById(R.id.progressBarLoading)
        recyclerView = findViewById(R.id.grid_view)
        recyclerView.apply{
            itemAnimator = DefaultItemAnimator()
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager?
                    if (isLoading == false  && layoutManager != null && layoutManager.findLastCompletelyVisibleItemPosition() == recyclerView.adapter!!.getItemCount() - 1) {
                        if (NetworkManager.isNetworkAvailable(this@MainActivity)) {
                            progress.setVisibility(View.VISIBLE)
                            recyclerView.isNestedScrollingEnabled = false
                            loadMore()
                        } else {
                            showNetMessage()
                        }
                    }
                }
            })
        }
        loadMore()

    }

    fun loadMore() {
        isLoading = true
        var viewModelMovieOutputs = ViewModelProvider(this@MainActivity as ViewModelStoreOwner)[ArticleViewModel::class.java]
        viewModelMovieOutputs.loadArticles(++pageNumber).observe(this@MainActivity as LifecycleOwner, this@MainActivity)
    }

    fun showNetMessage() {
        val mySnackbar: Snackbar = Snackbar.make(findViewById<View>(R.id.constraint_layout),
            R.string.poor_conn,
            Snackbar.LENGTH_LONG)
        mySnackbar.show()
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
                imageGridAdapter = ArticleAdapter(t.articles!!)
                recyclerView.adapter = imageGridAdapter
            } else {
                if (t?.articles?.size!! == 0) {
                    pageNumber--
                    Toast.makeText(this@MainActivity, getString(R.string.no_more_items_found), Toast.LENGTH_LONG).show()
                }
                else{
                    (recyclerView.adapter as ArticleAdapter).addItems(t.articles!!)
                }
                progress.visibility = View.GONE

            }
        } else {
            Toast.makeText(this@MainActivity, getString(R.string.error_msg), Toast.LENGTH_LONG).show()
        }
    }
}