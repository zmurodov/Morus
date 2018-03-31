package uz.morus.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import uz.morus.Model
import uz.morus.R


/**
 * $developer = Kadiroff
 * $project = Morus
 * $date = 3/24/18
 * $mail = jkadiroff@gmail.com
 * $github = github.com/kadiroff
 **/

class SellerAdapter constructor(val data: MutableList<Model.Seller>) : RecyclerView.Adapter<SellerAdapter.SellerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SellerHolder {
        return SellerHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_seller, parent, false))

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SellerHolder?, position: Int) {
        holder?.bind(data[position])
    }

    inner class SellerHolder(view: View) : RecyclerView.ViewHolder(view) {
        var circleImageView = view.findViewById<ImageView>(R.id.ivSellerImage)
        var sellerName = view.findViewById<TextView>(R.id.tvSellerName)
        var sellerEmail = view.findViewById<TextView>(R.id.tvSellerEmail)
        var sellerTel = view.findViewById<TextView>(R.id.tvSellerTel)

        fun bind(seller: Model.Seller) {
            sellerName.text = seller.name
            sellerEmail.text = seller.email
            sellerTel.text = seller.phone
            Picasso.get()
                    .load("http://morus.uz/" + seller.logo)
                    .fit()
                    .centerCrop()
                    .into(circleImageView)
        }
    }
}