package desriel.kiki.panicbuttonapp.ui.home.information.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.data.DataPanicButton
import desriel.kiki.panicbuttonapp.databinding.FragmentDetailInformationBinding
import desriel.kiki.panicbuttonapp.ui.home.information.InformationViewModel


class DetailInformationFragment : Fragment() {

    private var _binding : FragmentDetailInformationBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<DetailInformationFragmentArgs>()
    private val informationViewModel: InformationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailInformationBinding.inflate(inflater, container, false)
        informationViewModel.setDetailView(true)
        Log.d("detail fragment", "detail view  = ${informationViewModel.detailView}")
        binding.tvInformationTitle.text = args.informationData.name
        binding.tvDesc.text = args.informationData.recent
        return binding.root
    }


}