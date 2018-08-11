package juliyasmith.patchday

/**
 * Created by Juliya Smith on 8/6/18.
 */

import android.content.Context
import android.content.res.Resources
import java.text.DateFormat
import java.util.*

class DateHelper(context: Context) {

    val context = context

    fun createDateHelper(context: Context): DateHelper {
        return DateHelper(context)
    }

    fun formatDate(date: Date?): String {
        if (date != null) {
            val df = DateFormat.getDateInstance()
            return df.format(date)
        }

        val res = context.resources
        return res.getStringArray(R.array.PlaceHolders)[0]
    }

    fun formatTime(time: Time): String {
        val tf = DateFormat.getTimeInstance()
        return tf.format(time)
    }
}