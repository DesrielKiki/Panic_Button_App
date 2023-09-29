package desriel.kiki.panicbuttonapp.ui.home.information

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import desriel.kiki.panicbuttonapp.MainActivity
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.data.DataPanicButton
import desriel.kiki.panicbuttonapp.databinding.ActivityInformasiBinding
import desriel.kiki.panicbuttonapp.ui.home.information.fragment.ListInformationFragmentDirections
import kotlin.math.log

class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformasiBinding
    private val informationViewModel : InformationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = findNavController(R.id.nav_host_fragment_information_activity)
        Log.d("information Activity", "is detail view = ${informationViewModel.detailView.value}")
        binding.infoToolbar.setNavigationOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
        }


        val openDetail = intent.getStringExtra("open_detail")
        val informationData = intent.getParcelableExtra<DataPanicButton>("information_data")
        if (openDetail != null) {
            val action = informationData?.let {
                ListInformationFragmentDirections.actionListInformationFragmentToDetailInformationFragment(
                    it
                )
            }
            if (action != null) {
                navController.navigate(action)
            }
        }
    }
}