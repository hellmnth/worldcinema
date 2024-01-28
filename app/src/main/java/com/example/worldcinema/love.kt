package com.example.worldcinema

data class love(val imageId:Int, val title:String)
class PosterList{val list = arrayListOf(love(R.drawable.f1, "Уэнсдей"),
    love(R.drawable.f3, "Рик и Морти"),
    love(R.drawable.f33, "Аватар"))}
