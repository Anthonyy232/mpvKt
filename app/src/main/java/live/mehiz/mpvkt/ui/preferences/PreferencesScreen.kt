package live.mehiz.mpvkt.ui.preferences

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Audiotrack
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Memory
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material.icons.outlined.Subtitles
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import live.mehiz.mpvkt.R
import live.mehiz.mpvkt.presentation.Screen
import me.zhanghai.compose.preference.ProvidePreferenceLocals
import me.zhanghai.compose.preference.preference

object PreferencesScreen : Screen() {
  @OptIn(ExperimentalMaterial3Api::class)
  @Composable
  override fun Content() {
    val navigator = LocalNavigator.currentOrThrow
    Scaffold(
      topBar = {
        TopAppBar(
          title = { Text(text = stringResource(R.string.pref_preferences)) },
          navigationIcon = {
            IconButton(onClick = { navigator.pop() }) {
              Icon(Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = null)
            }
          },
        )
      },
    ) { padding ->
      ProvidePreferenceLocals {
        LazyColumn(
          modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        ) {
          preference(
            key = "appearance",
            title = { Text(text = stringResource(id = R.string.pref_appearance_title)) },
            icon = { Icon(Icons.Outlined.Palette, null) },
            onClick = { navigator.push(AppearancePreferencesScreen) },
          )
          preference(
            key = "player",
            title = { Text(text = stringResource(id = R.string.pref_player)) },
            icon = { Icon(Icons.Outlined.PlayCircle, null) },
            onClick = { navigator.push(PlayerPreferencesScreen) },
          )
          preference(
            key = "decoder",
            title = { Text(text = stringResource(id = R.string.pref_decoder)) },
            icon = { Icon(Icons.Outlined.Memory, null) },
            onClick = { navigator.push(DecoderPreferencesScreen) },
          )
          preference(
            key = "subtitles",
            title = { Text(text = stringResource(id = R.string.pref_subtitles)) },
            icon = { Icon(Icons.Outlined.Subtitles, null) },
            onClick = { navigator.push(SubtitlesPreferencesScreen) },
          )
          preference(
            key = "audio",
            title = { Text(text = stringResource(id = R.string.pref_audio)) },
            icon = { Icon(Icons.Outlined.Audiotrack, null) },
            onClick = { navigator.push(AudioPreferencesScreen) },
          )
          preference(
            key = "advanced",
            title = { Text(text = stringResource(R.string.pref_advanced)) },
            icon = { Icon(Icons.Outlined.Code, null) },
            onClick = { navigator.push(AdvancedPreferencesScreen) }
          )
        }
      }
    }
  }
}
