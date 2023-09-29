package desriel.kiki.panicbuttonapp.ui.payment.page.tagihan.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import desriel.kiki.panicbuttonapp.data.DataTagihan
import desriel.kiki.panicbuttonapp.databinding.ItemTagihanBinding

class TagihanAdapter(
) : ListAdapter<DataTagihan, TagihanAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(val binding: ItemTagihanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataTagihan) {
            binding.tvNamaToko.text = data.infoToko?.name
            binding.tvHargaTagihan.text = "Rp${data.biayaPaket}"
            Log.d("tagihan adapter", "data tagihan = $data")
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTagihanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DataTagihan,
            newItem: DataTagihan
        ): Boolean {
            return oldItem == newItem
        }
    }
}
