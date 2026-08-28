# 🛡️ LexiMill - Password Validator App

A clean, modern, and practical Android application built with **Kotlin** and **XML** that evaluates password strength in real-time, featuring custom UI components, Material Design, and robust input validation.

---

## 📱 Features

- **Real-time Password Validation:** Checks password length and complexity (lowercase letters, uppercase letters, and special characters).
- **Dynamic Feedback:** Updates visual indicators (Weak, Medium, Strong) instantly based on matching criteria.
- **Modern UI/UX:** Built using Material Design components (`TextInputLayout`, `MaterialButton`) with custom corner radii and edge-to-edge layout support.
- **Security & Usability:** Includes built-in password toggle visibility and clean error handling.

---

## 🛠️ Tech Stack & Concepts Covered

- **Language:** Kotlin
- **UI Framework:** Android XML Layouts, ConstraintLayout / LinearLayout, Material Components
- **Architecture & Lifecycle:** ComponentActivity, Activity Lifecycle (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onRestart`, `onDestroy`)
- **Core Logic:** Regular Expressions (`Regex`), Lambda Expressions (`setOnClickListener`), and `when` conditional branching.
- **Version Control:** Git & GitHub

---

## 📂 Project Structure

```text
LexiMill/
├── app/src/main/
│   ├── java/com/youssefshaaban/passwordvalidator/
│   │   └── MainActivity.kt       # Core validation logic & UI bindings
│   ├── res/
│   │   ├── layout/
│   │   │   └── activity_main.xml # Main UI layout
│   │   └── drawable/             # Strength indicator assets & icons
└── README.md