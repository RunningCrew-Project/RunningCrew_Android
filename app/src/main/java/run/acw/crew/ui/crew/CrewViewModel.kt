package run.acw.crew.ui.crew

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CrewViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Crew Fragment"
    }
    val text: LiveData<String> = _text
}