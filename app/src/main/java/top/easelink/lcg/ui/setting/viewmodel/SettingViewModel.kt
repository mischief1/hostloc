package top.easelink.lcg.ui.setting.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import top.easelink.lcg.config.AppConfig
import top.easelink.lcg.event.*
import java.util.*

class SettingViewModel : ViewModel() {
    val autoCheckUpdateEnable = MutableLiveData<Boolean>()
    val syncFavoriteEnable = MutableLiveData<Boolean>()
    val searchEngineSelected = MutableLiveData<Int>()
    val openSearchResultInWebView = MutableLiveData<Boolean>()
    val openArticleInWebView = MutableLiveData<Boolean>()
    val handlePreTagInArticle = MutableLiveData<Boolean>()
    val showRecommendFlag = MutableLiveData<Boolean>()

    fun init() {
        with(AppConfig) {
            autoCheckUpdateEnable.value = autoCheckUpdate
            syncFavoriteEnable.value = syncFavorites
            searchEngineSelected.value = defaultSearchEngine
            openSearchResultInWebView.value = searchResultShowInWebView
            openArticleInWebView.value = articleShowInWebView
            showRecommendFlag.value = articleShowRecommendFlag
            handlePreTagInArticle.value = articleHandlePreTag
        }
    }

    fun setSyncFavorite(enable: Boolean) {
        AppConfig.syncFavorites = enable
        sendKVEvent(EVENT_SYNC_FAVORITE, Properties().apply {
            setProperty(
                PROP_IS_SYNC_FAVORITE_ENABLE,
                enable.toString()
            )
        })
    }

}