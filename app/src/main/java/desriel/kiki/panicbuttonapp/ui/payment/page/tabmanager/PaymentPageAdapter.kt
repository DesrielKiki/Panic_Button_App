package desriel.kiki.panicbuttonapp.ui.payment.page.tabmanager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import desriel.kiki.panicbuttonapp.ui.payment.page.riwayat.RiwayatFragment
import desriel.kiki.panicbuttonapp.ui.payment.page.tagihan.TagihanFragment

class PaymentPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            TagihanFragment()
        else
            RiwayatFragment()
    }
}