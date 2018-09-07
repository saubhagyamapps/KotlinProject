package com.example.android.kotlinproject

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.app_bar_main2.*


class NavigationBar : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var a: String = "b"
    var b: String = "b"
    private val TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.framelaout_view, BlankFragment.newInstance(), "rageComicList")
                .commit()
        if (a.equals(b)) {
            Log.e(TAG, "hihihihihi")
        }
        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        val bundle = intent.extras
        val sample: String
        if (bundle != null) {
            sample = bundle.getString("testing")
            Toast.makeText(this, sample, Toast.LENGTH_LONG).show()
        }
        //   displayScreen(-1)
    }

    private fun displayScreen(id: Int) {
        val fragment = when (id) {

            R.id.nav_camera -> {
                Toast.makeText(this@NavigationBar, "BlankFragment", Toast.LENGTH_SHORT).show()
                BlankFragment()
            }
            R.id.nav_gallery -> {
                Toast.makeText(this@NavigationBar, "BlankFragment2", Toast.LENGTH_SHORT).show()
                BlankFragment2()
            }

            else -> {
                BlankFragment()
            }
        }


        supportFragmentManager.beginTransaction()
                .replace(R.id.framelaout_view, fragment)
                .commit()


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        displayScreen(item.itemId)
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
