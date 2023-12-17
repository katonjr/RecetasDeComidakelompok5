package com.example.recetasdecomida

data class isiresep(val namaMakanan: String = "Soto Ayam",
    val deskripsi: String = "Soto Ayam Enak Nikmat",
    val bahan: List<String> = listOf("1/2 ekor ayam kampung, potong dua","Air","garam","daun jeruk dan salam","1 batang serai"
            ),
    val caramemasak: String = "-Didihkan air, rebus ayam dengan api kecil hingga daging ayam hampir lunak.\n" +
            "-Tumis bumbu halus bersama daun jeruk, daun salam, serai dan aduk hingga matang dan harum. Angkat.\n" +
            "-Masukkan ke dalam rebusan ayam.\n" +
            "-Rebus dengan api kecil hingga daging ayam lunak.\n" +
            "-Angkat ayam, tiriskan hingga agak kering.\n" +
            "-Goreng ayam sebentar hingga bagian luarnya kering. Tiriskan.\n" +
            "-Suwir daging ayam kasar-kasar.\n" +
            "-Susun ayam, suun, tauge dalam mangkuk saji.\n" +
            "-Tuangi kaldu panas.\n" +
            "-Sajikan dengan daun bawang, bawang goreng, sambal rawit dan jeruk nipis."

)
