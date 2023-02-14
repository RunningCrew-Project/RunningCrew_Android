package run.acw.crew.ui.crew

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import run.acw.runningcrew.databinding.FragmentCrewBinding

class CrewFragment : Fragment() {

    private var _binding: FragmentCrewBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val crewViewModel =
            ViewModelProvider(this).get(CrewViewModel::class.java)

        _binding = FragmentCrewBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCrew
        crewViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}