package run.acw.crew.ui.history.personal

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView
import run.acw.crew.util.MySnackBar
import run.acw.runningcrew.R
import run.acw.runningcrew.databinding.FragmentPersonalRunningBinding
import java.util.concurrent.TimeUnit
const val MAX_TIME=356400L
class PersonalRecordFragment : Fragment() {
    private var _binding: FragmentPersonalRunningBinding? = null
    private val binding get() = _binding!!
    val personalPrepareViewModel by lazy{
        ViewModelProvider(this).get(PersonalRecordViewModel::class.java)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentPersonalRunningBinding.inflate(inflater, container, false)
        val root: View = binding.root

        personalPrepareViewModel.timeLeftInMillis.observe(viewLifecycleOwner) { timeInMillis ->
            binding.personalRunningTime.text = formatTime(timeInMillis)
        }

        binding.personalRunningPauseBtn.setOnClickListener{
            if(personalPrepareViewModel.countDownFlg){
                personalPrepareViewModel.pauseTimer()
                it.background=ContextCompat.getDrawable(requireContext(),R.drawable.start_btn)
            }
            else{
                personalPrepareViewModel.resumeTimer()
                it.background=ContextCompat.getDrawable(requireContext(),R.drawable.pause_btn)
            }

        }

        binding.personalRunningStopBtn.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    personalPrepareViewModel.onButtonTouchDown()
                    true
                }
                MotionEvent.ACTION_UP -> {
                    personalPrepareViewModel.onButtonTouchUp()
                    true
                }
                else -> false
            }
        }

        personalPrepareViewModel.isButtonEnabled.observe(viewLifecycleOwner) { isEnabled ->
            binding.personalRunningStopBtn.isEnabled = isEnabled
        }

        var anim: ObjectAnimator? = null
        personalPrepareViewModel.isButtonPressed.observe(viewLifecycleOwner) { isPressed ->
            if (isPressed) {
                // 버튼 눌림 상태
                // 원 가장자리를 채우는 애니메이션을 시작한다.
                anim = ObjectAnimator.ofInt(binding.personalRunningStopProgress, "progress", 0, 100)
                anim?.duration = 2000
                anim?.interpolator = LinearInterpolator()
                anim?.start()
            } else {
                // 버튼 눌림 상태 해제
                // 애니메이션을 중지한다.
                // ...
                anim?.cancel()
                binding.personalRunningStopProgress.progress = 0

            }
        }

        personalPrepareViewModel.message.observe(viewLifecycleOwner) { message ->
            if(message!="")MySnackBar.make(binding.root, message).show()
        }



        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        personalPrepareViewModel.startTimer(MAX_TIME*1000)
    }
    private fun formatTime(timeInMillis: Long): String {
        val timeAsc= (MAX_TIME*1000)-timeInMillis
        val hours = TimeUnit.MILLISECONDS.toHours(timeAsc)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(timeAsc) % 60
        val seconds = TimeUnit.MILLISECONDS.toSeconds(timeAsc) % 60
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
