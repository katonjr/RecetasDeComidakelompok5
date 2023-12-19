package com.example.recetasdecomida

import com.example.recetasdecomida.Model.ModelClass.DataBahanModel
import com.example.recetasdecomida.Model.ModelClass.IsiResepModel
import com.example.recetasdecomida.Model.ModelClass.ResepSimpanModel

val listRekomendasi: List<IsiResepModel> = listOf(
    IsiResepModel("https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2023/07/17043644/Praktis-dan-Simpel-Ini-Resep-Soto-Ayam-Lamongan-yang-Menggugah-Selera-.jpg.webp",
        "Soto Ayam", deskripsi = "Ini Deskripsi Soto Ayam"),
    IsiResepModel("https://cdn.idntimes.com/content-images/community/2022/04/resep-rendang-filosofi-rendang-makna-rendang-arti-rendang-rendang-dari-mana-makanan-indonesia-filosofi-9cde86371d7fc78c91ae80a6ffab250e-e0b9344da253b8e653bd42c7df03d6d9.jpg",
    "Rendang", deskripsi = "Ini Deskripsi Rendang"),
    IsiResepModel("https://upload.wikimedia.org/wikipedia/commons/a/ad/Sate_Ponorogo.jpg",
    "Sate Ayam", deskripsi = "Ini Deskripsi Rendang"),
    IsiResepModel("https://awsimages.detik.net.id/community/media/visual/2022/04/20/resep-gurame-bakar-bumbu-kecap-cabe_43.jpeg?w=1200",
    "Ikan Bakar", deskripsi = "Ini Deskripsi Rendang"),
    IsiResepModel("https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2023/07/25041221/ini-resep-kuah-bakso-sap-yang-mudah-dibuat-di-rumah.jpg",
    "Bakso", deskripsi = "Ini Deskripsi Rendang"),
    IsiResepModel("https://images.tokopedia.net/img/JFrBQq/2022/8/11/6c37004f-bd32-4af6-aec4-576c14d47fad.jpg",
    "Opor Ayam", deskripsi = "Ini Deskripsi Rendang"),
    IsiResepModel("https://cdn-brilio-net.akamaized.net/news/2022/03/09/224600/1686675-resep-sosis-bakar.jpg",
    "Sosis Bakar", deskripsi = "Ini Deskripsi Rendang"),
    IsiResepModel("https://asset-2.tstatic.net/palembang/foto/bank/images/ayam-goreng.jpg",
        "Ayam Goreng", deskripsi = "Ini Deskripsi Rendang"),
)

val listBahan:List<DataBahanModel> = listOf(
    DataBahanModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQTrdJKHoCWUdw2WrA-Rp5EH-B7mguGsmH2kNm-1RCQWCXSiznBsHGzVqYV7aakZf3Tno&usqp=CAU"),
    DataBahanModel("https://www.natural-poultry.com/wp-content/uploads/2021/03/daging-ayam-kampung.jpg",
        listOf("Ayam") ),
    DataBahanModel("https://distan.sukabumikota.go.id/wp-content/uploads/2016/04/Daging-Kambing.jpg",
        listOf("Kambing") ),
    DataBahanModel("https://awsimages.detik.net.id/community/media/visual/2021/09/20/garis-putih-pada-ikan-salmon.jpeg?w=1200",
        listOf("Ikan") ),
    DataBahanModel("https://dinkes.pekalongankota.go.id/upload/halaman/halaman_20190416090614.jpg",
        listOf("Sayur") ),
    DataBahanModel("https://asset-2.tstatic.net/aceh/foto/bank/images/buah-segar.jpg",
        listOf("Buah") ),
    DataBahanModel("https://res.cloudinary.com/dk0z4ums3/image/upload/v1592885787/attached_image/inilah-manfaat-telur-dan-cara-menyimpannya.jpg",
        listOf("Telur") ),
    DataBahanModel("https://yankes.kemkes.go.id/img/bg-img/gambarartikel_1667289642_368318.jpg",
        listOf("Tempe") ),
    DataBahanModel("https://asset-a.grid.id/crop/0x0:0x0/360x240/photo/2022/11/12/tahu-ptihjpg-20221112090641.jpg",
        listOf("Tahu") ),
    DataBahanModel("https://images.genpi.co/resize/1280x860-100/uploads/arsip/normal/2023/08/17/3-bahaya-jika-anak-sering-makan-sosis-jangan-sepe-orng.webp",
        listOf("Sosis") ),
    DataBahanModel("https://static.promediateknologi.id/crop/0x0:0x0/750x500/webp/photo/2022/10/13/1236905540.jpg",
        listOf("Mie") ),
    DataBahanModel("https://asset.kompas.com/crops/RsA6dJ3Ny2qIlcT0TNLrQ_YDiao=/0x0:1000x667/750x500/data/photo/2023/07/06/64a628ed595eb.jpeg",
        listOf("Sambel") ),

)

val listResep: MutableList<ResepSimpanModel> = mutableListOf()

val listResepFilter: MutableList<ResepSimpanModel> = mutableListOf()
