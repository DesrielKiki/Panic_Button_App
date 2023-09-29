package desriel.kiki.panicbuttonapp.ui.payment.page.tabmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import desriel.kiki.panicbuttonapp.R
import desriel.kiki.panicbuttonapp.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {

    private var _binding: FragmentPaymentBinding? = null
    private val binding get() = _binding!!
    private lateinit var pageAdapter: PaymentPageAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        pageAdapter = PaymentPageAdapter(requireActivity().supportFragmentManager, lifecycle)
        val tabLayout = binding.paymentTabLayout
        val viewPager = binding.paymentViewPager
        tabLayout.addTab(tabLayout.newTab().setText("Tagihan"))
        tabLayout.addTab(tabLayout.newTab().setText("Riwayat Pembayaran"))
        viewPager.adapter = pageAdapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager.currentItem = tab.position

                    val customTabView = tab.customView

                }
                when (tab?.position) {
                    0 -> {
                        // Set ukuran untuk Tab 1
                        tab.view.layoutParams.width =
                            resources.getDimensionPixelSize(R.dimen.tab1_width)
                        tabLayout.requestLayout()
                    }

                    1 -> {
                        // Set ukuran untuk Tab 2
                        tab.view.layoutParams.width =
                            resources.getDimensionPixelSize(R.dimen.tab2_width)
                        tabLayout.requestLayout()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}