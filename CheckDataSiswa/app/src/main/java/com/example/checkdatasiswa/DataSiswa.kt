package com.example.checkdatasiswa

class DataSiswa (){

    var indexName : Int? = null
    companion object {
        var nameSiswa : String?  = null
        var tostvalue: String? = null
        var sourceImage : Int? = null
        var nisn_nisSiswa : String? = null
    }


    fun setName(value : String)
    {
        nameSiswa = value
    }

    fun checkName()
    {
        val collectionNamaSiswa = listOf<String>(
            "Adinda Putri Ramadhani",
            "Adryan Maulana",
            "Anggita Meidani",
            "Arridha",
            "Ayub Azani",
            "Dinda Fitriani",
            "Gina Putri Nanyanti",
            "Hafizh Maulana",
            "Iqlima Maizati",
            "Khayrur Rasyiddin",
            "Lulu Kania",
            "M. Ilham Arrazaq",
            "M. Ilham Tri Arfan",
            "M. Razan Putra Akbar",
            "M. Yusuf",
            "Muammar Krisna",
            "Muhammad Qafrawi",
            "Muhammad Yasir",
            "Qhana Al Khatab",
            "Razatanlie Kamal",
            "Reva Sepira",
            "Satria Akbar Rizki",
            "Yussyfa Arum",
            "Zahara Adelia",
            "Zurianda Wulandari",
            "Muhammad Ammar Wali Ys"
        )

        for (x in collectionNamaSiswa)
        {
            if (x.equals(nameSiswa, ignoreCase = true))
            {
                tostvalue = x
                indexName = collectionNamaSiswa.indexOf(x)
                break
            }
            else if (x.equals(nameSiswa) == false)
            {
                tostvalue = "Data tidak ditemukan"
            }
        }
    }

    fun dataDetailSiswa()
    {
        val dataGambar = listOf<Int>(
            R.drawable.adinda_putri_ramadhani,
            R.drawable.adryan_maulana,
            R.drawable.anggita_meidani,
            R.drawable.aridha,
            R.drawable.ayub_azani,
            R.drawable.dinda_fitriani,
            R.drawable.gina_putri_nanyanti,
            R.drawable.hafizh_maulana,
            R.drawable.iqlima_maizati,
            R.drawable.khairur_rasyidin,
            R.drawable.lulu_kania,
            R.drawable.m_ilham_arrazaq,
            R.drawable.m_ilham_tri_arfan,
            R.drawable.m_razan_putra_akbar,
            R.drawable.m_yusuf,
            R.drawable.muammar_krisna,
            R.drawable.muhammad_qafrawi,
            R.drawable.muhammad_yasir,
            R.drawable.qhana_al_khatab,
            R.drawable.razatanlie_kamal,
            R.drawable.reva_sepira,
            R.drawable.satria_akbar_rizki,
            R.drawable.yussyfa_arum,
            R.drawable.zahara_adelia,
            R.drawable.zurianda_wulandari,
            R.drawable.muhammad_ammar_wali
        )

        val dataNISN_NIS = mapOf<Int,String>(
            0 to "0046836944 / 8805",
            1 to "0051540115 / 8806",
            2 to "0054621396 / 8807",
            3 to "0054356489 / 8808",
            4 to "0053013634 / 8809",
            5 to "0059050642 / 8811",
            6 to "005945988 / 8814",
            7 to "3053435602 / 8815",
            8 to "0051681486 / 8816",
            9 to "0051084441 / 8817",
            10 to "0057895512 / 8818",
            11 to "0059340144 / 8819",
            12 to "3056979052 / 8820",
            13 to "0053511848 / 8821",
            14 to "0053916416 / 8822",
            15 to "0045773791 / 8823",
            16 to "0051725493 / 8824",
            17 to "3050811169 / 8825",
            18 to "0059245801 / 8828",
            19 to "0055808700 / 8829",
            20 to "0059358642 / 8830",
            21 to "0046631581 / 8831",
            22 to "0055930020 / 8833",
            23 to "3063859652 / 8834",
            24 to "0065038267 / 8835",
            25 to "0046376726 / 9726"
        )

        for (x in dataGambar.indices )
        {
            if (x.equals(indexName))
            {
                sourceImage = dataGambar.get(x)
            }
        }

        for (x in dataNISN_NIS.keys)
        {
            if (x.equals(indexName))
            {
                nisn_nisSiswa = dataNISN_NIS.getValue(x)
            }
        }

    }
}
