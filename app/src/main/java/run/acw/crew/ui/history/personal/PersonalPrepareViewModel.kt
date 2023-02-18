package run.acw.crew.ui.history.personal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonalPrepareViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is personal prepare"
    }
    val text: LiveData<String> = _text
}