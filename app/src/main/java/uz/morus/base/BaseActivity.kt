package uz.morus.base

import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity

/**
 * $developer = JavokhirKadirov
 * $project = Morus
 * $date = 2/28/18
 * $web_site = https://kadirov.me
 * $email = kadirov.me@gmail.com
 * $github = github.com/javokhirkadirov
 * $linkidin = linkedin.com/in/javokhirkadirov
 **/
open class BaseActivity : AppCompatActivity(){

    fun getPrefs() = PreferenceManager.getDefaultSharedPreferences(this)
}