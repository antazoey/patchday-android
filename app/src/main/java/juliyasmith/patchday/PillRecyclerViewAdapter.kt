package juliyasmith.patchday

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import juliyasmith.patchday.PillFragment.OnPillFragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_pill.view.*

/**
 * [RecyclerView.Adapter] that can display a Pill and makes a call to the
 * specified [OnPillFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class PillRecyclerViewAdapter(
        private val mValues: List<PillContent.Pill>,
        private val mListener: OnPillFragmentInteractionListener?)
    : RecyclerView.Adapter<PillRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val pill = v.tag as PillContent.Pill
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onPillFragmentInteraction(pill)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_pill, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pill = mValues[position]
        holder.mIdView.text = pill.toString()

        with(holder.mView) {
            tag = pill
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
