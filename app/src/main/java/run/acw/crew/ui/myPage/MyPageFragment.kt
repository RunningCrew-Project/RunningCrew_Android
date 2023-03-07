package run.acw.crew.ui.myPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import run.acw.crew.ui.myPage.tabs.adapter.MyPageTabAdapter
import run.acw.runningcrew.databinding.FragmentMyPageBinding

class MyPageFragment : Fragment() {
    private var _binding: FragmentMyPageBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter:MyPageTabAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myPageViewModel =
            ViewModelProvider(this).get(MyPageViewModel::class.java)

        _binding = FragmentMyPageBinding.inflate(inflater, container, false)
        val root: View = binding.root


        adapter= MyPageTabAdapter(this)
        binding.myPageViewPager.adapter=adapter

        TabLayoutMediator(
            binding.tabMyPage, binding.myPageViewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.setText(
                getString(myPageViewModel.getTabTitle(position))
            )
        }.attach()

        adapter.apply{
            setTabs(myPageViewModel.getTabs())
        }




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}