/*
 * JAFPlayer — display-size tokens for OwnTV fork.
 * Scaffold only: call these tokens from real screens and persist selected mode.
 * No original OwnTV logic is copied into this file.
 */
package tv.own.owntv.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class JafPlayerDisplaySize { STANDARD, LARGE, EXTRA_LARGE }

data class JafPlayerReadability(
    val menuIcon: Dp,
    val actionIcon: Dp,
    val menuLabel: TextUnit,
    val channelName: TextUnit,
    val channelLogo: Dp,
    val channelRowMinHeight: Dp,
    val guideShowTitle: TextUnit,
    val settingsLabel: TextUnit,
    val heading: TextUnit,
    val focusBorder: Dp,
)

fun JafPlayerDisplaySize.readability(): JafPlayerReadability = when (this) {
    JafPlayerDisplaySize.STANDARD -> JafPlayerReadability(
        menuIcon = 32.dp, actionIcon = 24.dp, menuLabel = 18.sp,
        channelName = 18.sp, channelLogo = 44.dp, channelRowMinHeight = 64.dp,
        guideShowTitle = 16.sp, settingsLabel = 18.sp, heading = 26.sp,
        focusBorder = 2.dp,
    )
    JafPlayerDisplaySize.LARGE -> JafPlayerReadability(
        menuIcon = 42.dp, actionIcon = 32.dp, menuLabel = 23.sp,
        channelName = 22.sp, channelLogo = 56.dp, channelRowMinHeight = 80.dp,
        guideShowTitle = 20.sp, settingsLabel = 22.sp, heading = 32.sp,
        focusBorder = 3.dp,
    )
    JafPlayerDisplaySize.EXTRA_LARGE -> JafPlayerReadability(
        menuIcon = 50.dp, actionIcon = 38.dp, menuLabel = 27.sp,
        channelName = 26.sp, channelLogo = 64.dp, channelRowMinHeight = 96.dp,
        guideShowTitle = 24.sp, settingsLabel = 26.sp, heading = 38.sp,
        focusBorder = 4.dp,
    )
}

val JAFPLAYER_DEFAULT_DISPLAY_SIZE = JafPlayerDisplaySize.LARGE
