package desriel.kiki.panicbuttonapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataDetailTagihan (
    val kodeTagihan : String,
    val tanggalTagihan : String,
    var statusTagihan : String,
    val metodePembayaran : String,
    val tagihan : List<DataTagihan>,
    val biayaAdmin : Int,
    var jumlahBayar : Int

):Parcelable
@Parcelize
data class DataTagihan (
    var id : String,
    val infoToko : DataPanicButton?,
    val biayaPaket : Int,
):Parcelable