package com.ketapunk.music.models

import com.ketapunk.innertube.models.YTItem

data class ItemsPage(
    val items: List<YTItem>,
    val continuation: String?,
)
