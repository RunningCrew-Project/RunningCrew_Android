package run.acw.crew.ui.history.personal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import run.acw.runningcrew.R
import run.acw.runningcrew.databinding.FragmentPersonalRunningBinding
import java.util.concurrent.TimeUnit

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

        personalPrepareViewModel.timeLeftInMillis.observe(viewLifecycleOwner) { timeInMillis ->
            binding.personalRunningTime.text = formatTime(timeInMillis)
        }
        personalPrepareViewModel.startTimer(10000000)





        return root
    }
    private fun formatTime(timeInMillis: Long): String {
        val hours = TimeUnit.MILLISECONDS.toHours(timeInMillis)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(timeInMillis) % 60
        val seconds = TimeUnit.MILLISECONDS.toSeconds(timeInMillis) % 60
        return String.format    ("%02d:%02d:%02d", hours,minutes, seconds)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.GONE
    }

    override fun onPause() {
        super.onPause()
        activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.VISIBLE
    }
}
