package run.acw.crew.ui.history.personal

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

const val long_message="기록을 중지하시려면 정지버튼을\n2초 이상 누르세요"
class PersonalRecordViewModel: ViewModel() {

    private var countDownTimer: CountDownTimer? = null

    private val _timeLeftInMillis = MutableLiveData<Long>()
    val timeLeftInMillis: LiveData<Long>
        get() = _timeLeftInMillis

    var countDownFlg=false

    private var pressStartTime: Long = 0
    private var pressedDuration: Long = 0

    private val _isButtonEnabled = MutableLiveData<Boolean>(true)
    val isButtonEnabled: LiveData<Boolean>
        get() = _isButtonEnabled

    private val _isButtonPressed = MutableLiveData<Boolean>(false)
    val isButtonPressed: LiveData<Boolean>
        get() = _isButtonPressed

    private val _message=MutableLiveData<String>("")
    val message: LiveData<String>
        get() = _message

    fun onButtonTouchDown() {
        pressStartTime = System.currentTimeMillis()
        _isButtonPressed.postValue(true)
    }

    fun onButtonTouchUp() {
        if (isButtonPressed.value!!) {
            pressedDuration = System.currentTimeMillis() - pressStartTime
            if (pressedDuration >= 2000) {
                // 2초 이상 눌렀을 때
                _isButtonEnabled.postValue(false)
                // 새 fragment로 이동
                // ...
            } else {
                // 2초 이하로 눌렀을 때
                _message.postValue(long_message)
            }
            _isButtonPressed.postValue(false)
        }
    }

    fun reset() {
        _isButtonEnabled.postValue(true)
        _isButtonPressed.postValue(false)
    }
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
        countDownFlg=true
    }

    fun pauseTimer(){
        countDownTimer?.cancel()
        countDownFlg=false
    }
    fun resumeTimer(){
        countDownTimer = object : CountDownTimer(timeLeftInMillis.value!!, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _timeLeftInMillis.value = millisUntilFinished
            }

            override fun onFinish() {
                _timeLeftInMillis.value = 0
            }
        }.start()
        countDownFlg=true
    }


    override fun onCleared() {
        super.onCleared()
        countDownTimer?.cancel()
    }
}