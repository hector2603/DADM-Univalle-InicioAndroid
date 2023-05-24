package com.hector.ocampo.mylist.model.api


data class MovieDataResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)

