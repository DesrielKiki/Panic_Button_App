package desriel.kiki.panicbuttonapp.ui.payment.page.tagihan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.databinding.FragmentTagihanBinding
import desriel.kiki.panicbuttonapp.ui.SharedViewModel
import desriel.kiki.panicbuttonapp.ui.home.information.adapter.InformationAdapter
import desriel.kiki.panicbuttonapp.ui.payment.page.tagihan.adapter.DetailTagihanAdapter
import desriel.kiki.panicbuttonapp.ui.payment.page.tagihan.adapter.TagihanAdapter


class TagihanFragment : Fragment() {
    private var _binding : FragmentTagihanBinding? = null
    private val binding get() = _binding!!
    private lateinit var detailTagihanAdapter: DetailTagihanAdapter
    private lateinit var tagihanAdapter : TagihanAdapter
    private val sharedViewModel : SharedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTagihanBinding.inflate(inflater, container, false)
        val rvDetailTagihan = binding.rvDetailTagihan
        tagihanAdapter = TagihanAdapter()
        detailTagihanAdapter= DetailTagihanAdapter(tagihanAdapter, requireContext())
        rvDetailTagihan.adapter = detailTagihanAdapter
        rvDetailTagihan.layoutManager = LinearLayoutManager(requireContext())
        detailTagihanAdapter.submitList(sharedViewModel.detailTagihanData)

        return binding.root
    }


}