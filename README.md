# Translator

This project is a demonstration of using Gemini to detect spoken language and translate the spoken sentence into a selected language.

## ✨ Features

- **🎤 Voice Input**: Captures user speech for translation.
- **🌐 Language Detection**: Automatically identifies the source language.
- **🤖 AI-Powered Translation**: Uses the Gemini API for accurate translation.
- **🔊 Text-to-Speech**: Listen to the pronunciation of translated text.

## 🛠️ Tech Stack & Libraries

- **UI**: [Jetpack Compose](https://developer.android.com/jetpack/compose) with [Material 3](https://m3.material.io/).
- **Architecture**: Clean Architecture, MVVM, Repository Pattern.
- **Asynchronous**: [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) for managing background threads.
- **AI**: [Google AI Client SDK for Android](https://developers.google.com/learn/pathways/solution-ai-gemini-getting-started-android) (`com.google.ai.client.generativeai`).
- **Dependency Injection**: [Hilt](https://dagger.dev/hilt/).
- **Local Storage**: [Room](https://developer.android.com/training/data-storage/room) (if you've added history).

## 🚀 Getting Started

### Prerequisites

- Android Studio Koala (2024.1.1) or newer.
- Android SDK 34+.
- An API Key from [Google AI Studio](https://ai.google.dev/).

### Setup Instructions

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/anandmali/Translator.git
   cd Translator
   ```

2. **Obtain Gemini API Key**:

    - Visit [Google AI Studio](https://ai.google.dev/)
    - Create a new project and generate an API key

3. **Configure API Key**:

    - Create a `local.properties` file in the root directory
    - Add the following line:

      ```properties
      GEMINI_API_KEY=your_api_key_here
      ```
