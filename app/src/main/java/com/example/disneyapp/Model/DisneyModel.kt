package com.example.disneyapp.Model

data class DisneyModel(
    val count: Int?,
    val data: List<DisneyData?>?,
    val nextPage: String?,
    val totalPages: Int?
)