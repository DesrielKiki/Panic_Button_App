package desriel.kiki.panicbuttonapp.ui.login.masuk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.core.content.ContextCompat
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.databinding.ActivityMasukBinding
import desriel.kiki.panicbuttonapp.ui.login.daftar.DaftarActivity
import desriel.kiki.panicbuttonapp.ui.otp.OtpActivity

class MasukActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMasukBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMasukBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnMasuk.setOnClickListener {
            val intent = Intent(this, OtpActivity::class.java)
            intent.putExtra("login_data","masuk_data")
            startActivity(intent)
        }
        linkedText()
    }

    private fun linkedText() {
        val intentToDaftar = Intent(this, DaftarActivity::class.java)

        val fullText = getString(R.string.belum_punya_akun)
        val spannableString = SpannableString(fullText)

// Mencari indeks awal dan akhir dari teks "Masuk" dalam string
        val startIndex = fullText.indexOf("Daftar")
        val endIndex = startIndex + "Daftar".length

// Membuat ClickableSpan untuk teks "Masuk"
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                // Aksi yang ingin Anda lakukan ketika teks "Masuk" diklik
                // Misalnya, navigasi ke halaman masuk
                // Di sini, Anda dapat memanggil fungsi untuk menangani klik "Masuk"
                // Contoh: startActivity(Intent(this, LoginActivity::class.java))
                startActivity(intentToDaftar)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                // Mengatur tampilan teks yang dapat diklik (misalnya, warna dan dekorasi)
                ds.isUnderlineText = true // Membuat teks terlihat seperti tautan
                ds.color =
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.blue
                    ) // Mengatur warna teks
            }
        }

// Menambahkan ClickableSpan ke SpannableString
        spannableString.setSpan(
            clickableSpan,
            startIndex,
            endIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

// Menerapkan SpannableString ke TextView
        binding.tvBelumPunyaAkun.text = spannableString
        binding.tvBelumPunyaAkun.movementMethod = LinkMovementMethod.getInstance()

    }

}