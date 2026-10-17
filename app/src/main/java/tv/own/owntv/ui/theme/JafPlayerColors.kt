/*
 * JAFPlayer — accessible black/gold/white theme tokens for Android TV.
 * Design tokens are safe to use in a GPLv3 OwnTV fork.
 * Integration status: scaffold. The actual OwnTV root/theme settings need wiring.
 */
package tv.own.owntv.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.tv.material3.ColorScheme
import androidx.tv.material3.darkColorScheme

object JafPlayerPalette {
    val Black = Color(0xFF080808)
    val Panel = Color(0xFF1A1A1A)
    val RaisedPanel = Color(0xFF242424)
    val Gold = Color(0xFFE3BC5C)
    val FocusGold = Color(0xFFFFDA72)
    val DarkGold = Color(0xFF9A7935)
    val White = Color(0xFFF6F6F6)
    val SecondaryText = Color(0xFFC9C9C9)
    val Danger = Color(0xFFFF7777)
}

/** Black-and-gold default for JAFPlayer. Never put white labels on a gold fill. */
val JAFPLAYER_DARK_SCHEME: ColorScheme = darkColorScheme(
    primary = JafPlayerPalette.Gold,
    onPrimary = JafPlayerPalette.Black,
    primaryContainer = JafPlayerPalette.DarkGold,
    onPrimaryContainer = JafPlayerPalette.Black,
    inversePrimary = JafPlayerPalette.Gold,
    secondary = JafPlayerPalette.SecondaryText,
    onSecondary = JafPlayerPalette.Black,
    secondaryContainer = JafPlayerPalette.RaisedPanel,
    onSecondaryContainer = JafPlayerPalette.White,
    tertiary = JafPlayerPalette.FocusGold,
    onTertiary = JafPlayerPalette.Black,
    background = JafPlayerPalette.Black,
    onBackground = JafPlayerPalette.White,
    surface = JafPlayerPalette.Panel,
    onSurface = JafPlayerPalette.White,
    surfaceVariant = JafPlayerPalette.RaisedPanel,
    onSurfaceVariant = JafPlayerPalette.SecondaryText,
    surfaceTint = JafPlayerPalette.Gold,
    border = JafPlayerPalette.DarkGold,
    error = JafPlayerPalette.Danger,
    onError = JafPlayerPalette.Black,
)
