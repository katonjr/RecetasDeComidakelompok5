package com.example.recetasdecomida.Model.ModelClass

data class IsiResepModel(
    val gambar: String = "",
    val namaMakanan: String = "Soto Ayam",
    val deskripsi: String = "Soto Ayam Enak Nikmat",
    val bahan: List<String> = listOf("1/2 ekor ayam kampung, potong dua","Air","garam","daun jeruk dan salam","1 batang serai"
            ),
    val caramemasak: String = "tips and trick cara memasak."

)
