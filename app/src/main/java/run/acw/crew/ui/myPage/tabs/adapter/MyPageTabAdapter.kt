package run.acw.crew.ui.myPage.tabs.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import run.acw.crew.ui.notifications.tabs.crew.NotificationTabCrew
import run.acw.crew.ui.notifications.tabs.myrun.NotificationTabMyRunning

class MyPageTabAdapter (private val fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    private var tabs: List<Int> = ArrayList()
    var fragments: ArrayList<Fragment> = ArrayList()

    override fun createFragment(position: Int): Fragment {
        // 프래그먼트를 반환하는 코드
        return fragments[position]
    }

    override fun getItemCount(): Int {
        return tabs.size
    }

    fun setTabs(tabs: List<Int>) {
        this.tabs = tabs
        addFragment(NotificationTabCrew())
        addFragment(NotificationTabMyRunning())
    }

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
        notifyItemInserted(fragments.size - 1)
    }

    fun removeFragment() {
        fragments.removeLast()
        notifyItemRemoved(fragments.size)
    }

}