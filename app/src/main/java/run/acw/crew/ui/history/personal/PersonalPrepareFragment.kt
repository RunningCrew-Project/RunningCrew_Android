package run.acw.crew.ui.history.personal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.ads.AdRequest
import run.acw.crew.ui.history.HistoryViewModel
import run.acw.crew.util.OnSwipeTouchListener
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
            ViewModelProvider(this).get(PersonalPrepareViewModel::class.java)

        _binding = FragmentPersonalPrepareBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.viewModel=personalPrepareViewModel

        val kiloInput=binding.personalPrepareInputKilo.root
        val timeInput=binding.personalPrepareInputTime.root

        kiloInput.visibility=View.VISIBLE
        timeInput.visibility=View.GONE
        var kiloVisible=true

        val inputLayerSwipeListener=object : OnSwipeTouchListener(requireContext()) {
            override fun onSwipeLeft() {
                Log.d("swipeText","swipeLeft")
                if (kiloVisible) {
                    kiloInput.visibility = View.GONE
                    timeInput.visibility = View.VISIBLE
                    kiloVisible = false
                }
            }
            override fun onSwipeRight() {
                Log.d("swipeText","swipeRight")
                if (!kiloVisible) {
                    kiloInput.visibility = View.VISIBLE
                    timeInput.visibility = View.GONE
                    kiloVisible = true
                }
            }
        }
        binding.personalPrepareInputLayer.setOnTouchListener(inputLayerSwipeListener)
        binding.personalPrepareInputKilo.personalPrepareInputLayerNextBtn.setOnClickListener {
            kiloInput.visibility = View.GONE
            timeInput.visibility = View.VISIBLE
            kiloVisible = false
        }
        binding.personalPrepareInputTime.personalInputLayerPrevBtn.setOnClickListener {
            kiloInput.visibility = View.VISIBLE
            timeInput.visibility = View.GONE
            kiloVisible = true
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}