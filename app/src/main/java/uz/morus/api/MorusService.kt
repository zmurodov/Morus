package uz.morus.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uz.morus.Model

/**
 * $developer = Kadiroff
 * $project = Morus
 * $date = 3/24/18
 * $mail = jkadiroff@gmail.com
 * $github = github.com/kadiroff
 **/
interface MorusService{

    @GET("sellerslist/list.php?{page}")
    fun getSellerList(@Path("order_id") page: Int ) : Observable<Model.SellerWrapper>

}