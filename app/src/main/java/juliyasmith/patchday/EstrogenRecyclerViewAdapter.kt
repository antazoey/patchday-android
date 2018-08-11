package juliyasmith.patchday

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import juliyasmith.patchday.EstrogenFragment.OnEstrogenFragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_estrogen.view.*
import java.util.*

@RequiresApi(Build.VERSION_CODES.M)
/**
 * [RecyclerView.Adapter] that can display a EstrogenItem and makes a call to the
 * specified [OnEstrogenFragmentInteractionListener].
 */
class EstrogenRecyclerViewAdapter(
        private val mValues: List<EstrogenContent.Estrogen>,
        private val mListener: OnEstrogenFragmentInteractionListener?)
    : RecyclerView.Adapter<EstrogenRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    private var itemSelected = -1

    // Init the ViewAdapter
    init {
        // Init the OnClickListener onClick block.
        // v is the view that was clicked.
        mOnClickListener = View.OnClickListener { v ->
            val pos = v.tag as Int
            val estrogen = mValues[pos]
            itemSelected = pos
            v.setBackgroundColor(v.context.getColor(R.color.pdPink))

            // Notify activity that was clicked.
            mListener?.onEstrogenFragmentInteraction(estrogen)
        }
    }

    // ViewHolder holds the view in place so there is no need to call the old "findViewByID".
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_estrogen, parent, false)
        return ViewHolder(view)
    }

    // As more views load, this gets called. Sets UI elements of ViewHolder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.mView) {

            fun loadImage() {
                val img = ContextCompat.getDrawable(context, R.drawable.p_new)
                siteImage.setImageDrawable(img)
            }

            fun loadColor(position: Int) {
                when(position % 2) {
                    0 -> {
                        val color = ContextCompat.getColor(context, R.color.pdBlue)
                        setBackgroundColor(color)
                    }
                    else -> setBackgroundColor(Color.WHITE)
                }
            }

            tag = position
            setOnClickListener(mOnClickListener)
            loadImage()
            loadColor(position)
        }
    }

    override fun getItemCount(): Int = mValues.size

    // Makes RecyclerView faster. No need for findViewByID because of the ViewHolder.
    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val context: Context = mView.context
    }
}
