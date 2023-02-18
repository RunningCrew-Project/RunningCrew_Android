package run.acw.crew.ui.history

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import run.acw.runningcrew.R

class HistoryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun onPersonalRunningBtnClicked(view: View){
        view.findNavController().navigate(R.id.action_navigation_history_to_navigation_personal_run)
    }

}