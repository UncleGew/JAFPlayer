/*
 * JAFPlayer Compose for TV theme wrapper.
 * This wrapper is NOT yet called by upstream OwnTV screens.
 * Wire into the existing app root while preserving user settings and typography.
 */
package tv.own.owntv.ui.theme

import androidx.compose.runtime.Composable
import androidx.tv.material3.MaterialTheme

@Composable
fun JafPlayerTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = JAFPLAYER_DARK_SCHEME, content = content)
}
