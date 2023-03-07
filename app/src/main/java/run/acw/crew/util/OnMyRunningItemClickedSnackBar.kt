package run.acw.crew.util


import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import run.acw.runningcrew.R
import run.acw.runningcrew.databinding.SnackBarMyRunningTimeAlertBinding

class OnMyRunningItemClickedSnackBar(view: View, private val message: String){
    companion object {

        fun make(view: View, message: String) = OnMyRunningItemClickedSnackBar(view, message)
    }

    private val context = view.context
    private val snackbar = Snackbar.make(view, "", 10000)
    private val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

    private val inflater = LayoutInflater.from(context)
    private val snackbarBinding: SnackBarMyRunningTimeAlertBinding = DataBindingUtil.inflate(inflater, R.layout.snack_bar_my_running_time_alert, view as ViewGroup, false)

    init {
        initView()
        initData()
    }

    private fun initView() {

        with(snackbarLayout) {
            removeAllViews()
            setPadding(0, 0, 0, 0)
            addView(snackbarBinding.root, 0)
            val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
            params.gravity = Gravity.CENTER
            snackbarLayout.layoutParams = params

            setBackgroundColor(ContextCompat.getColor(context,R.color.time_alert_snack_bar_background))

        }
    }

    private fun initData() {
        snackbarBinding.snackbarText.text = message
        snackbarBinding.snackBarButton.setOnClickListener {
            snackbar.dismiss()
        }
    }
    fun delSnackBar(){
        snackbar.dismiss()
    }

    fun show() {
        snackbar.show()
    }
}