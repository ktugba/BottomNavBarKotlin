package com.example.bottomnavbarkotlin

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var anasayfaFragment: AnasayfaFragment
    lateinit var favoriFragment: FavoriFragment
    lateinit var profilFragment: ProfilFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //toolbarı setle
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Navigation Drawer"

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            (R.string.open),
            (R.string.close)
        ) {

        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        //Bottomnavigation bar tanımlanarak id si bağlanıyor
        val bottomNavigation: BottomNavigationView = findViewById(R.id.btm_nav)

        //Uygulama açıldığında Anasayfa fragmentinin default olarak açılmasını istediğimiz için burada da tanımlayacağız.
        anasayfaFragment = AnasayfaFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, anasayfaFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        //navigation bar için
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

    //navigation drawer için
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> {
                anasayfaFragment = AnasayfaFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, anasayfaFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_messages -> {
                favoriFragment = FavoriFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, favoriFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(this, "Messages clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_friends -> {
                profilFragment = ProfilFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, profilFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(this, "Friends clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_update -> {
                profilFragment = ProfilFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, profilFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(this, "Update clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_logout -> {
                profilFragment = ProfilFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, profilFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(this, "Sign out clicked", Toast.LENGTH_SHORT).show()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}
