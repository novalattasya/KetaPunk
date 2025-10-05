package com.ketapunk.innertube.pages

import com.ketapunk.innertube.models.YTItem

data class LibraryContinuationPage(
    val items: List<YTItem>,
    val continuation: String?,
)
