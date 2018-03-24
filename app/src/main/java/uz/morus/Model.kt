package uz.morus

/**
 * $developer = Kadiroff
 * $project = Morus
 * $date = 3/24/18
 * $mail = jkadiroff@gmail.com
 * $github = github.com/kadiroff
 **/
object Model{

    data class Seller(val di : Int,
                      val name :String,
                      val last_name : String,
                      val phone : String,
                      val email: String,
                      val logo :String)

    data class SellerWrapper( val sellist : MutableList<Seller>)
}