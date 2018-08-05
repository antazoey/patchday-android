package juliyasmith.patchday

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import juliyasmith.patchday.EstrogenFragment.OnEstrogenFragmentInteractionListener

import kotlinx.android.synthetic.main.fragment_estrogen.view.*

/**
 * [RecyclerView.Adapter] that can display a EstrogenItem and makes a call to the
 * specified [OnEstrogenFragmentInteractionListener].
 */
class EstrogenRecyclerViewAdapter(
        private val mValues: List<EstrogenContent.Estrogen>,
        private val mListener: OnEstrogenFragmentInteractionListener?)
    : RecyclerView.Adapter<EstrogenRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as EstrogenContent.Estrogen
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onEstrogenFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_estrogen, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val estrogen = mValues[position]
        holder.mIdView.text = estrogen.toString()

        with(holder.mView) {
            tag = estrogen
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
