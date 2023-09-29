package desriel.kiki.panicbuttonapp.ui.otp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import desriel.kiki.panicbuttonapp.MainActivity
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.databinding.ActivityOtp2Binding

class OtpActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityOtp2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtp2Binding.inflate(layoutInflater)

        val loginData = intent.getStringExtra("login_data")
        Log.d("otp activity 1", "login data = $loginData")

        if (loginData != null){
            binding.tvHeader.text = "Mendaftar Berhasil"
            binding.tvBody.text = "Data Anda telah terdaftar dalam aplikasi kami. Silakan masuk menggunakan nama, email, atau nomor HP"
        }
        binding.btnNext.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        setContentView(binding.root)
    }
}