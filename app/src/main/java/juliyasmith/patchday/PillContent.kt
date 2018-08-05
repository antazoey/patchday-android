package juliyasmith.patchday

import java.util.*
import kotlin.collections.ArrayList

object PillContent {

    val pills: MutableList<Pill> = ArrayList()
    val pill_map: MutableMap<UUID, Pill> = HashMap()

    init {
        for (i in 0..3) {
            val id = UUID.randomUUID()
            val pill = Pill(id)
            pills.add(pill)
            pill_map[id] = pill
        }
    }

    private fun addPill(pill: Pill) {
        pills.add(pill)
        pill_map[pill.id] = pill
    }

    private fun createPill(id: UUID): Pill {
        return Pill(id)
    }

    data class Pill(val id: UUID, val date: Date? = null,
                    val siteID: UUID? = null, val backupSiteName: String? = null) {
        override fun toString(): String = "Pill"
    }

}
