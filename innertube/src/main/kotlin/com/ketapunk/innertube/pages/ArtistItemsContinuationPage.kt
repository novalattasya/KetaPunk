package com.ketapunk.innertube.pages

import com.ketapunk.innertube.models.YTItem

data class ArtistItemsContinuationPage(
    val items: List<YTItem>,
    val continuation: String?,
)
