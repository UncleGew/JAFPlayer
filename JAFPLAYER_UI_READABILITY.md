# JAFPlayer — TV-sized navigation and accessibility requirements

Status: DESIGN SPECIFICATION + INITIAL KOTLIN SIZE TOKENS ONLY. Not yet wired into OwnTV screens, and not device-tested.

## Product intent
Make navigation, Live TV, Guide, Favorites, Movies, Series, and Settings readable at living-room distance on Onn 4K Pro, Onn 4K Plus, and Onn 4K Stick. Avoid changing actual video zoom/aspect ratio when scaling controls.

## User-facing setting: Display Size
- Standard: lower density for small screens.
- Large: **JAFPlayer default**, readable on an ordinary living-room TV.
- Extra Large: accessibility-oriented setting that enlarges the whole UI.
- Store the choice per device, persist after updates and restarts, and expose it in Settings > Appearance > Display Size. Also offer it in initial setup.
- Existing upstream font-size settings may overlap: audit both and choose a single predictable precedence to prevent double scaling.

### Suggested initial dimension tokens
Sizes use Android density-independent pixels (dp) for layout, scaled pixels (sp) for typography. Validate and tune on real devices rather than hardcoding pixel dimensions.

| Element | Standard | Large (default) | Extra Large |
|---|---:|---:|---:|
| Main/menu icons | 32 dp | 42 dp | 50 dp |
| Small action icons | 24 dp | 32 dp | 38 dp |
| Menu labels | 18 sp | 23 sp | 27 sp |
| Channel names | 18 sp | 22 sp | 26 sp |
| Channel logos (bounding box) | 44 dp | 56 dp | 64 dp |
| Live channel rows (min height) | 64 dp | 80 dp | 96 dp |
| Guide show titles | 16 sp | 20 sp | 24 sp |
| Settings labels | 18 sp | 22 sp | 26 sp |
| Screen headings | 26 sp | 32 sp | 38 sp |
| D-pad focused border | 2 dp | 3 dp | 4 dp |

## Non-negotiable D-pad and contrast behavior
1. Focus indicator uses a clear gold outline with a dark opaque backdrop for text; do not depend only on a subtle scale animation.
2. Never crop channel names or program titles silently: allow wrapping, ellipsis plus accessible detail, or marquee on focus. Avoid text overlapping the adjacent time slots in the Guide.
3. D-pad traversal must not skip channel rows and must restore a visible focused item after Back, hide/unhide, page refresh, or the guide returning from playback.
4. Favorites star state must be legible and distinguishable from focus; long-press OK still toggles Favorites and short OK opens/plays channels, with context menu on an alternate key.
5. Make selectable items at least 48 x 48 dp and ensure text is readable against the actual UI background.
6. Preserve video display aspect ratio; scaling affects UI chrome, not streams.
7. Guide must be horizontally scrollable when Extra Large results in fewer visible time columns, rather than compressing typography.
8. Keep brand design separate from actual app readibility; default gold and dark surfaces, with focus state distinguishable for low-vision users.

## Engineering integration points (OwnTV Android TV Compose project)
- A Kotlin size-token scaffold is installed in the app UI package by setup_jafplayer.py. Tokens alone DO NOT change OwnTV's screens.
- Wire the tokens to actual Compose components for app shell/navigation, Live list, Guide grid, VOD panels, player HUD, dialogs, Settings and onboarding.
- Define per-device persisted Display Size (e.g. DataStore) and feed the chosen enum through Compose state at root; avoid mutable global scale variables.
- Consolidate with upstream Settings > Appearance font size and adjustable panel widths. Audit any existing upstream `fontScale` option before altering defaults.
- Use `Dp` for icon/row dimensions and `TextUnit` for font sizes. Test system font scale effects, overscan, and TV resolutions separately.
- In channel lists, use a stable key and remember focus during refresh; do not trigger a new playlist/EPG fetch when changing display size.
- Build with Android Studio/Gradle, test on Onn devices with both 720p and 1080p UI resolutions. Benchmark long lists on low-memory stick before distribution.

## Acceptance tests
- [ ] On first launch, JAFPlayer uses Large mode; icon/menu/EPG sizes visually match documented targets.
- [ ] Standard / Large / Extra Large changes update all relevant views immediately and persist after relaunch.
- [ ] Main navigation icons and names can be read from a normal TV viewing distance; no clipped words or menus at 720p or 1080p.
- [ ] Live Guide remains usable; time grid scrolls when needed rather than shrinking the show titles.
- [ ] Full-screen player controls and time-out overlays have larger readable labels.
- [ ] Focused control is unambiguous on Home, category list, EPG, Search, Settings and Multiview.
- [ ] Long-press Favorites still works and favorite star can be seen from a distance.
- [ ] Text remains readable when Android's own font size is enlarged; no repeated scaling or collisions.
- [ ] Large mode does not cause unacceptable slowdown on the Onn 4K Stick.

Keep actual customer passwords, provider URLs with tokens, and personal data out of source/test media.

## Black-and-gold theme integration

All size modes must adopt the JAFPlayer palette in `JAFPLAYER_BRAND_THEME.md`. The default is black/gold/white, not system-dependent light/dark. Focus gold uses at least 3 dp border at Large mode, but selected gold rows use dark text and icon for contrast. Theme color scaffold is not yet wired to actual screens.
