package run.acw.crew.ui.notifications.tabs.crew

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import run.acw.crew.ui.notifications.tabs.CrewNotificationAdapter
import run.acw.runningcrew.databinding.NotificationTabCrewBinding

class NotificationTabCrew : Fragment() {
    private var _binding: NotificationTabCrewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationTabCrewViewModel::class.java)

        _binding = NotificationTabCrewBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"onView")
        binding.tabCrewRecycler.apply{
            layoutManager=LinearLayoutManager(requireContext())
            adapter = CrewNotificationAdapter(diffUtil).apply { submitList(List(30){""}) }
        }


    }

    companion object {
        val TAG="NotificationTabCrew"
        private val diffUtil = object : DiffUtil.ItemCallback<String>() {
            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: String, newItem: String) =
                oldItem == newItem
        }
    }
}