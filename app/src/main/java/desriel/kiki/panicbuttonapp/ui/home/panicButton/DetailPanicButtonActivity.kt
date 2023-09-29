package desriel.kiki.panicbuttonapp.ui.home.panicButton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import desriel.kiki.panicbuttonapp.MainActivity
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.data.DataPanicButton
import desriel.kiki.panicbuttonapp.databinding.ActivityDetailPanicButtonBinding

class DetailPanicButtonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPanicButtonBinding
    private lateinit var panicData: DataPanicButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPanicButtonBinding.inflate(layoutInflater)
        panicData = intent.getParcelableExtra("panic_data")!!
        binding.detailPanicToolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        setDetailContent()
        setContentView(binding.root)
    }

    private fun setDetailContent() {
        binding.tvName.text = panicData.name
        binding.tvStatus.text = panicData.status
        binding.tvRecent.text = panicData.recent
        binding.tvKelurahan.text = panicData.location?.kelurahan
        binding.tvKecamatan.text = panicData.location?.kecamatan
        binding.tvNamaJalan.text = panicData.location?.namaJalan
        binding.tvWaktuPemasangan.text = panicData.information?.waktuPemasangan
        binding.tvRecentMaintenance.text = panicData.information?.recentMaintenance
        binding.tvPaketPanic.text = panicData.information?.paketPanicButton
        binding.tvNextMaintenance.text = panicData.information?.nextMaintenance
        when (panicData.status) {
            "online" -> binding.tvStatus.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_online,
                0,
                0,
                0
            )

            "maintenance" -> binding.tvStatus.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_maintenance,
                0,
                0,
                0
            )

            "offline" -> binding.tvStatus.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_offline,
                0,
                0,
                0
            )
        }

    }
}