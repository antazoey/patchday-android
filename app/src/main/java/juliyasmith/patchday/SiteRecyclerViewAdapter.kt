package juliyasmith.patchday

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import juliyasmith.patchday.SiteFragment.OnSiteFragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_site.view.*

/**
 * [RecyclerView.Adapter] that can display a Site and makes a call to the
 * specified [OnSiteFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class SiteRecyclerViewAdapter(
        private val mValues: List<SiteContent.Site>,
        private val mListener: OnSiteFragmentInteractionListener?)
    : RecyclerView.Adapter<SiteRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val site = v.tag as SiteContent.Site
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onSiteFragmentInteraction(site)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_site, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val site = mValues[position]
        holder.mIdView.text = site.toString()

        with(holder.mView) {
            tag = site
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
