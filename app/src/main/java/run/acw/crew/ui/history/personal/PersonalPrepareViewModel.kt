package run.acw.crew.ui.history.personal

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import run.acw.runningcrew.R

class PersonalPrepareViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is personal prepare"
    }
    val text: LiveData<String> = _text

    fun onPersonalRunningStartBtnClicked(view: View){
        view.findNavController().navigate(R.id.action_navigation_personal_run_to_navigation_personal_run_count_down)
    }
}