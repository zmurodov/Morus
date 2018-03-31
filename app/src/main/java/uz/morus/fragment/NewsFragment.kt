package uz.morus.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import uz.morus.Model
import uz.morus.R
import uz.morus.adapter.NewsAdapter
import uz.morus.api.ApiFactory

/**
 * Created by Android Developer on 31.03.2018.
 */
class NewsFragment : Fragment() {
    var root: View? = null
    var list: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater?.inflate(R.layout.fragment_news, container, false)
        list = root?.findViewById(R.id.listNews)
        var data: MutableList<Model.News>? = null

        list?.layoutManager = LinearLayoutManager(context)
        ApiFactory.getMorus()
                .getNewsList(2063)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Toast.makeText(context, it.news.size.toString(), Toast.LENGTH_LONG).show()
                    list?.adapter = NewsAdapter(it.news)
                }
        return root
    }
}