package run.acw.crew.ui.history.personal

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonalRecordViewModel: ViewModel() {

    private var countDownTimer: CountDownTimer? = null
    private val _timeLeftInMillis = MutableLiveData<Long>()
    val timeLeftInMillis: LiveData<Long>
        get() = _timeLeftInMillis

    fun startTimer(timeInMillis: Long) {
        countDownTimer?.cancel()

        countDownTimer = object : CountDownTimer(timeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _timeLeftInMillis.value = millisUntilFinished
            }

            override fun onFinish() {
                _timeLeftInMillis.value = 0
            }
        }.start()
    }

    override fun onCleared() {
        super.onCleared()
        countDownTimer?.cancel()
    }
}