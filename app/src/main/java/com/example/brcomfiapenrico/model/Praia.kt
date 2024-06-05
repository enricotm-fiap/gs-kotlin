package com.example.brcomfiapenrico.model

data class Praia (
    val nome: String,
    val cidade: String,
    val estado: String,
    val onRemove: (Praia) -> Unit
    )