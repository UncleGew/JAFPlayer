# JAFPlayer (development fork of OwnTV)

This directory was produced using the JAFPlayer fork bootstrap script.

- Upstream: https://github.com/ahXN00/OwnTV.git
- Original copyright and GPLv3 license are retained in `LICENSE`.
- Android application ID: `com.jafplayer.player.devfork` (independent installation)
- Kotlin namespace remains `tv.own.owntv` for source compatibility.
- Display name: JAFPlayer. Upstream icons and any remaining OwnTV screens
  have NOT yet been rebranded. Branding is not complete.
- OwnTV_Core remains a dependency from the upstream public Maven repository.

## Important release blockers

This is a DEVELOPMENT starting point, NOT a client-ready JAFPlayer APK.

1. Long-press OK in upstream OwnTV opens the context menu. Implement
   direct Favorites toggling for Live TV, Guide and Multiview, avoiding
   breakage of other menus. Confirm alternate route to context actions.
2. Audit and replace/disable upstream OwnTV in-app update checks.
   An OwnTV official APK must never be installed as a JAFPlayer update.
3. Replace upstream icon/banner with original JAFPlayer artwork and
   audit all in-app name strings; review icon-switcher behavior.
4. Confirm IPTVEditor Xtream Codes and separate XMLTV sources work,
   including Trex-origin channels, guide overrides, and favorites.
5. Create your OWN release signing key and release/update workflow.
6. Check GPLv3 corresponding-source obligations, including GPLv3
   code used from the separate OwnTV_Core repository.
7. Verify customer setup does not replicate other customers' credentials,
   account tokens, recovery details, or personal viewing history.
8. Review other third-party trademarks, asset licenses, and API terms.
9. Implement UI readability requirements: larger icons, text, channel
   logos and focus indicators, with persisted Standard/Large/Extra Large
   modes (Large default). See JAFPLAYER_UI_READABILITY.md.
   Kotlin size tokens are scaffold only: no screen yet reads them.
10. Wire black/gold/white default TV theme into app root, user settings,
    first-run onboarding and every screen; test contrast and selected states.
    Palette/wrapper Kotlin files are scaffold only (NOT activated).
    See JAFPLAYER_BRAND_THEME.md.

JAFPlayer must remain GPLv3 when distributed. Providing an installable APK
to customers requires that corresponding source code and license notices
are available to those recipients under the GPLv3 terms.

This fork contains no IPTV channels, credentials or service subscriptions.
Use sources for which the customer has lawful access.
