package uz.morus.fragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import uz.morus.Model

import uz.morus.R
import uz.morus.adapter.SellerAdapter
import uz.morus.api.ApiFactory


/**
 * A simple [Fragment] subclass.
 */
class SellersFragment : Fragment() {
    var list: RecyclerView? = null
    var root: View? = null



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        root = inflater!!.inflate(R.layout.fragment_sellers, container, false)
//        list = root?.findViewById(R.id.listSellers)
//        list?.layoutManager = LinearLayoutManager(context)
//        var data: MutableList<Model.Seller>? = null
//        ApiFactory.getMorus()
//                .getSellerList(1)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe { data = it.sellist }
//        list?.adapter = SellerAdapter(data!!)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}
