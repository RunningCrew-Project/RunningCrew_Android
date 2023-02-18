package run.acw.crew.ui.history.personal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import run.acw.runningcrew.databinding.FragmentPersonalRunningBinding

class PersonalRecordFragment : Fragment() {

    private var _binding: FragmentPersonalRunningBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val personalPrepareViewModel =
            ViewModelProvider(this).get(PersonalRecordViewModel::class.java)

        _binding = FragmentPersonalRunningBinding.inflate(inflater, container, false)
        val root: View = binding.root



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}