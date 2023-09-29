package desriel.kiki.panicbuttonapp.ui.home.information.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import desriel.kiki.panicbuttonapp.data.DataPanicButton
import desriel.kiki.panicbuttonapp.databinding.ItemInformationBinding
import desriel.kiki.panicbuttonapp.ui.home.information.InformationActivity
import desriel.kiki.panicbuttonapp.ui.home.information.fragment.DetailInformationFragment

class InformationAdapter :
    ListAdapter<DataPanicButton, InformationAdapter.ViewHolder>(DiffCallback()) {
    class ViewHolder(private val binding: ItemInformationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : DataPanicButton) {
            binding.tvTitleInformation.text = data.name
            binding.tvInformationBody.text = data.recent
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemInformationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, InformationActivity::class.java)
            intent.putExtra("open_detail", "from_adapter")
            intent.putExtra("information_data", data)
            context.startActivity(intent)
        }
        holder.bind(data)
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