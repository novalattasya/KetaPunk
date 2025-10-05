package com.ketapunk.innertube.models.body

import com.ketapunk.innertube.models.Context
import com.ketapunk.innertube.models.Continuation
import kotlinx.serialization.Serializable

@Serializable
data class BrowseBody(
    val context: Context,
    val browseId: String?,
    val params: String?,
    val continuation: String?
)
