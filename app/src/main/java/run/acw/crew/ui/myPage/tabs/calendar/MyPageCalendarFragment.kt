package run.acw.crew.ui.myPage.tabs.calendar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import run.acw.runningcrew.databinding.TabMyPageCalendarBinding

class MyPageCalendarFragment : Fragment() {
    private var _binding: TabMyPageCalendarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myPageCalendarViewModel =
            ViewModelProvider(this).get(MyPageCalendarViewModel::class.java)

        _binding = TabMyPageCalendarBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"onView")

    }

    companion object {
        val TAG="MyPageCalendar"
        private val diffUtil = object : DiffUtil.ItemCallback<String>() {
            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: String, newItem: String) =
                oldItem == newItem
        }
    }
}