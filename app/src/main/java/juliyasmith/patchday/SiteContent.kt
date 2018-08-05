package juliyasmith.patchday

import java.util.*
import kotlin.collections.ArrayList

object SiteContent {

    val sites: MutableList<Site> = ArrayList()
    val site_map: MutableMap<UUID, Site> = HashMap()

    init {
        for (i in 0..3) {
            val id = UUID.randomUUID()
            val estrogen = Site(id)
            sites.add(estrogen)
            site_map[id] = estrogen
        }
    }

    private fun addPill(site: Site) {
        sites.add(site)
        site_map[site.id] = site
    }

    private fun createPill(id: UUID): Site {
        return Site(id)
    }

    data class Site(val id: UUID, val date: Date? = null,
                    val siteID: UUID? = null) {
        override fun toString(): String = "Estrogen"
    }

}
