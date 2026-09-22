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

GitHub
we host the TogetherWeServe repository on GitHub, which contains both the Android client (app/) and the Firebase Cloud Functions backend (functions/). Every change we make is committed and pushed to the repository, giving me a full history of the project's development that we can refer back to and that serves as evidence of my ongoing work throughout the project. My workflow is based around the main branch, with pushes and pull requests into main triggering automated checks before code is considered stable. The repository also hosts my README.md, which GitHub renders directly on the repo's homepage, documenting the app's architecture, features, setup instructions, and a demo walkthrough with screenshots.

GitHub Actions
we set up a continuous integration (CI) workflow using GitHub Actions, defined in .github/workflows/build.yml and named "Android CI". This workflow runs automatically on every push to main and on every pull request targeting main, so my code is validated both when we commit directly and when we open a PR.

The workflow runs on a fresh ubuntu-latest virtual machine provided by GitHub, and performs the following steps in order:
Checks out my repository code using actions/checkout@v4.
Sets up JDK 17 (Temurin distribution) using actions/setup-java@v4, which the Android Gradle build requires.
Grants execute permission to the gradlew script, since it isn't executable by default after a fresh checkout on Linux.
Runs my unit tests with ./gradlew test, which will fail the workflow if any test fails.
Builds the full debug APK with ./gradlew assembleDebug, which catches any compilation errors.
Uploads the resulting app-debug.apk as a downloadable build artifact using actions/upload-artifact@v4.

Why I used this setup
Using GitHub Actions gives me continuous integration for the project: every push or pull request is automatically compiled and tested, so I catch broken builds or failing tests within minutes rather than discovering them much later. It also removes any "works on my machine" uncertainty, since the build runs in an identical, clean environment every time rather than relying on my local setup. The green checkmark (or failure) on each commit and pull request gives me — and anyone reviewing the project — clear, objective proof that the app actually builds and passes its tests at that point in time, and the uploaded APK artifact means a working build is always available to download straight from the workflow run without needing to build it locally.
used, e.g. for scaffolding boilerplate Kotlin/TypeScript, and how it was cited,
per the assessment instructions.)*
