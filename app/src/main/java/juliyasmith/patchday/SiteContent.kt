package juliyasmith.patchday

import java.util.*
import kotlin.collections.ArrayList

object SiteContent {

    val sites: MutableList<Site> = ArrayList()

    data class Site(var index: Int, var name: String="New Site", var imageID: String?=null) {
        override fun toString(): String = "$name at index $index"
    }

    init {
        for (i in 0..3) {
            val site = createSite(i)
            addSite(site)
        }
    }

    private fun createSite(index: Int): Site {
        return Site(index)
    }

    private fun addSite(site: Site) {
        sites.add(site)
    }

}
