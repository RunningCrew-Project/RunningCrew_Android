package run.acw.crew.util

import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import run.acw.runningcrew.R
import run.acw.runningcrew.databinding.SnackBarStopButtonBinding

class OnRecordStopButtonClickedSnackBar(view: View, private val message: String) {
    companion object {

        fun make(view: View, message: String) = OnRecordStopButtonClickedSnackBar(view, message)
    }

    private val context = view.context
    private val snackbar = Snackbar.make(view, "", 1000)
    private val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

    private val inflater = LayoutInflater.from(context)
    private val snackbarBinding: SnackBarStopButtonBinding= DataBindingUtil.inflate(inflater, R.layout.snack_bar_stop_button, null, false)

    init {
        initView()
        initData()
    }

    private fun initView() {
        with(snackbarLayout) {
            removeAllViews()
            setPadding(0, 0, 0, 0)
            background = ContextCompat.getDrawable(context,R.drawable.history_buttons)
            addView(snackbarBinding.root, 0)
        }
    }

    private fun initData() {
        snackbarBinding.snackbarText.text = message
    }

    fun show() {
        snackbar.show()
    }
}