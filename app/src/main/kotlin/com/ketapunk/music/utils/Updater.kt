package com.ketapunk.music.utils

import com.ketapunk.music.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import org.json.JSONObject

object Updater {
    private val client = HttpClient()
    var lastCheckTime = -1L
        private set

    suspend fun getLatestVersionName(): Result<String> =
        runCatching {
            val response =
                client.get("https://api.github.com/repos/mostafaalagamy/KetaPunk/releases/latest")
                    .bodyAsText()
            val json = JSONObject(response)
            val versionName = json.getString("name")
            lastCheckTime = System.currentTimeMillis()
            versionName
        }

    fun getLatestDownloadUrl(): String {
        val baseUrl = "https://github.com/mostafaalagamy/KetaPunk/releases/latest/download/"
        val architecture = BuildConfig.ARCHITECTURE
        return if (architecture == "universal") {
            baseUrl + "KetaPunk.apk"
        } else {
            baseUrl + "app-${architecture}-release.apk"
        }
    }
}
