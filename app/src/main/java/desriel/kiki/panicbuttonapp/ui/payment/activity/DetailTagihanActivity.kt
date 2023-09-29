package desriel.kiki.panicbuttonapp.ui.payment.activity

import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import desriel.kiki.panicbuttonapp.MainActivity
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.data.DataDetailTagihan
import desriel.kiki.panicbuttonapp.databinding.ActivityDetailTagihanBinding
import desriel.kiki.panicbuttonapp.ui.payment.page.tagihan.adapter.DetailAdapter

class DetailTagihanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTagihanBinding
    private lateinit var dataTagihan: DataDetailTagihan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTagihanBinding.inflate(layoutInflater)
        dataTagihan = intent.getParcelableExtra("data_tagihan")!!


        val textSalin = "SALIN"
        val spannableString = SpannableString(textSalin)
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                salinTeks(dataTagihan.kodeTagihan)
            }
        }
        spannableString.setSpan(
            clickableSpan,
            0,
            textSalin.length,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.tvSalin.text = spannableString
        binding.tvSalin.movementMethod = android.text.method.LinkMovementMethod.getInstance()



        binding.toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        setDetailContent()
        setContentView(binding.root)


    }

    fun salinTeks(teks: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.text = teks

        // Tampilkan pesan bahwa teks telah disalin
        Toast.makeText(this, "Teks telah disalin", Toast.LENGTH_SHORT).show()
    }

    private fun setDetailContent() {
        binding.tvKodeTagihan.text = dataTagihan.kodeTagihan
        binding.tvMetodePembayaran.text = dataTagihan.metodePembayaran
        val detailAdapter = DetailAdapter()
        binding.rvListTagihan.adapter = detailAdapter
        binding.rvListTagihan.layoutManager = LinearLayoutManager(this)
        detailAdapter.submitList(dataTagihan.tagihan)
        binding.tvTotal.text = "Rp ${dataTagihan.jumlahBayar},-"
        binding.tvTotalBayar.text = "Rp ${dataTagihan.jumlahBayar},-"
        binding.tvBiayaAdmin.text = "Rp ${dataTagihan.biayaAdmin},-"
        val biayaPaket = dataTagihan.tagihan.sumBy { it.biayaPaket }
        binding.tvSubtotalBiaya.text = "Rp ${biayaPaket.toString()},-"
        val totalBiaya = biayaPaket + dataTagihan.biayaAdmin
        binding.tvTotal.text = "Rp $totalBiaya ,-"
        binding.tvTotalBayar.text = "Rp $totalBiaya ,-"
        binding.tvStatus.text = dataTagihan.statusTagihan
        when (dataTagihan.statusTagihan) {
            "Menunggu Pembayaran" -> {
                binding.bgHeader.setBackgroundColor(ContextCompat.getColor(this, R.color.orange))
                binding.tvStatus.text = "Menunggu Pembayaran"
                binding.tvSubStatus.text =
                    "Silakan lakukan pembayaran tagihan paling ${dataTagihan.tanggalTagihan}"
                binding.ivStatus.setImageResource(R.drawable.ic_waiting_payment)
                binding.btnDetailBayar.text = "Bayar Sekarang"
                binding.btnDetailBayar.setOnClickListener {
                    dataTagihan.statusTagihan = "Pembayaran Selesai"
                    Log.d("Detail activity", "status set to selesai")
                    Log.d("Detail activity", "status pembayaran = ${dataTagihan.statusTagihan}")
                    recreate()
                }
            }

            "Pembayaran Selesai" -> {
                binding.bgHeader.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
                binding.tvStatus.text = "Pembayaran Selesai"
                binding.tvSubStatus.text =
                    "Terima kasih sudah melakukan pembayaran. Kamu dapat menghubungi bantuan apabila terjadi masalah terkait pembayaran"
                binding.ivStatus.setImageResource(R.drawable.ic_complete_payment)
                binding.btnDetailBayar.text = "Bantuan"
                binding.btnDetailBayar.setOnClickListener {

                }
            }

            "Pembayaran Pending" -> {
                binding.bgHeader.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow))
                binding.tvStatus.text = "Ups! Pembayaran Anda Pending"
                binding.tvSubStatus.text =
                    "Pembayaran Anda mengalami status pending. Mohon tunggu informasi lebih lanjut"
                binding.ivStatus.setImageResource(R.drawable.ic_pending_payment)
                binding.btnDetailBayar.text = "Bantuan"
                binding.btnDetailBayar.setOnClickListener {

                }

            }

            "Pembayaran Kedaluwarsa" -> {
                binding.bgHeader.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
                binding.tvStatus.text = "Ups! Tagihan Kedalulwarsa"
                binding.tvSubStatus.text =
                    "Pembayaran tidak dapat dilakukan. Harap hubungi Layanan Pelanggan kami untuk bantuan lebih lanjut. Terima kasih"
                binding.ivStatus.setImageResource(R.drawable.ic_expired_payment)
                binding.btnDetailBayar.text = "Bantuan"
                binding.btnDetailBayar.setOnClickListener {

                }
            }
        }
    }
}