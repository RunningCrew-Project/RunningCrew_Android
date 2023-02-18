package run.acw.crew


import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.material.bottomnavigation.BottomNavigationView
import run.acw.crew.ui.history.HistoryFragment
import run.acw.runningcrew.R
import run.acw.runningcrew.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MobileAds.initialize(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_history,
                R.id.navigation_crew,
                R.id.navigation_notifications,
                R.id.navigation_myPage
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)//actionbar설정
        navView.setupWithNavController(navController) //bottom navigation bar 설정.

        supportActionBar?.hide()




    }
}