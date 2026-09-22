#TogetherWeServe

OPSC6312 — Open Source Coding (Intermediate) — Part 2: App Prototype Development**
#purpose
TogetherWeServe is an Android app that connects community volunteers with local,
cause-based volunteering opportunities, and gives non-profit organisations (NPOs)
a simple way to publish and manage sign-ups. This prototype builds directly on the
Part 1 Research Report and Planning & Design document, implementing the
architecture, screens and REST API designed there.

#Key differentiator: real group/team sign-up
Unlike the three apps researched in Part 1 (POINT, SignUp.com, Eventvolunteers),
TogetherWeServe lets a volunteer create a **named group** for an event and share a
generated **invite code** with friends, family or a workplace team. Anyone entering
that code is registered against the same event slot, so an organiser can see the
group together — supporting logistics like carpooling and skill-matching.

#Features implemented in this prototype
| Registration & secure login (password never stored/sent in plain text) | `auth/LoginActivity.kt`, `auth/RegisterActivity.kt` |
| Single sign-on (Google) | `auth/LoginActivity.kt` |
| Settings management | `ui/settings/SettingsFragment.kt` |
| REST API connected to a database | `functions/src/index.ts`, `data/remote/ApiService.kt` |
| Offline mode with sync (RoomDB) | `data/local/`, `data/repository/EventRepository.kt` |
| Real-time push notifications (FCM) | `fcm/TwsFirebaseMessagingService.kt`, `onEventCreated` trigger |
| Multi-language support (English / isiZulu) | `res/values/strings.xml`, `res/values-zu/strings.xml` |
| Event discovery (search + cause filter) | `ui/home/HomeFragment.kt`, `utils/EventFilter.kt` |
| Group/team sign-up (innovative feature) | `ui/group/GroupSignupActivity.kt` |
| Organiser event creation | `ui/organiser/CreateEventActivity.kt` |

#Tech Stack
- Language: Kotlin
- UI: Android Views / Jetpack Components, Material Design
- Backend: Firebase (Authentication, Cloud Firestore, Cloud Functions)
- Build System: Gradle (KTS)
- IDE: Android Studio

*(Add your own write-up here — max 500 words — describing where AI tools were
used, e.g. for scaffolding boilerplate Kotlin/TypeScript, and how it was cited,
per the assessment instructions.)*
