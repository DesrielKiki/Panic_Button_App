package desriel.kiki.panicbuttonapp.ui.payment.page.tagihan.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.data.DataDetailTagihan
import desriel.kiki.panicbuttonapp.databinding.ItemDetailTagihanBinding
import desriel.kiki.panicbuttonapp.ui.payment.activity.DetailTagihanActivity

class DetailTagihanAdapter(
    private var tagihanAdapter: TagihanAdapter,
    private val context: Context
) : ListAdapter<DataDetailTagihan, DetailTagihanAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(val binding: ItemDetailTagihanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataDetailTagihan, tagihanAdapter: TagihanAdapter, context: Context) {
            binding.tvKodeTagihan.text = data.kodeTagihan
            val tanggalTagihan = data.tanggalTagihan
            binding.tvJatuhTempo.text = "Bayar sebelum $tanggalTagihan"
            binding.rvDetailTagihan.adapter = tagihanAdapter
            binding.rvDetailTagihan.layoutManager = LinearLayoutManager(context)
            binding.tvTotalTagihan.text = "Rp${data.tagihan.sumBy { it.biayaPaket }},-"
            when (data.statusTagihan) {
                "Menunggu Pembayaran" -> {
                    binding.tvStatusTagihan.setBackgroundResource(R.drawable.bg_corner_orange)
                    binding.tvStatusTagihan.text = "Menunggu"
                }

                "Pembayaran Selesai" -> {
                    binding.tvStatusTagihan.setBackgroundResource(R.drawable.bg_corner_blue)
                    binding.tvStatusTagihan.text = "Selesai"

                }

                "Pembayaran Pending" -> {
                    binding.tvStatusTagihan.setBackgroundResource(R.drawable.bg_corner_yellow)
                    binding.tvStatusTagihan.text = "Pending"

                }

                "Pembayaran Kedaluwarsa" -> {
                    binding.tvStatusTagihan.setBackgroundResource(R.drawable.bg_corner_red)
                    binding.tvStatusTagihan.text = "Kedaluwarsa"

                }
            }
            tagihanAdapter.submitList(data.tagihan)

            Log.d("detail tagihan adapter", "tagihan $position ${data.tagihan}")
            binding.btnBayar.setOnClickListener {
                val intent = Intent(context, DetailTagihanActivity::class.java)
                intent.putExtra("data_tagihan", data)
                context.startActivity(intent)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemDetailTagihanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)

        // Buat daftar baru untuk adapter tagihan
        val tagihanList = data.tagihan

        // Set daftar baru ke adapter tagihan
        Log.d("data tagihan", "data tagihan = $tagihanList")
        // Perbarui daftar yang ditampilkan oleh adapter tagihan
        holder.binding.rvDetailTagihan.adapter?.notifyDataSetChanged()

        holder.bind(data, tagihanAdapter, context)
    }

    private class DiffCallback : DiffUtil.ItemCallback<DataDetailTagihan>() {
        override fun areItemsTheSame(
            oldItem: DataDetailTagihan,
            newItem: DataDetailTagihan
        ): Boolean {
            return oldItem.kodeTagihan == newItem.kodeTagihan
        }

        override fun areContentsTheSame(
            oldItem: DataDetailTagihan,
            newItem: DataDetailTagihan
        ): Boolean {
            return oldItem.tagihan == newItem.tagihan
        }
    }
}

