# TogetherWeServe

**OPSC6312 — Open Source Coding (Intermediate) — Part 2: App Prototype Development**

TogetherWeServe is an Android app that connects community volunteers with local,
cause-based volunteering opportunities, and gives non-profit organisations (NPOs)
a simple way to publish and manage sign-ups. This prototype builds directly on the
Part 1 Research Report and Planning & Design document, implementing the
architecture, screens and REST API designed there.

> Add your own screenshots of the running app here before submission, e.g.
> `![Home screen](docs/screenshots/home.png)`

## Key differentiator: real group/team sign-up

Unlike the three apps researched in Part 1 (POINT, SignUp.com, Eventvolunteers),
TogetherWeServe lets a volunteer create a **named group** for an event and share a
generated **invite code** with friends, family or a workplace team. Anyone entering
that code is registered against the same event slot, so an organiser can see the
group together — supporting logistics like carpooling and skill-matching.

## Architecture

```
Android client (Kotlin, Retrofit, RoomDB)
        │  HTTPS REST (Firebase ID token in Authorization header)
        ▼
Firebase Cloud Functions  ──▶  Cloud Firestore (NoSQL database)
        │
        └──▶ Firebase Cloud Messaging (push notifications)

Firebase Authentication (email/password + Google SSO) issues the ID token
used to authorise every REST call.
```

The Android client never talks to Firestore, Auth, or FCM directly — every
request passes through the custom REST API in `/functions`, which verifies the
caller's identity and applies business rules (e.g. checking slot availability
before confirming a registration) before touching the database.

## Features implemented in this prototype

| Requirement | Where |
|---|---|
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

## Project structure

```
TogetherWeServe/
├── app/                     Android client (Kotlin)
│   └── src/main/java/com/togetherweserve/app/
│       ├── auth/            Login & Register
│       ├── ui/home/         Event feed (discovery)
│       ├── ui/eventdetail/  Event details + join flow
│       ├── ui/group/        Group/team sign-up
│       ├── ui/schedule/     My Schedule (offline-aware)
│       ├── ui/settings/     Settings
│       ├── ui/organiser/    Create Event (NPO)
│       ├── data/local/      Room entities/DAOs (offline cache)
│       ├── data/remote/     Retrofit API service
│       ├── data/repository/ Single source of truth, online/offline logic
│       ├── fcm/             Push notification service
│       └── utils/           SessionManager, ConnectivityObserver, EventFilter
│   └── src/test/            Unit tests (EventFilterTest)
├── functions/               Firebase Cloud Functions (Node.js / TypeScript REST API)
├── firestore.rules          Locks Firestore to server-side (Admin SDK) access only
├── .github/workflows/       GitHub Actions CI (unit tests + debug APK build)
└── README.md
```

## Setup

### 1. Firebase project
1. Create a Firebase project at https://console.firebase.google.com.
2. Enable **Authentication** → Email/Password and Google sign-in methods.
3. Enable **Cloud Firestore** (production mode).
4. Enable **Cloud Messaging**.
5. Register an Android app with package name `com.togetherweserve.app`, download
   `google-services.json`, and place it in `app/`.
6. Copy your **Web client ID** (Authentication → Sign-in method → Google → Web SDK
   configuration) — it is auto-exposed to the app as `R.string.default_web_client_id`
   once `google-services.json` is in place.

### 2. Backend (Cloud Functions)
```bash
cd functions
npm install
firebase login
firebase use --add            # select your Firebase project
npm run deploy
```
After deploying, copy the printed HTTPS function URL and update `BASE_URL` in
`app/src/main/java/com/togetherweserve/app/data/remote/RetrofitClient.kt`.

### 3. Android app
1. Open the project root in Android Studio (Koala or newer).
2. Let Gradle sync (requires the `google-services.json` from step 1).
3. Run on a physical device or emulator with Google Play Services.
4. Sign up an NPO test account and, in Firestore, manually set that user's
   `role` field to `"organiser"` to unlock the **Create Event** screen.

### 4. Unit testing & CI
```bash
./gradlew test
```
`.github/workflows/build.yml` runs the same unit tests and assembles a debug
APK on every push to `main`, per the module's GitHub Actions requirement.

## Offline mode with sync

Event details and the signed-in user's own registrations are cached locally in
RoomDB (`data/local/AppDatabase.kt`). If a user joins or cancels an event while
offline, the action is written to a `pending_actions` queue and the UI
optimistically shows the registration as **"Pending sync"**. When connectivity
returns, `EventRepository.syncPendingActions()` replays the queue against the
REST API and updates the local record to **"Confirmed"**.

## Known limitations of this prototype

- `BASE_URL` in `RetrofitClient.kt` is a placeholder until Cloud Functions is deployed.
- Final image assets, app icon polish and full Play Store preparation are deferred to
  the final PoE submission, per the assessment brief.
- Real-time chat between organisers and volunteers (described in Part 1 research)
  is not yet implemented in this prototype; FCM currently covers new-event and
  reminder notifications only.

## AI tool usage

*(Add your own write-up here — max 500 words — describing where AI tools were
used, e.g. for scaffolding boilerplate Kotlin/TypeScript, and how it was cited,
per the assessment instructions.)*
