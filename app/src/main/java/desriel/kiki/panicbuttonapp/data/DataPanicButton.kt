package desriel.kiki.panicbuttonapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataPanicButton (
    val name: String,
    val location:Location?,
    val information: Information?,
    val status: String,
    val recent: String
):Parcelable
@Parcelize
data class Location (
    val kecamatan : String,
    val kelurahan : String,
    val namaJalan : String
):Parcelable
@Parcelize
data class Information (
    val waktuPemasangan : String,
    val recentMaintenance : String,
    val nextMaintenance : String,
    val paketPanicButton : String
):Parcelable