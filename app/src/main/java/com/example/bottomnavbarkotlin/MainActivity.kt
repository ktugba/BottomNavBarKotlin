package com.example.bottomnavbarkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var anasayfaFragment: AnasayfaFragment
    lateinit var favoriFragment: FavoriFragment
    lateinit var profilFragment: ProfilFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Bottomnavigation bar tanımlanarak id si bağlanıyor
        val bottomNavigation: BottomNavigationView = findViewById(R.id.btm_nav)

        //Uygulama açıldığında Anasayfa fragmentinin default oalrak açılmasını istediğimiz için burada da tanımlayacağız.
        anasayfaFragment = AnasayfaFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, anasayfaFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        bottomNavigation.setOnNavigationItemSelectedListener { item ->

            // 3 tane fragment oluşturulur; navigation bardaki her bir item bir fragmente denk gelecek.
            when (item.itemId) {

                R.id.home -> {
                    anasayfaFragment = AnasayfaFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, anasayfaFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.favorite -> {
                    favoriFragment = FavoriFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, favoriFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.profile -> {
                    profilFragment = ProfilFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, profilFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }


            }

            true

        }
    }
}
