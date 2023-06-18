package com.example.movieverse.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieverse.R
import com.example.movieverse.MovieActivity
import com.example.movieverse.adapter.MovieAdapter
import com.example.movieverse.adapter.SliderAdapter
import com.example.movieverse.data.MovieData
import com.smarteist.autoimageslider.SliderView

class HomeFragment : Fragment() {

    private lateinit var adapter: MovieAdapter
    private lateinit var movieList: List<MovieData>

    lateinit var imageurl: ArrayList<String>
    lateinit var sliderView: SliderView
    lateinit var sliderAdapter: SliderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = GridLayoutManager(context, 2)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.setHasFixedSize(true)
        adapter = MovieAdapter(requireContext(), movieList) { movie ->
            val intent = Intent(requireContext(), MovieActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, movie)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        sliderView=view.findViewById(R.id.imageSlider)

        imageurl= ArrayList()
        imageurl.add("android.resource://" + requireContext().packageName + "/" + R.drawable.slider1)
        imageurl.add("android.resource://" + requireContext().packageName + "/" + R.drawable.slider2)
        imageurl.add("android.resource://" + requireContext().packageName + "/" + R.drawable.slider3)
        imageurl.add("android.resource://" + requireContext().packageName + "/" + R.drawable.slider4)

        sliderAdapter = SliderAdapter(imageurl)
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.scrollTimeInSec= 3
        sliderView.isAutoCycle= true
        sliderView.startAutoCycle()
    }

    private fun dataInitialize() {

        movieList = listOf<MovieData>(
            MovieData(
                R.drawable.movie1,
                moviename = "Ant-Man and The Wasp: Quantumania",
                moviedate = "15 Februari 2023",
                movieauthor = "Peyton Reed",
                moviegenre = "Action, Adventure, Comedy",
                movierate = "Rating: (6,1)",
                movieratingbar = 3.0,
                moviedesc = "Film Ant-Man serial ketiga ini, bercerita tentang keluarga Superhero Ant-Man, Scott Lang dan Hope Van Dyne. Awalnya kehidupan keluarga berlangsung cukup bahagia. Bersama dengan orang tua mereka, Janet Van Dyne dan Hank Pym, serta anak gadis cantiknya Cassie Lang banyak menghabiskan waktu bersama.\n" +
                        "\nCassie juga semakin menunjukkan ketertarikan dan bakatnya di bidang Sains dan Teknologi. Mengikuti jejak ayahnya, khususnya hal-hal yang berkaitan dengan dunia Quantum (Quantum Realm). Namun suatu waktu, ketika semuanya sedang berdiskusi di ruangan khusus mereka, Cassie menunjukkan hasil karya terbarunya. Sebuah alat yang dianggapnya solusi untuk membantu banyak orang sebagai superhero.\n" +
                        "\nSang Nenek, Janet Van Dyne sempat melarang untuk menggunakan alat tersebut. Dirinya pun meminta Cassie untuk mematikan alat tersebut. Namun, hal tersebut sudah terlambat. Secara tiba-tiba mereka semua tersedot ke dalam alat tersebut dan akhirnya masuk ke dalam dunia Quantum.\n" +
                        "\nDi sana mereka bertemu dengan berbagai makhluk aneh dan dunia semesta yang betul-betul berbeda. Mereka pun memulai petualangan yang melampaui batas. Di dalam dunia Quantum ini juga, mereka juga bertemu dengan musuh baru, Kang The Conqueror. Yang dalam hal ini Kang begitu berambisi untuk menguasai dunia Multiverse."
            ),
            MovieData(
                R.drawable.movie2,
                moviename = "Shazam! Fury of the Gods",
                moviedate = "15 Maret 2023",
                movieauthor = "David F. Sandberg",
                moviegenre = "Action, Adventure, Comedy",
                movierate = "Rating: (6,0)",
                movieratingbar = 3.0,
                moviedesc = "Film Shazam Fury of The Gods masih melanjutkan kisah Billy Batson dengan alter-ego superhero. Bersama lima saudaranya, Billy Batson memanfaatkan kekuatannya dari seorang penyihir misterius untuk membantu masyarakat dalam menumpas kasus kejahatan.\n" +
                        "\nNamun aksi Billy Batson dan lima saudaranya malah dianggap sebagai pengganggu, bahkan berjuluk Pecundang Philadelphia. Di usia 18 tahun, Billy Batson serta Mary mencemaskan uang sumbangan dari pemerintah yang akan segera dihentikan. Sedangkan Freddy bertemu gadis bernama Anne yang memikat hatinya.\n" +
                        "\nSementara itu, Hespera dan Kalypso yang merupakan putri-putri Dewa Atlas menemukan tongkat magis yang sempat dipatahkan Billy Batson sebelumnya. Hespera dan Kalypso lantas berniat balas dendam dengan kekuatan yang diperolehnya dari tongkat itu."
            ),
            MovieData(
                R.drawable.movie3,
                moviename = "John Wick: Chapter 4",
                moviedate = "21 Maret 2023",
                movieauthor = "Chad Stahelski",
                moviegenre = "Action, Crime, Thriller",
                movierate = "Rating: (7,9)",
                movieratingbar = 4.0,
                moviedesc = "Dikisahkan John Wick (Keanu Reeves) yang sedang berupaya untuk menemukan cara untuk mengalahkan The High Table yaitu organisasi kejahatan yang mematikan. Organisasi ini dikenal sebagai penguasa kejahatan paling kuat di dunia bawah tanah.\n" +
                        "\nThe High Table memiliki 12 anggota dari organisasi kejahatan berbagai negara, seperti dari Yakuza, Mafia Rusia, Italia yang berisi mantan-mantan pembunuh bayaran dan mantan penjahat kelas kakap.\n" +
                        "\nTidak tinggal diam, The High Table juga melakukan sayembara siapapun yang dapat membunuh John Wick akan diberikan hadiah jutaan dollar Amerika Serikat. John dengan ambisinya akhirnya memilih jalan keluar dengan manantang pemimpin The High Table, Marquis de Gramont (Bill Skarsgard) untung bertarung.\n" +
                        "\nJika John Wick menang dalam pertarungan ini, High Table akan menepati janjinya yaitu tidak menjadikan lagi John sebagai target operasi mereka. Sementara John Wick hanya menginginkan dikenang sebagai suami yang baik karena selama ini ia hidup sebatang kara setelah ditinggal istrinya bertahun-tahun."
            ),
            MovieData(
                R.drawable.movie4,
                moviename = "Dungeons & Dragons: Honor Among Thieves",
                moviedate = "29 Maret 2023",
                movieauthor = "John Francis Daley, Jonathan Goldstein",
                moviegenre = "Adventure, Fantasy",
                movierate = "Rating: (7,3)",
                movieratingbar = 3.5,
                moviedesc = "Film ini menceritakan seorang anggota Harpers, yaitu Edgin Darvis. Harpers sendiri merupakan organisasi yang berperan dalam melestarikan peradaban. Namun, Edgin memutuskan mengundurkan diri setelah istrinya dibunuh oleh Red Wizard, musuh yang dia lawan saat menjalankan misi.\n" +
                        "\nSetelah tragedi itu, Edgin bergabung dengan kelompok pencuri. Misi mereka adalah mengambil sebuah relik berharga yang dikatakan mampu membangkitkan istri Edgin. Akan tetapi, petualangan mereka akan penuh dengan rintangan."
            ),
            MovieData(
                R.drawable.movie5,
                moviename = "Super Mario Bros: The Movie",
                moviedate = "05 April 2023",
                movieauthor = "Aaron Horvath, Michael Jelenic",
                moviegenre = "Adventure, Animation, Comedy",
                movierate = "Rating: (7,2)",
                movieratingbar = 3.5,
                moviedesc = "Diangkat dari game populer, The Super Mario Bros Movie berkisah tentang tukang ledeng asal Brooklyn, AS, bernama Mario. Ia bekerja sebagai tukang saluran air bawah tanah bersama saudaranya yang bernama Luigi.\n" +
                        "\nSuatu ketika, Mario dan Luigi terjebak dalam pipa misterius yang membawa mereka masuk dalam dunia penuh keajaiban. Namun di tengah perjalanan, Mario kehilangan Luigi.\n" +
                        "\nDi tengah perjalanan mencari Luigi, Mario bertemu Toad dari Kerajaan Jamur. Toad rupanya bersedia membantu Mario mencari Luigi. Selain Toad, Mario juga dibantu Princess Peach dari Kerajaan Jamur. Mario dibekali kekuatan untuk menghadapi musuh."
            ),
            MovieData(
                R.drawable.movie6,
                moviename = "Guardians of the Galaxy Vol. 3",
                moviedate = "03 Mei 2023",
                movieauthor = "James Gunn",
                moviegenre = "Action, Adventure, Comedy",
                movierate = "Rating: (8,2)",
                movieratingbar = 4.0,
                moviedesc = "Di petualangan kali ini, Knowhere diserang oleh makhluk yang memiliki kekuatan hebat bernama Adam Warlock. Adam Warlock memiliki misi untuk menculik Rocket.\n" +
                        "\nAdam yang sangat kuat ternyata menyerang para Guardians dengan sangat dahsyat, yang mengakibatkan Rocket terluka parah. Peter Quill pun harus membawa timnya dalam misi berbahaya untuk menyelamatkan hidup Rocket"
            ),
            MovieData(
                R.drawable.movie7,
                moviename = "Evil Dead Rise",
                moviedate = "05 Mei 2023",
                movieauthor = "Lee Cronin",
                moviegenre = "Fantasy, Horror",
                movierate = "Rating: (6,7)",
                movieratingbar = 3.5,
                moviedesc = "Evil Dead Rise menceritakan tentang penemuan Necronomicon atau \"kitab orang mati\" yang melepaskan roh jahat ke dunia. Beth (Lily Sullivan) mengunjungi kakak perempuannya, Ellie (Alyssa Sutherland) yang berada di Los Angeles.\n" +
                        "\nEllie membesarkan ketiga anaknya sendirian dan hidup di sebuah apartemen. Suatu hari, Danny (Morgan Davies), salah satu anak laki-laki dari Ellie menemukan kitab orang mati yang membuat sang ibu dirasuki oleh roh jahat.\n" +
                        "\nKitab tersebut memanggil iblis bernama Deadites. Ellie yang tidak sengaja bertemu perkumpulan para suster aneh dalam gedung, membuat dia mendapat ancaman dari iblis. Selain diancam, iblis juga mengambil tubuh Ellie.\n" +
                        "\nTernyata keberadaan kitab tersebut membawa malapetaka bagi semuanya. Iblis dari kitab tersebut merasuki tubuh manusia dan mengancam orang-orang terdekatnya. Beth dan anak-anak Ellie harus bertahan hidup dari Ellie yang melakukan berbagai teror mengancam nyawa setelah kerasukan iblis."
            ),
            MovieData(
                R.drawable.movie8,
                moviename = "Fast X",
                moviedate = "17 Mei 2023",
                movieauthor = "Louis Leterrier",
                moviegenre = "Action, Adventure, Crime",
                movierate = "Rating: (6,0)",
                movieratingbar = 3.0,
                moviedesc = "Film ini menceritakan bahaya baru yang kini mengancam Dom beserta keluarganya. Musuh kali ini menjadi buntut dari kekalahan Hernan Reyes, seorang gembong narkoba yang berhasil ditaklukkan Dom dan kelompoknya pada seri kelima yang berjudul Fast Five (2011).\n" +
                        "\nKematian sang bandar narkoba melahirkan dendam dari anak Hernan, yaitu Dante Reyes. Sejak menyaksikan sendiri kematian Hernan, Dante mulai menyusun rencana balas dendam dan mengumpulkan bawahan-bawahan terkuat dari seluruh penjuru dunia.\n"
            ),
            MovieData(
                R.drawable.movie9,
                moviename = "The Little Mermaid",
                moviedate = "24 Mei 2023",
                movieauthor = "Rob Marshall",
                moviegenre = "Adventure, Family, Fantasy",
                movierate = "Rating: (7,2)",
                movieratingbar = 3.5,
                moviedesc = "The Little Mermaid mengisahkan tentang Ariel, putei duyung yang merupakan anak bungsu dari Raja Triton, penguasa kerajaan bawah laut Atlantica. Ariel yang terpesona oleh dunia manusia akhirnya jatuh cinta dengan pangeran Eric.\n" +
                        "\nAwal pertemuan keduanya adalah saat Ariel menyelamatkan Eric saat kapalnya karam. Ariel yang jatuh cinta pun memutuskan untuk menemui sang pria idaman di dunia atas air. Perjalanan pencarian Eric pun membawa Ariel pada konflik dengan sang ayah yang dibawah cengkraman penyihir laut bernama moleh."
            ),
            MovieData(
                R.drawable.movie10,
                moviename = "Spider-Man: Across the Spider-Verse",
                moviedate = "31 Mei 2023",
                movieauthor = "Joaquim Dos Santos, Kemp Powers, Justin K. Thompson",
                moviegenre = "Action, Adventure, Animation",
                movierate = "Rating: (9,0)",
                movieratingbar = 4.5,
                moviedesc = "Berlatar lebih dari satu tahun setelah Spider-Man: Into the Spider-Verse, Spider-Man: Across the Spider-Verse menceritakan petualangan Miles Morales dan sang kekasih, Gwen Stacy dalam upaya menyelesaikan misi penyelamatan universe.\n" +
                        "\nSelama melintasi multiverse, keduanya bertemu dengan Spider-Man dari semesta lain yang dipimpin oleh Miguel O'Hara. Miles dan sekelompok Spider-Man tersebut terlibat selisih paham terkait masing-masing cara yang mereka ambil dalam menghadapi sebuah ancaman. Perlahan, Miles mulai belajar memahami makna menjadi seorang pahlawan.\n"
            ),
            MovieData(
                R.drawable.movie11,
                moviename = "Transformers: Rise of the Beasts",
                moviedate = "7 Juni 2023",
                movieauthor = "Steven Caple Jr.",
                moviegenre = "Action, Adventure, Sci-Fi",
                movierate = "Rating: (6,6)",
                movieratingbar = 3.5,
                moviedesc = "Transformers Rise of the Beasts mengambil latar waktu tahun 1990-an. Berkisah tentang seorang laki-laki bernama Noah Diaz (Anthony Ramos) dan Elena (Dominique Fishback), seorang peneliti artefak. Keduanya memiliki bakat yang mumpuni di bidang mereka.\n" +
                        "\nSuatu hari, Noah dan Elena memulai petualangan dengan menjelajahi dunia bersama Autobots dan Transformers. Namun, perjalanan mereka rupanya tidak sesuai ekspektasi dan tidak semudah yang mereka bayangkan. Mau tidak mau, mereka pun harus masuk ke dalam konflik berbahaya.\n" +
                        "\nNoah dan Elena diharuskan membantu Optimus Prime dan Autobots untuk menyelamatkan Bumi dari ancaman besar. Di situasi itu, Optimus Prime bertemu dengan Optimus Primal di hutan belantara. Dalam pertemuan tersebut, Optimus Primal mengingatkan Optimus Prime bahwa akan ada makhluk besar datang untuk menghancurkan Bumi dan isinya. Lantas, keduanya pun berusaha bersama-sama untuk melawan makhluk tersebut."
            ),
            MovieData(
                R.drawable.movie12,
                moviename = "The Flash",
                moviedate = "14 Juni 2023",
                movieauthor = "Andres Muschietti",
                moviegenre = "Action, Adventure, Fantasy",
                movierate = "Rating: (9,0)",
                movieratingbar = 4.5,
                moviedesc = "The Flash berkisah tentang pahlawan super bernama Barry Allen yang dikenal dengan The Flash. Sebagai salah satu pahlawan super, kekuatan utama The Flash adalah kemampuannya memiliki kecepatan super secepat kilat. Barry Allen memanfaatkan kekuatan yang ia miliki untuk kembali ke masa lalu.\n" +
                        "\nTujuan perjalanan ke masa lalu yang ditempuh Barry Allen adalah untuk mencegah kematian ibu. Perjalanan menembus ruang dan waktu memiliki resiko besar dan Barry Allen pun sudah diperingati oleh Batman, tapi keputusan Barry Allen sudah bulat. Dalam perjalanannya The Flash menabrak garis waktu lain dan membawanya ke zaman di mana Jenderal Zod berkuasa.\n" +
                        "\nPada zaman itu The Flash bertemu dengan dirinya dan kedua orang tuanya semasa muda. Ia pun menyadari jika semesta lain itu tidak lagi aman selama Jenderal Zod hidup. The Flash yang tahu jika Jenderal Zod ingin melakukan pemusnahan tak punya pilihan lain selain tetap di zaman itu untuk melawan Zod. Untuk mengalahkan Jenderal Zod, The Flash meminta bantuan dari pahlawan super lain seperti Batman dan Supergirl. Hanya ada satu pilihan yaitu kemenangan yang harus diraih The Flash dan para superhero lain."
            )
        )
    }
}