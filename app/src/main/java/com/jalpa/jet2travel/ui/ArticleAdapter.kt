package com.jalpa.jet2travel.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.jalpa.jet2travel.R
import com.jalpa.jet2travel.viewmodel.Article
import com.jalpa.jet2travel.getFormatedCount
import com.jalpa.jet2travel.getFormatedTime

class ArticleAdapter(private var articles: List<Article>) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ArticleViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = articles.size


    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
       holder.bind(articles[position])
    }



    class ArticleViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_layout, parent, false)) {
         var avtar: ShapeableImageView
         var name: TextView
         var designation: TextView
         var time: TextView
         var image: ImageView
         var content: TextView
         var title: TextView
         var url: TextView
         var likes: TextView
         var comments: TextView

        init {
            avtar = itemView.findViewById(R.id.avtar)
            name = itemView.findViewById(R.id.name)
            designation = itemView.findViewById(R.id.designation)
            time = itemView.findViewById(R.id.time)
            image = itemView.findViewById(R.id.image)
            content = itemView.findViewById(R.id.content)
            title = itemView.findViewById(R.id.title)
            url = itemView.findViewById(R.id.url)
            likes = itemView.findViewById(R.id.likes)
            comments = itemView.findViewById(R.id.comments)
        }

        fun bind(article: Article) {
            name.text = article.user.get(0)?.name
            designation.text = article.user.get(0)?.designation
            time.text = article.date
            content.text = article.content

            if (article.media.size>0) {
                title.visibility = View.VISIBLE
                title.text = article.media[0].title
            }else{
                title.visibility =View.GONE
            }

            if (article.media.size>0) {
                url.visibility = View.VISIBLE
                url.text = article.media[0]?.url
            }else{
                url.visibility = View.GONE
            }

            likes.text = article.likes.toString() +likes.context.getString(R.string.likes)
            comments.text = article.commentCount.toString()+comments.context.getString(R.string.comments)

            Glide.with(avtar.context).load(article.user.get(0).avtar)
                .centerCrop()
                .into(avtar)

            if (article.media.isEmpty() ){
                image.visibility = View.GONE
            }else if (!article.media[0].imageUrl.isNullOrEmpty()){
                image.visibility = View.VISIBLE
                Glide.with(image.context).load(article.media.get(0).imageUrl)
                    .centerCrop()
                    .into(image)
            }
        }
    }
}
