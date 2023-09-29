package desriel.kiki.panicbuttonapp.ui.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.databinding.FragmentProfileBinding
import desriel.kiki.panicbuttonapp.ui.login.daftar.DaftarActivity
import desriel.kiki.panicbuttonapp.ui.login.Preference
import desriel.kiki.panicbuttonapp.ui.profile.edit.EditActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val profileViewModel: ProfileViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        val navigateToEdit = Intent(activity, EditActivity::class.java)

        binding.btnKeluar.setOnClickListener {
            showLogOutDialog()
        }
        binding.bgNamaUser.setOnClickListener {
            navigateToEdit.putExtra("edit_activity", "edit name")
            startActivity(navigateToEdit)

            profileViewModel.editName = true
            Log.d("state from fragment", "edit name = ${profileViewModel.editName}")
        }
        binding.bgUserNumber.setOnClickListener {
            navigateToEdit.putExtra("edit_activity", "edit number")
            startActivity(navigateToEdit)

            profileViewModel.editNumber
            Log.d("state from fragment", "edit number = ${profileViewModel.editNumber}")

        }
        binding.bgEmail.setOnClickListener {
            navigateToEdit.putExtra("edit_activity", "edit email")
            startActivity(navigateToEdit)

            profileViewModel.editEmail
            Log.d("state from fragment", "edit email = ${profileViewModel.editEmail}")

        }
        return binding.root
    }
    private fun showLogOutDialog(){
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Logoout Account")
            .setIcon(R.drawable.logout_alert)
            .setMessage("Apakah Anda yakin ingin keluar? Jika ingin masuk kembali, gunakan nama dan email atau nomor seluler Anda")
            .setNegativeButton("Cancel") { _, _ ->
                // Respond to negative button press
            }
            .setPositiveButton("Logout") { _, _ ->
                val preference = Preference(requireContext())
                preference.clearLogin()
                val intent = Intent(activity, DaftarActivity::class.java)
                startActivity(intent)
            }
            .show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}