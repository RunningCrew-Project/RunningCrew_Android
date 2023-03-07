package run.acw.crew.ui.myPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import run.acw.runningcrew.R

class MyPageViewModel : ViewModel() {

    private val tabs: List<Int> =
        listOf(R.string.my_page_tab_my_running, R.string.my_page_tab_calendar)

    fun getTabs(): List<Int> {
        return tabs
    }

    fun getTabTitle(position: Int): Int {
        return tabs[position]
    }
}