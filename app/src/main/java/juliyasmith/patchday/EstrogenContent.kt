package juliyasmith.patchday

import android.content.Context
import java.util.*
import kotlin.collections.ArrayList

class EstrogenContent(context: Context) {

    val context = context
    val estrogens: MutableList<Estrogen> = ArrayList()

    data class Estrogen(var context: Context, var i: Int,
                        var date: Date?=null,
                        var sitePtr: SiteContent.Site?=null,
                        var backupSiteName: String?=null) {
        override fun toString(): String = "$i Estrogen at date: ${DateHelper(context).formatDate(date)}"
    }

    init {
        for (i in 0..SettingsContent.estrogenCount) {
            val estrogen = createEstrogen(i)
            addEstrogen(estrogen)
        }
    }

    // Public

    fun getEstrogen(index: Int): Estrogen? {
        if (index >= 0 && index < estrogens.size) {
            return estrogens[index]
        }
        return null
    }

    fun setEstrogenDate(index: Int, newDate: Date) {
        getEstrogen(index)?.date = newDate
    }

    fun setEstrogenSite(index: Int, newSite: SiteContent.Site) {
        getEstrogen(index)?.sitePtr = newSite
    }

    // Private

    private fun addEstrogen(estrogen: Estrogen) {
        estrogens.add(estrogen)
    }

    private fun createEstrogen(index: Int): Estrogen {
        return Estrogen(context, index)
    }
}