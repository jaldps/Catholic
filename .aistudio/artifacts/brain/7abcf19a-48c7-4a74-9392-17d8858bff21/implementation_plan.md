# Implementation Plan: Liturgical Calendar, Vatican Night Prayers & Novenas, Scripture Study Course, and Marian & Christological Devotions

## Overview
This plan implements the comprehensive Catholic liturgical and devotional expansion requested:
1. **Liturgical Calendar & Mass Readings Room Architecture**: Entities for storing and caching liturgical calendar days, Sunday (Year A/B/C) and Weekday (Year I/II) lectionary cycles, liturgical ranks, colors, and complete daily Mass readings (First Reading, Psalm, Second Reading, Gospel, Missal meditation, and fasting rules).
2. **Official Vatican Night Prayers & Complete Novenas**:
   - **Full Roman Breviary Compline**: Complete Liturgy of the Hours night office (Opening, Examination of Conscience with Confiteor, Hymn *Te lucis ante terminum*, Psalmody Psalms 4/91/134, Reading, Responsory *In manus tuas*, Canticle of Simeon *Nunc Dimittis* with antiphon, Concluding Prayer, and seasonal Marian Antiphon: *Salve Regina*, *Sub Tuum Praesidium*, *Alma Redemptoris Mater*, *Ave Regina Caelorum*, *Regina Caeli*).
   - **Simplified Evening Examen**: 5-step Ignatian review (Gratitude, Light, Review, Contrition, Resolution) with final Marian prayer.
   - **Complete 9-Day Novenas**: Unabridged day-by-day prayers for Sacred Heart, Divine Mercy, Our Lady of Mount Carmel, Our Lady of Guadalupe, St. Jude Thaddaeus, St. Joseph, and Holy Spirit.
3. **Vatican Scripture Study Course**:
   - Thematic tracks based on Vatican *Dei Verbum* and the Catechism: **Sacraments of the Church**, **Parables of the Kingdom**, and **Apostolic Teachings & Pauline Epistles**.
   - Structured reading passages, Vatican commentary context, guided Lectio Divina reflection prompts, and Room-persisted study progress tracking.
4. **Comprehensive Marian Advocations Directory**:
   - Dozens of prominent Marian advocations categorized by **Region** (Latin America/Americas, Europe, Asia/Africa, Universal) and **Patronage**, with instant search.
   - Detailed entries (Virgen del Valle, Virgen del Carmen, Virgen de Guadalupe, Caridad del Cobre, Aparecida, Coromoto, Luján, Chiquinquirá, Suyapa, Caacupé, Copacabana, Fátima, Lourdes, Knock, Czestochowa, Pilar, etc.) featuring origin, historical timeline, patronages, documented miracles, major sanctuaries/basilicas, and traditional prayers.
5. **Christ Manifestations & Devotions Directory**:
   - Dozens of Christological manifestations and titles (Niño Jesús de Praga, Santo Niño de Atocha, Divino Niño Jesús de Bogotá, Sagrado Corazón de Jesús, Cristo Nazareno de San Pablo/Portobelo, Señor de los Milagros de Lima, Señor de Esquipulas, Santo Cristo de La Grita, Cristo de Medinaceli, Señor de la Misericordia / Divine Mercy, Cristo Rey, etc.).
   - Detailed historical context, theological significance, sanctuaries, feast days, and veneration prayers.

---

## Architecture & Data Model

### 1. Room Database Updates (`data/local/`)
- **`LiturgicalDayEntity`**:
  - `date`: `String` (PK, "YYYY-MM-DD")
  - `season`: `String` (ADVENT, CHRISTMAS, LENT, EASTER, ORDINARY_TIME)
  - `liturgicalColor`: `String` (VIOLET, WHITE, GREEN, RED, ROSE)
  - `rank`: `String` (SOLEMNITY, FEAST, MEMORIAL, OPTIONAL_MEMORIAL, FERIAL)
  - `title`: `String`
  - `sundayCycle`: `String` ("Year A", "Year B", "Year C")
  - `weekdayCycle`: `String` ("Year I", "Year II")
  - `firstReading`: `String` (reference + text)
  - `responsorialPsalm`: `String` (response + verses)
  - `secondReading`: `String` (optional)
  - `gospelAcclamation`: `String`
  - `gospel`: `String` (reference + text)
  - `missalMeditation`: `String`
  - `fastingRule`: `String`
- **`ScriptureCourseProgressEntity`**:
  - `courseId`: `String` (PK)
  - `lessonId`: `String`
  - `completedDate`: `Long`
  - `notes`: `String`
- **`SanctaFidesDatabase`**:
  - Increment database version to 3, add new entities and DAOs with fallback migration.

### 2. Devotional & Scripture Domain Models (`data/models/`)
- `MarianAdvocation`: `id`, `name`, `titles`, `region`, `country`, `feastDate`, `patronageOf`, `originHistory`, `miracles`, `sanctuaryName`, `sanctuaryLocation`, `traditionalPrayer`, `imageUrl` or icon.
- `ChristDevotion`: `id`, `name`, `type`, `region`, `country`, `feastDate`, `historicalOrigin`, `miraclesAndTradition`, `primarySanctuary`, `traditionalPrayer`.
- `ScriptureStudyCourse`: `id`, `trackType`, `title`, `description`, `lessons` (each with biblical passages, Vatican commentary, reflection questions, and resolution).
- `NightPrayerOffice`: Models for Compline and Simplified Examen with bilingual Latin/Spanish/English texts.

### 3. Repository Layer (`data/repository/`)
- **`LiturgicalCalendarRepository`**: Provides liturgical calendar calculation and mass readings for any calendar date, with offline Room caching.
- **`DevotionsAndHistoryData.kt`**: Substantially expanded with dozens of authentic Marian and Christological devotions from Catholic ecclesiastical sources.
- **`ScriptureStudyData.kt`**: Complete curriculum for Sacraments, Parables, and Apostolic Teachings.
- **`PrayerAndNovenaData.kt`**: Full 9-day text sets for all featured Novenas and the full Roman Breviary Compline structure.

---

## UI & Presentation Design

1. **Liturgical Calendar & Daily Mass Screen (`LiturgicalCalendarScreen.kt`)**:
   - Elegant gold-accented header showing current date, Liturgical Season banner, Sunday Lectionary Cycle badge (Year A/B/C), and Weekday Cycle (I/II).
   - Card tabs for First Reading, Responsorial Psalm, Second Reading (when applicable), Gospel Acclamation, and Gospel.
   - Daily Missal Reflection drawer with audio TTS lector button.
   - Fast & Abstinence alert chip when observed.

2. **Night Prayer / Compline Experience (`NightPrayersScreen.kt`)**:
   - Segmented toggle at top: **"Roman Compline (Breviary)"** vs **"Evening Examen (Ignatian)"**.
   - Full Compline: Interactive prayer steps (Examination of Conscience with Confiteor, Hymn, Psalms, Reading, Responsory, Nunc Dimittis with antiphon, Blessing, and Marian Antiphon with seasonal selector).
   - Audio lector with solemn liturgical cadence.

3. **Vatican Scripture Study Screen (`ScriptureStudyScreen.kt`)**:
   - Thematic track selector: **Sacraments of Grace**, **Parables of the Kingdom**, and **Apostolic Teachings**.
   - Course overview with progress bar and lesson badges.
   - Lesson detail modal / screen: Scripture passage viewer, Vatican Catechism cross-references, guided 4-step Lectio Divina (Lectio, Meditatio, Oratio, Contemplatio), personal reflection notes, and completion checkmark.

4. **Marian Advocations & Christ Devotions Explorer (`DevotionsExplorerScreen.kt`)**:
   - Top search bar with instant filter across names, countries, patronages, and miracles.
   - Main tabs: **"Advocaciones Marianas"** & **"Devociones a Cristo"**.
   - Sub-filters by Region: **Americas / Latin America**, **Europe**, **Universal & Others**, and by **Patronage Category**.
   - Rich Devotion Detail Sheet: Historical origin, documented miracles, sanctuary details with pilgrim guides, and full traditional veneration prayer.

---

## Verification & Testing
1. **Compilation**: Execute `compile_applet` to confirm clean compilation across all Kotlin DSL Gradle scripts and Compose screens.
2. **Local JVM Testing**: Run `gradle :app:testDebugUnitTest` with Robolectric test coverage verifying:
   - Room database CRUD operations for liturgical day readings and scripture course progress.
   - Marian and Christ devotions repository querying, regional filtering, and search functionality.
   - Novena day progression and Compline prayer sequence generation.
