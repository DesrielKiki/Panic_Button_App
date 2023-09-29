package desriel.kiki.panicbuttonapp.ui.home.panicButton.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.data.DataPanicButton
import desriel.kiki.panicbuttonapp.databinding.ItemPanicButtonGridBinding
import desriel.kiki.panicbuttonapp.databinding.ItemPanicButtonListBinding
import desriel.kiki.panicbuttonapp.ui.home.panicButton.DetailPanicButtonActivity
import desriel.kiki.panicbuttonapp.ui.login.Preference

class PanicButtonAdapter(private val preference: Preference) :
    ListAdapter<DataPanicButton, RecyclerView.ViewHolder>(DiffCallback()) {
    val viewTypeList = 1
    val viewTypeGrid = 2

    // Implementasikan metode ini untuk menentukan jenis tampilan yang sesuai berdasarkan viewType

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            viewTypeList -> {
                val binding = ItemPanicButtonListBinding.inflate(inflater, parent, false)
                PanicListItemViewHolder(binding)
            }

            viewTypeGrid -> {
                val binding = ItemPanicButtonGridBinding.inflate(inflater, parent, false)
                PanicGridItemViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val dataItem = getItem(position)
        if (holder is PanicViewHolder) {
            holder.itemView.setOnClickListener {
                val context = holder.itemView.context
                val intent = Intent(context, DetailPanicButtonActivity::class.java)
                intent.putExtra("panic_data", dataItem)
                context.startActivity(intent)
            }

            holder.bindData(dataItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (preference.viewType == viewTypeGrid) viewTypeGrid else viewTypeList
    }


    // ViewHolder untuk tampilan daftar (list)
    class PanicListItemViewHolder(private val binding: ItemPanicButtonListBinding) :
        RecyclerView.ViewHolder(binding.root), PanicViewHolder {

        override fun bindData(dataItem: DataPanicButton) {
            binding.tvTitle.text = dataItem.name
            binding.tvStatus.text = dataItem.status
            binding.tvRecent.text = dataItem.recent
            when (dataItem.status) {
                "online" -> binding.ivStatus.setImageResource(R.drawable.ic_online)
                "maintenance" -> binding.ivStatus.setImageResource(R.drawable.ic_maintenance)
                "offline" -> binding.ivStatus.setImageResource(R.drawable.ic_offline)
            }
        }
    }

    // ViewHolder untuk tampilan grid
    class PanicGridItemViewHolder(private val binding: ItemPanicButtonGridBinding) :
        RecyclerView.ViewHolder(binding.root), PanicViewHolder {

        override fun bindData(dataItem: DataPanicButton) {
            binding.tvTitle.text = dataItem.name
            binding.tvStatus.text = dataItem.status
            binding.tvRecent.text = dataItem.recent
            when (dataItem.status) {
                "online" -> binding.ivStatus.setImageResource(R.drawable.ic_online)
                "maintenance" -> binding.ivStatus.setImageResource(R.drawable.ic_maintenance)
                "offline" -> binding.ivStatus.setImageResource(R.drawable.ic_offline)
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<DataPanicButton>() {
        override fun areItemsTheSame(oldItem: DataPanicButton, newItem: DataPanicButton): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: DataPanicButton, newItem: DataPanicButton
        ): Boolean {
            return oldItem == newItem
        }
    }
}
