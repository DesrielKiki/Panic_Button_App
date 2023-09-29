package desriel.kiki.panicbuttonapp.ui.payment.page.tagihan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import desriel.kiki.panicbuttonapp.data.DataDetailTagihan
import desriel.kiki.panicbuttonapp.data.DataTagihan
import desriel.kiki.panicbuttonapp.databinding.ItemRincianPembayaranBinding
import desriel.kiki.panicbuttonapp.databinding.ItemTagihanBinding

class DetailAdapter : ListAdapter<DataTagihan, DetailAdapter.ViewHolder>(DiffCallback()) {
    class ViewHolder(private val binding: ItemRincianPembayaranBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataTagihan) {
            binding.tvNamaToko.text = data.infoToko?.name
            val alamatToko = "${data.infoToko?.location?.namaJalan}"
            val subAlamat = "${data.infoToko?.location?.kecamatan}, ${data.infoToko?.location?.kelurahan}"
            binding.tvAlamatToko.text = alamatToko
            binding.tvSubAlamatToko.text = subAlamat
            binding.tvHargaTagihan.text = "Rp ${data.biayaPaket},-"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRincianPembayaranBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    private class DiffCallback : DiffUtil.ItemCallback<DataTagihan>() {
        override fun areItemsTheSame(
            oldItem: DataTagihan,
            newItem: DataTagihan
        ): Boolean {
            return oldItem.infoToko?.name == newItem.infoToko?.name
        }

        override fun areContentsTheSame(
            oldItem: DataTagihan, newItem: DataTagihan
        ): Boolean {
            return oldItem == newItem
        }
    }

}