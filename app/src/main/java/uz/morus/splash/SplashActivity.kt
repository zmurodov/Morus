package uz.morus.splash

import android.content.Intent
import android.os.Bundle
import uz.morus.base.BaseActivity
import uz.morus.base.C
import uz.morus.login.LoginActivity
import uz.morus.main.MainActivity


/**
 * $developer = JavokhirKadirov
 * $project = Morus
 * $date = 2/28/18
 * $web_site = https://kadirov.me
 * $email = kadirov.me@gmail.com
 * $github = github.com/javokhirkadirov
 * $linkidin = linkedin.com/in/javokhirkadirov
 **/

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(getPrefs().getBoolean(C.IS_LOGGED,false)){
            startActivity(Intent(this, LoginActivity::class.java))
        }else{
            startActivity(Intent(this, MainActivity::class.java))
        }
        finish()
    }
}
