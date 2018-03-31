package uz.morus.main

import android.content.Context
import android.os.Bundle

import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

import uz.morus.base.BaseActivity
import android.provider.MediaStore
import android.support.design.widget.NavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import uz.morus.Model
import uz.morus.R
import uz.morus.api.ApiFactory
import uz.morus.fragment.NewsDetailFragment
import uz.morus.fragment.NewsFragment
import uz.morus.fragment.SellersFragment
import uz.morus.fragment.UserFragment


/**
 * $developer = JavokhirKadirov
 * $project = Morus
 * $date = 2/28/18
 * $web_site = https://kadirov.me
 * $email = kadirov.me@gmail.com
 * $github = github.com/javokhirkadirov
 * $linkidin = linkedin.com/in/javokhirkadirov
 **/

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.app_name, R.string.app_name)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        var model: Model.News? = null
        ApiFactory.getMorus()
                .getNewsList(2063)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { model = it.news[0] }




        nav_view.setNavigationItemSelectedListener(this)
        nav_view.getHeaderView(0).setOnClickListener {
            replaceFrag(SellersFragment())
            drawer_layout.closeDrawer(GravityCompat.START)
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_delivery -> {

            }
            R.id.nav_product -> {

            }
            R.id.nav_favourite -> {

            }
            R.id.nav_menu -> {

            }
            R.id.nav_seller -> {

            }
            R.id.nav_price -> {

            }
            R.id.nav_message -> {

            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)


        return true
    }

    //    companion object {
    fun replaceFrag(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
//    }

    private fun addFrag(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
