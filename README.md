# ERP_IIITKota

An Android-based ERP application designed for IIIT Kota, with separate flows for students and staff members. The app provides a simplified academic and administrative dashboard for login, registration, announcements, course data, attendance, assignments, and library-related information.

## Overview

This project is a Kotlin-based Android app built around a model-view architecture and Room-backed persistence. It supports a multi-role workflow where a user chooses whether they are a student or staff member, logs in, and then accesses role-specific screens and actions.

The app is a practical example of a campus management application with functionality covering:

- student and faculty login
- registration screens for both roles
- course and academic information
- assignment tracking
- attendance management
- announcements and events
- book/library records

## Tech stack

- Kotlin
- Android SDK
- AndroidX
- ViewModel and Android architecture components
- Room persistence library
- Navigation component
- Retrofit + Gson
- Anko for background tasks
- Material Components

## Project structure

```text
.
├── .idea/                  # IDE metadata
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/       # Kotlin application source files
│   │   │   ├── res/        # Layouts, drawables, strings, styles
│   │   │   └── AndroidManifest.xml
│   └── build.gradle        # App module Gradle config
├── build.gradle            # Root Gradle config
├── gradle.properties       # Gradle properties
├── gradlew                 # Gradle wrapper
├── gradlew.bat             # Windows wrapper
├── settings.gradle         # Gradle project settings
├── .gitignore              # Git ignore rules
└── README.md               # Project documentation
```

## Role-based workflow

The application starts with a selection screen where the user chooses either:

- `Staff`
- `Student`

This choice loads the corresponding login or registration flow. The main activity (`MainActivity.kt`) handles:

- role selection
- credential validation
- navigation to staff or student-specific screens
- back-navigation logic for role selection

The `ErpViewModel` is used as the central access layer for repository-backed operations such as:

- loginStudent
- loginTeacher
- studentInsert
- teacherInsert
- getCourses
- getStudents
- getAssignments
- getAnnouncements
- getAttendance
- getBooks
- getTeachers

## Core components

### Main activity

`app/src/main/java/com/example/erp/MainActivity.kt` is the app entry flow and handles:

- role choice
- login form validation
- registration navigation
- opening student or staff screens depending on the selected role

### ViewModel layer

`ErpViewModel.kt` exposes repository calls for reading and writing academic and admin data. It acts as the bridge between the UI and the underlying data layer.

### Repository/data layer

The repository layer interfaces with app objects and persistence logic for entities such as:

- `AnnouncementObj`
- `Assignments`
- `Attendance`
- `Books`
- `Courses`
- `EventObj`
- `Student`
- `Professor`

## App features

- Student login and registration
- Faculty/staff login and registration
- Course information retrieval
- Assignment and event tracking
- Attendance records
- Library book management
- Announcement feed for institutional updates

## Dependencies

The app uses the following major dependencies as declared in `app/build.gradle`:

- AndroidX AppCompat
- Navigation components
- Room database
- Lifecycle extensions
- Material Design components
- Retrofit
- Gson
- Anko Commons
- CircleImageView
- JUnit for testing

## Build and run

### Prerequisites

- Android Studio
- JDK 8+
- Android SDK configured
- Gradle wrapper available in the project

### Build

```bash
./gradlew build
```

### Run

Open the project in Android Studio and run the app on an emulator or connected device.

## Notes

This repository appears to be a college ERP prototype rather than a full production-ready enterprise system. It demonstrates how a university administration app can organize student and staff workflows on Android using modern Android libraries and a MVVM-inspired architecture.

## License

No explicit license file was found in the root repository contents, so licensing terms should be confirmed before reuse or redistribution.
