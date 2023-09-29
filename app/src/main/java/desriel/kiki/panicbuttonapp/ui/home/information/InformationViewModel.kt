package desriel.kiki.panicbuttonapp.ui.home.information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InformationViewModel: ViewModel() {
    private val _detailView = MutableLiveData<Boolean>()
    val detailView: LiveData<Boolean> = _detailView

    // Fungsi untuk mengubah nilai detailView
    fun setDetailView(value: Boolean) {
        _detailView.value = value
    }
}