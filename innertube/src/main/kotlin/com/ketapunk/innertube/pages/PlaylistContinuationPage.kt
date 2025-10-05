package com.ketapunk.innertube.pages

import com.ketapunk.innertube.models.SongItem

data class PlaylistContinuationPage(
    val songs: List<SongItem>,
    val continuation: String?,
)
