package desriel.kiki.panicbuttonapp.ui.otp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import desriel.kiki.panicbuttonapp.MainActivity
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.databinding.ActivityOtpBinding
import desriel.kiki.panicbuttonapp.ui.login.Preference

class OtpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOtpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        val sharedPreferences = Preference(this)

        setContentView(binding.root)
        val loginData = intent.getStringExtra("login_data")

        Log.d("otp activity", "login Data = $loginData")
        when (loginData) {
            "masuk_data" -> {
                binding.btnKirim.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    sharedPreferences.login = "login"
                    startActivity(intent)
                }
            }

            else -> {
                binding.btnKirim.setOnClickListener {
                    val intent = Intent(this, OtpActivity2::class.java)
                    intent.putExtra("login_data", loginData)
                    sharedPreferences.login = "login"
                    startActivity(intent)


                }
            }


        }
    }
}