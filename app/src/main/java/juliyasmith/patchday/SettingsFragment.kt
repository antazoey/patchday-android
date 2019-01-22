package juliyasmith.patchday

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SettingsFragment.OnSettingsInteractionListener] interface
 * to handle interaction events.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SettingsFragment : Fragment() {

    private var listener: OnSettingsFragmentInteractionListener? = null
    private var tv_minutesPriorSeekBar: SeekBar? = null
    private var deliveryMethodButton: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        tv_minutesPriorSeekBar = container?.findViewById(R.id.tv_minutesPriorValue)
        deliveryMethodButton = container?.findViewById(R.id.b_deliveryMethod)

        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    /*
    fun onMinutesPriorSlideBarSlid(uri: Uri) {
        listener?.onSettingsFragmentInteraction(uri)
    }
    */

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnSettingsFragmentInteractionListener) {
            listener = context

            deliveryMethodButton?.setOnClickListener {
                listener?.onMinutesPriorSeekBarSlid(20.0)
            }
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    interface OnSettingsFragmentInteractionListener {
        fun onMinutesPriorSeekBarSlid(newValue: Double)
    }

    companion object {

        @JvmStatic
        fun newInstance() = SettingsFragment()
    }
}
