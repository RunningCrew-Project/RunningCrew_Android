package run.acw.crew

import android.view.View
import androidx.databinding.BindingAdapter


@BindingAdapter("onClick")
fun View.setOnClick(listener: View.OnClickListener?) {
    setOnClickListener(listener)
}
