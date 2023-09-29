package desriel.kiki.panicbuttonapp.ui.home.panicButton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import desriel.kiki.panicbuttonapp.MainActivity
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.databinding.ActivityAddPanicButtonBinding

class AddPanicButtonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddPanicButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPanicButtonBinding.inflate(layoutInflater)
        binding.btnTambahkanSekarang.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.toolbarAddPanic.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        setContentView(binding.root)
    }
}