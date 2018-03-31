package uz.morus.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import uz.morus.Model
import uz.morus.R
import uz.morus.adapter.NewsAdapter
import uz.morus.api.ApiFactory

@SuppressLint("ValidFragment")
/**
 * Created by Android Developer on 31.03.2018.
 */
class NewsDetailFragment @SuppressLint("ValidFragment")
constructor(var model: Model.News?) : Fragment() {
    var root: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater?.inflate(R.layout.fragment_news_detail, container, false)
        val image = root?.findViewById<ImageView>(R.id.ivNewsDetailImg)
        val title = root?.findViewById<TextView>(R.id.tvNewsTitle)
        val date = root?.findViewById<TextView>(R.id.tvNewsDate)
        val text = root?.findViewById<TextView>(R.id.tvNewsText)

        if (model != null) {
            Toast.makeText(context, model.toString(), Toast.LENGTH_LONG).show()
            title?.text = model!!.name
            date?.text = model?.date
            text?.text = model?.text?.replace("<p>", "")
                    ?.replace("</p>", "")
            Picasso.get()
                    .load("http://morus.uz/" + model?.picture)
                    .into(image)
        }
        return root
    }
}