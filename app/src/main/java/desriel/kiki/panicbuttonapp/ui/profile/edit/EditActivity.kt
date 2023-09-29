package desriel.kiki.panicbuttonapp.ui.profile.edit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import androidx.activity.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import desriel.kiki.panicbuttonapp.MainActivity
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.databinding.ActivityEditBinding
import desriel.kiki.panicbuttonapp.ui.profile.ProfileViewModel
import desriel.kiki.panicbuttonapp.ui.otp.OtpActivity

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    private val profileViewModel: ProfileViewModel by viewModels()
    private var editActivity : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        editActivity = intent.getStringExtra("edit_activity")
        Log.d("edit activity"," edit activity = $editActivity")
        binding.editToolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("fragment_to_open", "profile_fragment")
            startActivity(intent)
        }
        when (editActivity) {
            "edit name" -> {
                binding.editToolbar.title = "Ubah Nama"
                binding.etEdit.hint = "Nama Lengkap Baru"
                profileViewModel.editName = false
                binding.etEdit.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_person, // Drawable kiri
                    0, // Drawable atas
                    0, // Drawable kanan
                    0 // Drawable bawah
                )

                binding.etEdit.inputType = InputType.TYPE_CLASS_TEXT
                binding.btnNext.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("fragment_to_open", "profile_fragment")
                    startActivity(intent)
                }
            }
            "edit number" -> {
                binding.editToolbar.title = "Ubah No. Seluler"
                binding.etEdit.hint = "No. Seluler Baru"
                binding.etEdit.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_phone, // Drawable kiri
                    0, // Drawable atas
                    0, // Drawable kanan
                    0 // Drawable bawah
                )
                profileViewModel.editNumber = false
                binding.etEdit.inputType = InputType.TYPE_CLASS_NUMBER
                binding.btnNext.setOnClickListener {
                    showNumberChangeDialog()
                }

            }
            else -> {
                binding.editToolbar.title = "Ubah Email"
                binding.etEdit.hint = "Email Baru"
                profileViewModel.editEmail = false
                binding.etEdit.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_email, // Drawable kiri
                    0, // Drawable atas
                    0, // Drawable kanan
                    0 // Drawable bawah
                )

                binding.etEdit.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS

                binding.btnNext.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("fragment_to_open", "profile_fragment")

                    startActivity(intent)
                }

            }
        }
    }
    private fun showNumberChangeDialog(){
        MaterialAlertDialogBuilder(this)
            .setTitle("Mengubah No. Seluler?")
            .setIcon(R.drawable.ic_warning)
            .setMessage("Apakah Anda yakin ingin mengubah nomor seluler? Pastikan nomor yang Anda masukkan masih aktif")
            .setNegativeButton("Cancel") { _, _ ->
                // Respond to negative button press
            }
            .setPositiveButton("Lanjutkan") { _, _ ->
                val intent = Intent(this, OtpActivity::class.java)
                startActivity(intent)            }
            .show()

    }

}