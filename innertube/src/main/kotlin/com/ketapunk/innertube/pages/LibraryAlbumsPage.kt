package com.ketapunk.innertube.pages

import com.ketapunk.innertube.models.Album
import com.ketapunk.innertube.models.AlbumItem
import com.ketapunk.innertube.models.Artist
import com.ketapunk.innertube.models.ArtistItem
import com.ketapunk.innertube.models.MusicResponsiveListItemRenderer
import com.ketapunk.innertube.models.MusicTwoRowItemRenderer
import com.ketapunk.innertube.models.PlaylistItem
import com.ketapunk.innertube.models.SongItem
import com.ketapunk.innertube.models.YTItem
import com.ketapunk.innertube.models.oddElements
import com.ketapunk.innertube.utils.parseTime

data class LibraryAlbumsPage(
    val albums: List<AlbumItem>,
    val continuation: String?,
) {
    companion object {
        fun fromMusicTwoRowItemRenderer(renderer: MusicTwoRowItemRenderer): AlbumItem? {
            return AlbumItem(
                        browseId = renderer.navigationEndpoint.browseEndpoint?.browseId ?: return null,
                        playlistId = renderer.thumbnailOverlay?.musicItemThumbnailOverlayRenderer?.content
                            ?.musicPlayButtonRenderer?.playNavigationEndpoint
                            ?.watchPlaylistEndpoint?.playlistId ?: return null,
                        title = renderer.title.runs?.firstOrNull()?.text ?: return null,
                        artists = null,
                        year = renderer.subtitle?.runs?.lastOrNull()?.text?.toIntOrNull(),
                        thumbnail = renderer.thumbnailRenderer.musicThumbnailRenderer?.getThumbnailUrl() ?: return null,
                        explicit = renderer.subtitleBadges?.find {
                            it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE"
                        } != null
                    )
        }
    }
}
