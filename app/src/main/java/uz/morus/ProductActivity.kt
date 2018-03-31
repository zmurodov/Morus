package uz.morus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.Menu
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_product.*
import uz.morus.api.ApiFactory
import uz.morus.fragment.UserFragment

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        setSupportActionBar(toolbar_prod)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = ""

//        var model: Model.SellerWrapper? = null
        var list: MutableList<Model.News>? = null

        ApiFactory.getMorus()
                .getNewsList(2063)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    list = it.news
                    Log.d("ZUFAR1", it.news.toString())
//                    Toast.makeText(this, it.news.toString(), Toast.LENGTH_LONG).show()
                }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        super.onSupportNavigateUp()
        onBackPressed()
        return true
    }

}
