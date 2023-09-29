package desriel.kiki.panicbuttonapp.ui.payment.page.riwayat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.databinding.FragmentRiwayatBinding
import desriel.kiki.panicbuttonapp.ui.SharedViewModel
import desriel.kiki.panicbuttonapp.ui.payment.page.tagihan.adapter.RiwayarAdapter
import desriel.kiki.panicbuttonapp.ui.payment.page.tagihan.adapter.TagihanAdapter


class RiwayatFragment : Fragment() {

    private var _binding: FragmentRiwayatBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel : SharedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRiwayatBinding.inflate(inflater, container, false)
        val tagihanAdapter = TagihanAdapter()
        val riwayatAdapter = RiwayarAdapter(tagihanAdapter, requireContext())
        binding.rvRiwayatPembayaran.adapter = riwayatAdapter
        binding.rvRiwayatPembayaran.layoutManager = LinearLayoutManager(requireContext())
        riwayatAdapter.submitList(sharedViewModel.detailTagihanData)
        return binding.root
    }

}