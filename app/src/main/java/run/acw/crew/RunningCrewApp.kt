package run.acw.crew

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class RunningCrewApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

}