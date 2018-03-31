package uz.morus.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import uz.morus.Model

import uz.morus.R

@SuppressLint("ValidFragment")
/**
 * $developer = JavokhirKadirov
 * $project = Morus
 * $date = 3/3/18
 * $web_site = https://kadirov.me
 * $email = kadirov.me@gmail.com
 * $github = github.com/javokhirkadirov
 * $linkidin = linkedin.com/in/javokhirkadirov
 **/
class UserFragment @SuppressLint("ValidFragment") constructor
(var list: MutableList<Model.Seller>) : Fragment() {


    private var root: View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater?.inflate(R.layout.fragment_user, container, false)
//        Toast.makeText(context, list.toString(), Toast.LENGTH_LONG).show()
        return root
    }


}