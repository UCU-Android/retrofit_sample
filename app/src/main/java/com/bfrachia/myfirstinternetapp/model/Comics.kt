package com.bfrachia.myfirstinternetapp.model

data class Comics(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)