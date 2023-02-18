package run.acw.crew.ui.history

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import run.acw.runningcrew.R
import run.acw.runningcrew.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {


    private var _binding: FragmentHistoryBinding? = null


    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val historyViewModel =
            ViewModelProvider(this).get(HistoryViewModel::class.java)


        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
        binding.viewModel=historyViewModel


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}