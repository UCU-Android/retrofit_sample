package com.bfrachia.myfirstinternetapp.data.api.model

data class Stories(
    val available: String,
    val collectionURI: String,
    val items: List<StoryItem>,
    val returned: String
)