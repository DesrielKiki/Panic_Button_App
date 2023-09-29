package desriel.kiki.panicbuttonapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import desriel.kiki.panicbuttonapp.MainActivity
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.ui.login.daftar.DaftarActivity
import desriel.kiki.panicbuttonapp.ui.login.Preference

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPreferences = Preference(this)
        val loginData = sharedPreferences.login

        Log.d("splash activity", "login data = $loginData")
        Handler().postDelayed({
            if (loginData.isNullOrEmpty() || loginData.isBlank()){
                val intent = Intent(this, DaftarActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            finish()

        }, 2000)

    }
}