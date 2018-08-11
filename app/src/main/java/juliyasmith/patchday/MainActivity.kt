package juliyasmith.patchday

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity(), EstrogenFragment.OnEstrogenFragmentInteractionListener,
        PillFragment.OnPillFragmentInteractionListener,
        SiteFragment.OnSiteFragmentInteractionListener,
        EditEstrogenFragment.OnEditEstrogenFragmentInteractionListener,
        SettingsFragment.OnSettingsFragmentInteractionListener {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_estrogens -> {
                title = resources.getString(R.string.estrogenTitle_p)
                loadFragment(EstrogenFragment.newInstance(1))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_pills -> {
                title = resources.getString(R.string.pillTitle)
                loadFragment(PillFragment.newInstance(1))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sites -> {
                title = resources.getString(R.string.siteTitle)
                loadFragment(SiteFragment.newInstance(1))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, fragment)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = resources.getString(R.string.estrogenTitle_p)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        loadFragment(EstrogenFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_action, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        loadFragment(SettingsFragment())
        return true
    }

    override fun onEstrogenFragmentInteraction(estrogen: EstrogenContent.Estrogen?) {
        loadFragment(EditEstrogenFragment())
        println(estrogen.toString())
    }

    override fun onEditEstrogenFragmentInteraction(uri: Uri) {

    }

    override fun onSettingsFragmentInteraction(uri: Uri) {

    }

    override fun onPillFragmentInteraction(pill: PillContent.Pill?) {
        println(pill.toString())
    }

    override fun onSiteFragmentInteraction(site: SiteContent.Site?) {
        println(site.toString())
    }

}
