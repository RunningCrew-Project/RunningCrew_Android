package run.acw.crew.ui.history.personal

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import run.acw.runningcrew.R
import run.acw.runningcrew.databinding.FragmentCountDownBinding

class CountdownFragment : Fragment() {

    private var _binding: FragmentCountDownBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountDownBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    private val timer = object : CountDownTimer(5000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val seconds = (millisUntilFinished / 1000)+1
            binding.countDownText.text = seconds.toString()
        }

        override fun onFinish() {
            this@CountdownFragment.findNavController().navigate(R.id.action_navigation_personal_run_count_down_to_navigation_personal_run_record)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        timer.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer.cancel()
    }
}
