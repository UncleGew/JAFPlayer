# JAFPlayer — Black, Gold, and White interface contract

**Status:** palette + Kotlin Compose TV theme scaffold packaged and auto-copied to a cloned source tree; **NOT integrated in OwnTV screen/root theme yet, not built, not device-tested**.

## Brand color tokens (JAFPlayer default)

| Token | Hex | Use |
|---|---|---|
| Black | `#080808` | App background and lettering on gold selected items |
| Panel | `#1A1A1A` | Sidebars, guide cells, dialogs |
| Raised Panel | `#242424` | Hover/secondary cards |
| Metallic Gold | `#E3BC5C` | Brand/logo text, icons, active tabs, primary actions |
| Focus Gold | `#FFDA72` | Visible D-pad focus border (min 3 dp at Large) |
| Dark Gold | `#9A7935` | Decorative borders; avoid as small text on dark background |
| Soft White | `#F6F6F6` | Channel names, guide titles, main content text |
| Light Gray | `#C9C9C9` | Secondary descriptions |
| Error Red | `#FF7777` | Errors only; not part of primary brand |

### Verified text contrast ratios (WCAG calculation, approximate)
- Soft white on near-black: **18.53:1**
- Light gray on charcoal panel: **10.51:1**
- Gold on near-black: **11.08:1**
- Black on gold selected surface: **11.08:1**
- Focus gold on near-black: **14.8:1**
- **Do not** put white text on the darker gold selection fill; the ratio can fall below 4.5:1.

## Behavior
1. Default is ALWAYS dark black/gold/white on fresh install and after reset. Do not follow system Light mode by default.
2. All menu and EPG backgrounds are opaque near-black/charcoal, not transparent over moving video when that affects readability.
3. Gold is for navigation, action emphasis and focus; most dense EPG and channel text is soft white.
4. Focus border: bright gold (distinct from golden selected icon), 3 dp in default Large mode, 4 dp in Extra Large. Also use size/shape/fill changes where helpful; don't rely on color alone.
5. When a selected row has gold background, its label and icon turn nearly black. Unselected rows use white text and gold/white icons as appropriate.
6. Keep the larger icon and typography scale set out in `JAFPLAYER_UI_READABILITY.md` (Large default, Standard/Extra Large alternatives).
7. Guide program-title truncation should be readable on focus; don't shrink fonts to display more rows.
8. Preserve user-controlled accessibility options (captions, contrast, font) where compatible. Avoid breaking upstream theme configuration.
9. Do not recolor video content or change playback color space.
10. Save user display size settings independently of channel lists / IPTVEditor EPG refresh.

## Development integration task

The bootstrap copies `templates/JafPlayerColors.kt` and `templates/JafPlayerTheme.kt` into
`app/src/main/java/tv/own/owntv/ui/theme/`. **The files alone do NOT change the app appearance.**

After cloning/updating OwnTV, inspect current `app` theme/Appearance settings. Hook `JAFPLAYER_DARK_SCHEME`
into the existing top-level Compose-for-TV `MaterialTheme` provider (preferred), or wrap the app root in
`JafPlayerTheme` while preserving fonts, custom theme and state. Set its theme preference default to dark;
set accent default to `#E3BC5C`; set focus-border default to `#FFDA72`. Screen-level hardcoded colors
may need manual replacement. Ensure user-preference migrations and first-launch behavior work.

**Acceptance criteria:** black/gold/white appears on Home, Live TV, Guide, VOD, multiview HUD,
settings, onboarding, search and dialogs, including after relaunch; gold selection always uses dark
text; no white-on-gold contrast failures; large icons and text do not clip at 720p and 1080p.

**Dependency:** OwnTV uses `androidx.tv.material3` Compose for TV; do not accidentally import
`androidx.compose.material3` color scheme instead.
