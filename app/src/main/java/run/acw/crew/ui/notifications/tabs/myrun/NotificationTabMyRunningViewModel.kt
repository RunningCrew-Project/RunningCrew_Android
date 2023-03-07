package run.acw.crew.ui.notifications.tabs.myrun

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import run.acw.runningcrew.R
import run.acw.runningcrew.databinding.RecyclerViewItemMyRunningNotificationBinding

class NotificationTabMyRunningViewModel : ViewModel(),OnMyRunningItemClickListener {
    private var _earlyMsg = MutableLiveData<Int>()
    val earlyMsg: LiveData<Int> = _earlyMsg

    override fun onItemClicked(item: RecyclerViewItemMyRunningNotificationBinding) {
        _earlyMsg.postValue(R.string.notification_alert_early_time)
    }

    init {
        Log.d("Viewmodel",_earlyMsg.value.toString())
    }
    fun resetMsg(){
        _earlyMsg=MutableLiveData<Int>()
    }
}