package run.acw.crew.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import run.acw.runningcrew.R

class NotificationsViewModel : ViewModel() {

    private val tabs : List<Int> = listOf(R.string.notification_tab_crew,R.string.notification_tab_my_running)

    fun getTabs(): List<Int> {
        return tabs
    }

    fun getTabTitle(position: Int): Int {
        return tabs[position]
    }
}