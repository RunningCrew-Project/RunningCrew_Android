package run.acw.crew.ui.history.personal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.ads.AdRequest
import run.acw.crew.ui.history.HistoryViewModel
import run.acw.runningcrew.databinding.FragmentPersonalPrepareBinding

class PersonalPrepareFragment : Fragment() {

    private var _binding: FragmentPersonalPrepareBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val personalPrepareViewModel =
            ViewModelProvider(this).get(HistoryViewModel::class.java)

        _binding = FragmentPersonalPrepareBinding.inflate(inflater, container, false)
        val root: View = binding.root




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}