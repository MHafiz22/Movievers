package com.example.uts.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts.UpcomingActivity
import com.example.uts.adapter.UpcomingAdapter
import com.example.uts.data.UpcomingData
import com.example.uts.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UpcomingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpcomingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: UpcomingAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var upcomingList: List<UpcomingData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming, container, false)
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment UpcomingFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            UpcomingFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv)
        recyclerView.setHasFixedSize(true)
        adapter = UpcomingAdapter(requireContext(), upcomingList) { upcoming ->
            val intent = Intent(requireContext(), UpcomingActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, upcoming)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }

    private fun dataInitialize() {

        upcomingList = listOf<UpcomingData>(
            UpcomingData(
                R.drawable.upcoming1,
                upcomingname = "Insidious: The Red Door",
                upcomingdate = "07 Juli 2023",
                upcomingauthor = "Patrick Wilson",
                upcominggenre = "Drama, Horror, Thriller",
                upcomingdesc = "Masih berpusat pada keluarga Lambert, Insidious: The Red Door bercerita tentang kehidupan keluarga tersebut 10 tahun setelah insiden misterius di film sebelumnya. Film pun dimulai dengan kisah Dalton Lambert yang berhasil menjadi mahasiswa baru di kampus impiannya, Ivy-League University.\n" +
                        "\nJosh Lambert dan Renai Lambert pun mengantar anak laki-laki mereka, Dalton berkuliah ke wilayah timur. Sayangnya, impian Dalton seketika jadi mimpi buruk lantaran teror arwah yang dulu mengganggunya kembali datang.\n" +
                        "\nMereka pun terpaksa harus memasuki The Red Door yang merupakan gerbang penghubung dunia manusia dan dunia arwah."
            ),
            UpcomingData(
                R.drawable.upcoming2,
                upcomingname = "Mission: Impossible - Dead Reckoning Part One",
                upcomingdate = "14 Juli 2023",
                upcomingauthor = "Christopher McQuarrie",
                upcominggenre = "Action, Adventure, Thriller",
                upcomingdesc = "Plot cerita dari film terbaru Mission: Impossible ini masih berpusat pada Ethan Hunt, seorang agen rahasia sekaligus pemimpin tim operasi mata-mata bernama IMF (Impossible Mission Force).\n" +
                        "\nEthan Hunt dan timnya memulai misi berbahaya untuk melacak senjata menakutkan yang mengancam umat manusia. Tugas mereka adalah mencegah sejata tersebut jatuh ke tangan yang salah.\n" +
                        "\nEthan Hunt menjalankan misi dengan nasib dunia yang dipertaruhkan. Ditambah lagi, Ethan harus berhadapan dengan musuh misterius dan kuat bernama Gabriel. Sementara kekuatan gelap dari masa lalunya mendekat, Ethan meyakini bahwa tidak ada yang lebih penting dari misinya, bahkan jika dibandingkan dengan nyawa orang-orang yang paling dia sayangi."
            ),
            UpcomingData(
                R.drawable.upcoming3,
                upcomingname = "Oppenheimer",
                upcomingdate = "21 Juli 2023",
                upcomingauthor = "Christopher Nolan",
                upcominggenre = "Biography, Drama, History",
                upcomingdesc = "Film ini adalah film biografi yang menceritakan kehidupan J. Robert Oppenheimer yang merupakan ilmuwan ternama yang memimpin The Manhattan Project. Tim ini adalah kelompok ilmuwan pengembang bom atom untuk Amerika Serikat pada Perang Dunia II. Oppenheimer menjabat Ketua Komisi Energi Atom Amerika Serikat yang bertugas untuk memperlambat perkembangan senjata nuklir dengan Uni Soviet.\n" +
                        "\nOppenheimer dicap komunis pada tahun 1954 karena ia berafiliasi dengan banyak kelompok. Ia akhirnya dibebaskan dari layanan pemerintah federal dan kembali berkontribusi dalam bidang sains sebagai guru dan fisikawan teoretis yang penuh inovasi. Kontribusinya dalam bidang fisika cukup besar, terbukti dari tiga nominasi Hadiah Nobel antara tahun 1946 hingga 1967. Sayangnya, hingga kematiannya pada 1967, tak satupun Nobel berhasil Oppenheimer dapatkan.\n" +
                        "\nOppenheimer adalah tokoh kunci dalam penciptaan bom atom yang telah merubah dunia. Namun, pada akhirnya ia menjadi ragu dan bimbang pada senjata yang diciptakannya. Ia sampai meminta kontrol internasional atas senjata nuklir tersebut dan menentang dengan tegas pembuatan senjata yang lebih berbahaya, yaitu bom hidrogen."
            ),
            UpcomingData(
                R.drawable.upcoming4,
                upcomingname = "Suzzanna: Malam Jumat Kliwon",
                upcomingdate = "03 Agustus 2023",
                upcomingauthor = "Guntur Soeharjanto",
                upcominggenre = "Drama, Fantasy, Horror",
                upcomingdesc = "Kisah ini bermula saat Ayu yang sedang mengalami kegagalan dalam menulis novel barunya, lalu memutuskan untuk pergi ke sebuah rumah kosong di tengah hutan demi mencari inspirasi. Namun, di sana ia dan Anton malah mengalami kejadian-kejadian yang menyeramkan. Mereka merasakan adanya kehadiran sosok yang mengerikan dan mengintai mereka.\n" +
                        "\nAyu kemudian menemukan sebuah buku harian tua milik Suzzanna yang isinya sangat mengerikan. Dalam buku itu, Ayu menemukan cerita tentang Suzzanna yang meninggal pada malam Jumat Kliwon dan menjadi sundel bolong. Setelah membaca buku harian itu, Ayu mulai dihantui oleh sosok mengerikan itu."
            ),
            UpcomingData(
                R.drawable.upcoming5,
                upcomingname = "Meg 2: The Trench",
                upcomingdate = "04 Agustus 2023",
                upcomingauthor = "Ben Wheatley",
                upcominggenre = "Action, Adventure, Sci-Fi, Thriller",
                upcomingdesc = "Meg 2: The Trench akan kembali menceritakan kisah pertarungan antara manusia dengan hiu purba megalodon. Hewan purba itu telah hidup sejak 65 juta tahun yang lalu dan telah menguasai dunia, bahkan mampu mengalahkan dinosaurus.\n" +
                        "\nSementara itu, diperlihatkan juga sebuah pulau terpencil yang tidak pernah didatangi manusia. Pulau itu pun nampak menyimpan banyak rahasia dan hewan-hewan purba yang tidak diketahui orang.\n" +
                        "\nDalam seri keduanya ini, Jonas Taylor (Jason Statham) dan para peneliti lainnya akan kembali menyelami Palung Mariana. Diketahui bahwa hiu megalodon yang berjumlah lebih dari dua itu telah lepas dan berenang dalam Palung Mariana. Tidak hanya hiu megalodon yang ganas, Jonas dan para peneliti lainnya pun akan menghadapi ancaman dari berbagai makhluk purba bawah air lainnya."
            ),
            UpcomingData(
                R.drawable.upcoming6,
                upcomingname = "Gran Turismo",
                upcomingdate = "11 Agustus 2023",
                upcomingauthor = "Neil Blomkamp",
                upcominggenre = "Action, Adventure, Drama",
                upcomingdesc = "Jann Mardenborough adalah remaja yang terampil dalam memainkan Gran Turismo. Jann memiliki cita-cita untuk menjadi seorang pembalap mobil sungguhan. Berkat kemampuannya dalam bermain game tersebut, Jann berhasil memenangkan serangkaian kompetisi video game dari Nissan.\n" +
                        "\nKemenangan Jann membawanya mewujudkan cita-cita yang sangat ia dambakan. Dari keterampilannya bermain game, kini Jann berjuang menjadi seorang pembalap mobil profesional."
            ),
            UpcomingData(
                R.drawable.upcoming7,
                upcomingname = "Blue Beetle",
                upcomingdate = "18 Agustus 2023",
                upcomingauthor = "Angel Manuel Soto",
                upcominggenre = "Action, Adventure, Sci-Fi",
                upcomingdesc = "Film Blue Beetle akan memperlihatkan kehidupan Jaime Reyes yang memperoleh kekuatan super dari kumbang alien. Berwarna biru dan memancarkan sinar, kumbang alien tersebut bernama Blue Beetle.\n" +
                        "\nJaime Reyes mulai menyadari apabila dirinya berubah menjadi Blue Beetle ketika terbangun dari mimpi aneh. Peninggalan kuno bioteknologi bernama Scarab itu perlahan menyatu dengan tulang belakang Jaime Reyes.\n" +
                        "\nSuperhero Blue Beetle bertugas melindungi manusia dari kepunahan makhluk hidup sehingga menindak seluruh kejahatan di muka bumi. Pada baju besi Blue Beetle, terdapat meriam dan sinar laser tembak sebagai senjata melindungi diri. Sebagai superhero, Blue Beetle juga bisa memulihkan diri dengan cepat. Hal yang menarik, Blue Beetle menampilkan sisi antagonis dalam trailernya yang baru dirilis." ),
            UpcomingData(
                R.drawable.upcoming8,
                upcomingname = "The Equalizer 3",
                upcomingdate = "01 September 2023",
                upcomingauthor = "Antoine Fuqua",
                upcominggenre = "Action, Crime, Thriller ",
                upcomingdesc = "Robert McCall (Denzel Washington) merasa terpanggil untuk memberikan keadilan bagi orang-orang yang tertindas. Karena, sebagai seorang pria dengan latar belakang gelap yang telah melihat dan melakukan hal-hal mengerikan di masa lalunya, Ia menemukan kedamaian aneh dalam memperjuangkan keadilan.\n" +
                        "\nDalam perjalanan hidupnya di Italia Selatan, Robert menemukan bahwa teman-temannya menjadi korban pengaruh jahat mafia setempat. Ketika kejadian berubah mematikan, Robert mengetahui apa yang harus ia lakukan, yaitu menjadi pelindung bagi teman-temannya dengan melawan mafia.\n" +
                        "\nDalam upaya untuk melindungi mereka yang dicintainya, Robert kembali mengenakan identitasnya sebagai The Equalizer. Sebagai seorang pahlawan yang tak kenal takut dan memiliki kemampuan luar biasa dalam pertempuran."
            )
        )
    }
}