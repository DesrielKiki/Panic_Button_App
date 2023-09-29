package desriel.kiki.panicbuttonapp.ui

import androidx.lifecycle.ViewModel
import desriel.kiki.panicbuttonapp.data.DataDetailTagihan
import desriel.kiki.panicbuttonapp.data.DataPanicButton
import desriel.kiki.panicbuttonapp.data.DataTagihan
import desriel.kiki.panicbuttonapp.data.Information
import desriel.kiki.panicbuttonapp.data.Location

class SharedViewModel : ViewModel() {
    val dummyData = createDummyData()
    val detailTagihanData = createDetailTagihan()
    private fun createDummyData(): List<DataPanicButton> {
        val dummyList = mutableListOf<DataPanicButton>()

        // Tambahkan data dummy ke dalam list
        dummyList.add(
            DataPanicButton(
                "Toko Jaya Abadi",
                Location("Wonossalam", "Kadilangu", "Jl. botorejo no 5"),
                Information(
                    "9 desember 2005",
                    "9 desember 2022",
                    "9 desember 2023",
                    "paket tahunan"
                ),
                "online",
                "15:00"
            )
        )
        dummyList.add(
            DataPanicButton(
                "Toko Maju Mundur",
                Location("Gajah Mungkur", "Kintelan", "Jl. Kintelan nomor 5"),
                Information(
                    "30 april 2006",
                    "30 april 2022",
                    "30 april 2023",
                    "paket tahunan"
                ),
                "offline",
                "10:00"
            )
        )
        dummyList.add(
            DataPanicButton(
                "Toko Mau Mundur",
                Location("Sendang Mulyo", "Klipang", "Jl. Klipang indah nomor 7"),
                Information(
                    "25 desember 208",
                    "30 april 2022",
                    "03 november 2023",
                    "paket tahunan"
                ),
                "maintenance",
                "17:00"
            )
        )
        dummyList.add(
            DataPanicButton(
                "Toko C", Location("a", "b", "c"), null, "Status C", "Recent C"
            )
        )
        dummyList.add(DataPanicButton("Toko D", null, null, "Status D", "Recent D"))

        // Tambahkan data dummy lainnya sesuai kebutuhan

        return dummyList
    }

    private fun createDetailTagihan(): List<DataDetailTagihan> {
        val dummyTagihan = mutableListOf<DataDetailTagihan>()
        val tagihan1 = DataTagihan(
            "",
            DataPanicButton(
                "Toko Jaya Abadi",
                Location("Wonossalam", "Kadilangu", "Jl. botorejo no 5"),
                Information(
                    "9 desember 2005",
                    "9 desember 2022",
                    "9 desember 2023",
                    "paket tahunan"
                ),
                "online",
                "15:00"
            ),
            100000,
        )

        val tagihan2 = DataTagihan(
            "",
            DataPanicButton(
                "Toko Maju Mundur",
                Location("Gajah Mungkur", "Kintelan", "Jl. Kintelan nomor 5"),
                Information(
                    "30 april 2006",
                    "30 april 2022",
                    "30 april 2023",
                    "paket tahunan"
                ),
                "offline",
                "10:00"
            ),
            125000
        )

        val tagihan3 = DataTagihan(
            "",
            DataPanicButton(
                "Toko Maju Jaya",
                Location("Gajah Mungkur", "Lempinsari", "Jl. Lempong nomor 7"),
                Information(
                    "30 april 2006",
                    "30 april 2022",
                    "30 april 2023",
                    "paket tahunan"
                ),
                "online",
                "10:00"
            ),
            250000
        )

        dummyTagihan.add(
            DataDetailTagihan(
                "MKSHWU67",
                "1 september 2022",
                "Pembayaran Selesai",
                "bank bca",
                listOf(tagihan1, tagihan2),
                5000,
                0
            )
        )

        return dummyTagihan
    }


}