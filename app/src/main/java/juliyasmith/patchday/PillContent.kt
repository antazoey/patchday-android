package juliyasmith.patchday

import java.util.*
import kotlin.collections.ArrayList

typealias Time = Date

object PillContent {

    val pills: MutableList<Pill> = ArrayList()

    data class Pill(var name: String="New Pill", var time1: Time=Time(), var time2: Time?=null,
                    var times_a_day: Int=1, var notify: Boolean=true, var timesTakenToday: Int=0) {
        override fun toString(): String = name
    }

    init {
        for (i in 0..3) {
            val pill = createPill()
            addPill(pill)
        }
    }

    private fun createPill(): Pill {
        return Pill()
    }

    private fun addPill(pill: Pill) {
        pills.add(pill)
    }

}
