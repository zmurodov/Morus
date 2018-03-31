package uz.morus

import com.google.gson.annotations.SerializedName

/**
 * $developer = Kadiroff
 * $project = Morus
 * $date = 3/24/18
 * $mail = jkadiroff@gmail.com
 * $github = github.com/kadiroff
 **/
object Model {

    data class Seller(val id: Int,
                      val name: String,
                      val last_name: String,
                      val phone: String,
                      val email: String,
                      val logo: String)

    data class News(val id: Int,
                    val name: String,
                    val picture: String,
                    val text: String,
                    val date: String)

    data class SellerWrapper(val sellist: MutableList<Seller>)

    data class NewsList(@SerializedName("detail") val news: MutableList<News>)

}