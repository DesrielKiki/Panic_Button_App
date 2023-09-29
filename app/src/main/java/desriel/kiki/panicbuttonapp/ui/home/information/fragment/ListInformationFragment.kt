package desriel.kiki.panicbuttonapp.ui.home.information.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.databinding.FragmentListInformationBinding
import desriel.kiki.panicbuttonapp.ui.SharedViewModel
import desriel.kiki.panicbuttonapp.ui.home.information.adapter.InformationAdapter

class ListInformationFragment : Fragment() {

    private var _binding : FragmentListInformationBinding? = null
    private val binding get() = _binding!!
    private val viewModel : SharedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListInformationBinding.inflate(inflater, container, false)
        val rvInformation = binding.rvInformation
        val adapter = InformationAdapter()
        rvInformation.adapter = adapter
        rvInformation.layoutManager = LinearLayoutManager(requireContext())
        adapter.submitList(viewModel.dummyData)
        return binding.root
    }

}