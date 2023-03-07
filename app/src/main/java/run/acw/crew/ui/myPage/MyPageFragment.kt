package run.acw.crew.ui.myPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import run.acw.crew.ui.notifications.NotificationsViewModel
import run.acw.crew.ui.notifications.tabs.adapter.NotificationTabLayoutAdapter
import run.acw.runningcrew.databinding.FragmentMyPageBinding
import run.acw.runningcrew.databinding.FragmentNotificationsBinding

class MyPageFragment : Fragment() {
    private var _binding: FragmentMyPageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var adapter:

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        adapter= NotificationTabLayoutAdapter(this)
        binding.notificationViewPager.adapter=adapter

        TabLayoutMediator(
            binding.tabNotification, binding.notificationViewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.setText(
                getString(notificationsViewModel.getTabTitle(position))
            )
        }.attach()

        adapter.apply{
            setTabs(notificationsViewModel.getTabs())
        }




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}