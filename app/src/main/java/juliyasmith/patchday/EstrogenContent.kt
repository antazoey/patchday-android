package juliyasmith.patchday

import java.util.*
import kotlin.collections.ArrayList

object EstrogenContent {

    val estrogens: MutableList<Estrogen> = ArrayList()
    val estrogen_map: MutableMap<UUID, Estrogen> = HashMap()

    init {
        for (i in 0..3) {
            val id = UUID.randomUUID()
            val estrogen = Estrogen(id)
            estrogens.add(estrogen)
            estrogen_map[id] = estrogen
        }
    }

    private fun addEstrogen(estrogen: Estrogen) {
        estrogens.add(estrogen)
        estrogen_map[estrogen.id] = estrogen
    }

    private fun createEstrogen(id: UUID): Estrogen {
        return Estrogen(id)
    }

    data class Estrogen(val id: UUID, val date: Date?=null,
                        val siteID: UUID?=null, val backupSiteName: String?=null) {
        override fun toString(): String = "Estrogen"
    }

}