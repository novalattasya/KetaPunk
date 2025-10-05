package com.ketapunk.music.models

import com.ketapunk.innertube.models.YTItem
import com.ketapunk.music.db.entities.LocalItem

data class SimilarRecommendation(
    val title: LocalItem,
    val items: List<YTItem>,
)
