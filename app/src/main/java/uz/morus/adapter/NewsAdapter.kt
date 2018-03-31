package uz.morus.adapter

import android.annotation.SuppressLint
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mikhaellopez.circularimageview.CircularImageView
import com.squareup.picasso.Picasso
import uz.morus.Model
import uz.morus.R
import uz.morus.base.BaseActivity
import uz.morus.fragment.NewsDetailFragment
import uz.morus.main.MainActivity

/**
 * Created by Android Developer on 31.03.2018.
 */
class NewsAdapter constructor(var data: MutableList<Model.News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var callback: Callback? = null

//    fun setCallBack(callback: Callback) {
//        this.callback = callback
//    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_news, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(data[position])
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("WrongViewCast")
        var image = view.findViewById<ImageView>(R.id.ivNewsImage)
        var title = view.findViewById<TextView>(R.id.tvNewsTitle)
        var date = view.findViewById<TextView>(R.id.tvNewsDate)

        fun bind(model: Model.News) {
            itemView.setOnClickListener {
                callback?.onItemClick(model)
//                val curr = activity as MainActivity
//                curr.replaceFrag(NewsDetailFragment(model))
            }

            title.text = model.name
            date.text = model.date

            Picasso.get()
                    .load("http://morus.uz/" + model.picture)
//                    .fit()
//                    .centerCrop()
                    .into(image)
        }
    }

    interface Callback {
        fun onItemClick(news: Model.News)
    }


}