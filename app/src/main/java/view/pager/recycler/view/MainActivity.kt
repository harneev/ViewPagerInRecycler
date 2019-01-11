package view.pager.recycler.view

import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View

import java.util.ArrayList

import view.pager.recycler.R
import view.pager.recycler.model.Data
import view.pager.recycler.model.PagerItem

/**
 * @author Harneev Sethi
 *
 *
 * PS: Navigation Drawer has been referenced from Android hive
 *
 * @see [Android Hive](https://www.androidhive.info/2013/11/android-sliding-menu-using-navigation-drawer/)
 */

class MainActivity : AppCompatActivity() {

    private var navigationView: NavigationView? = null
    private var drawer: DrawerLayout? = null
    private var toolbar: Toolbar? = null

    private var mHandler: Handler? = null

    // toolbar titles respected to selected nav menu item
    private var navigationTitles: Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        mHandler = Handler()

        drawer = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        // load toolbar titles from string resources
        navigationTitles = resources.getStringArray(R.array.nav_item_activity_titles)

        // initializing navigation menu
        setUpNavigationView()

        loadFragment(NestedViewPagerFragment())
    }

    private fun loadFragment(fragment: Fragment?) {

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        val mPendingRunnable = Runnable {
            // update the main content by replacing fragments
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

            fragmentTransaction.replace(R.id.frame, fragment!!)
            fragmentTransaction.commitAllowingStateLoss()
        }

        mHandler!!.post(mPendingRunnable)

        //Closing drawer on item click
        drawer!!.closeDrawers()

    }

    private fun setUpNavigationView() {

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView!!.setNavigationItemSelectedListener { item ->
            var fragment: Fragment? = null

            when (item.itemId) {

                R.id.nav_view_pager_item_recycler -> fragment = NestedViewPagerFragment()

                R.id.nav_recycler_item_recycler -> fragment = NestedRecyclerFragment()
            }

            loadFragment(fragment)

            true
        }

        val actionBarDrawerToggle = object : ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

        }

        //Setting the actionbarToggle to drawer layout
        drawer!!.setDrawerListener(actionBarDrawerToggle)

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState()
    }


}
