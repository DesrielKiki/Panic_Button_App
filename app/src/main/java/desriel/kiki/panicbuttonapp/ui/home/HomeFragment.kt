package desriel.kiki.panicbuttonapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.databinding.FragmentHomeBinding
import desriel.kiki.panicbuttonapp.ui.SharedViewModel
import desriel.kiki.panicbuttonapp.ui.home.information.InformationActivity
import desriel.kiki.panicbuttonapp.ui.home.information.adapter.InformationAdapter
import desriel.kiki.panicbuttonapp.ui.home.panicButton.AddPanicButtonActivity
import desriel.kiki.panicbuttonapp.ui.home.panicButton.adapter.PanicButtonAdapter
import desriel.kiki.panicbuttonapp.ui.login.Preference

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var preference : Preference
    private lateinit var panicButtonAdapter: PanicButtonAdapter
    private lateinit var rvPanicButton: RecyclerView
    private val viewModel : SharedViewModel by viewModels()


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        preference = Preference(requireContext())
        panicButtonAdapter = PanicButtonAdapter(preference)
        rvPanicButton = binding.rvPanicButton
        initRvPanicButton()
        initRvInformation()
        toggleLinearLayoutOrientation()


        binding.fabAddPanicButton.setOnClickListener {
            val intent = Intent(activity, AddPanicButtonActivity::class.java)
            startActivity(intent)
        }
        binding.tvLihatSemua.setOnClickListener {
            val intent = Intent(activity, InformationActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    private fun toggleLinearLayoutOrientation() {
        val layoutManager = LinearLayoutManager(requireContext())

        if (preference.viewType == panicButtonAdapter.viewTypeGrid) {
            binding.toggleButton.setImageResource(R.drawable.ic_list_view)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            binding.rvPanicButton.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT

        } else {
            binding.toggleButton.setImageResource(R.drawable.ic_grid_view)
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            binding.rvPanicButton.layoutParams.height = resources.getDimensionPixelSize(R.dimen.max_height_grid)
        }

        rvPanicButton.layoutManager = layoutManager
    }

    private fun initRvInformation(){
        val rvInformation = binding.rvInformation
        val informationAdapter = InformationAdapter()
        rvInformation.adapter = informationAdapter
        rvInformation.layoutManager = LinearLayoutManager(requireContext())
        informationAdapter.submitList(viewModel.dummyData)
    }
    private fun initRvPanicButton() {
        rvPanicButton.adapter = panicButtonAdapter
        panicButtonAdapter.submitList(viewModel.dummyData)
        if (viewModel.dummyData.isNotEmpty()) {
            binding.rvPanicButton.visibility = View.VISIBLE
            binding.bgEmptyState.visibility = View.GONE
        }
        binding.toggleButton.setOnClickListener {
            preference.viewType =
                if (preference.viewType == panicButtonAdapter.viewTypeList) panicButtonAdapter.viewTypeGrid else panicButtonAdapter.viewTypeList
            toggleLinearLayoutOrientation()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}