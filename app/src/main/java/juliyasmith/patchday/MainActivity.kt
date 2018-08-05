package juliyasmith.patchday

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.Fragment

class MainActivity : AppCompatActivity(), EstrogenFragment.OnEstrogenFragmentInteractionListener,
        PillFragment.OnPillFragmentInteractionListener,
        SiteFragment.OnSiteFragmentInteractionListener {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_estrogens -> {
                loadFragment(EstrogenFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_pills -> {
                loadFragment(PillFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sites -> {
                loadFragment(SiteFragment())
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

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, EstrogenFragment())
        transaction.commit()

    }

    override fun onEstrogenFragmentInteraction(estrogen: EstrogenContent.Estrogen?) {
        println(estrogen.toString())
    }

    override fun onPillFragmentInteraction(pill: PillContent.Pill?) {
        println(pill.toString())
    }

    override fun onSiteFragmentInteraction(site: SiteContent.Site?) {
        println(site.toString())
    }

}
