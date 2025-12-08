<div align="center">

# 👨‍💻 Kartik Waghmare  
### Android Developer | Jetpack Compose | Motion UI  
📍 Noida, India  

### 🌐 Connect with me  
<a href="https://www.linkedin.com/in/kartikwaghmare/">
  <img src="https://cdn-icons-png.flaticon.com/512/174/174857.png" width="20" />
</a>
&nbsp;&nbsp;
<a href="https://www.instagram.com/mr_illusionist_kartik/">
  <img src="https://cdn-icons-png.flaticon.com/512/2111/2111463.png" width="20" />
</a>

<br/><br/>

<!-- GIF Preview -->
<img src="https://github.com/kartik-workspace/onboarding_screens/blob/master/app/src/main/res/raw/onboarding_gif.gif" width="180"/>

</div>

---

# 🚀 Step-a-thon — Animated Onboarding Flow  
### A Premium Jetpack Compose Motion UI Experience  

---

## 🎥 Demo Video  
▶️ Watch the full onboarding animation:  
https://github.com/kartik-workspace/onboarding_screens/blob/master/app/src/main/res/raw/onboarding_video.mp4

---

## 📸 Screenshots (All Screens in One Row)

<div style="display: flex; justify-content: center; gap: 20px;">
    <img src="https://github.com/kartik-workspace/onboarding_screens/blob/master/app/src/main/res/raw/screen_one.jpeg" width="180"/>
    <img src="https://github.com/kartik-workspace/onboarding_screens/blob/master/app/src/main/res/raw/screen_two.jpeg" width="180"/>
    <img src="https://github.com/kartik-workspace/onboarding_screens/blob/master/app/src/main/res/raw/screen_three.jpeg" width="180"/>
</div>

---

## 🎯 Overview

Step-a-thon is a **premium animated onboarding experience** designed using **Jetpack Compose** and motion-based UI transitions.

A core highlight is the **floating animated starburst background**, powered by:

📁 `challenges_star.json`  
➡ Located in: `/app/src/main/res/raw/challenges_star.json`  

This JSON file animates the `challenges_star_bg.png` with rotation, glow, and pulsating effects across multiple onboarding screens.

---

## ✨ Key Features

- Shared element transitions  
  Robot → Trophy → Gift smooth motion  
- Animated starburst background using Lottie JSON  
- Montserrat font family support  
- Premium image-based CTA buttons  
- Smooth Compose transition animations  
- Modular + clean architecture  

---

## 🛠 Animation Assets

| Asset | Purpose | Path |
|------|---------|------|
| `challenges_star.json` | Controls motion of animated background | `res/raw/` |
| `challenges_star_bg.png` | Base static radial glow | `res/drawable/` |
| `trophy.png` | Shared transition (Screen 1 → 2) | `res/drawable/` |
| `gift_box.png` | Shared transition (Screen 2 → 3) | `res/drawable/` |
| `robot.png` | Screen 1 character | `res/drawable/` |

---

## 🛠 Tech Stack

- Kotlin  
- Jetpack Compose  
- Material 3  
- Lottie Animations  
- Shared Element Transitions  
- Custom Montserrat Fonts  

---

## 📂 Project Structure

```
app/
 ├── src/main/java/com/example/visithealthapplication/
 │    ├── onboarding/
 │    │      ├── ui/
 │    │      │     ├── OnboardingFlow.kt
 │    │      │     ├── screens/
 │    │      │     │     ├── ScreenFirst.kt
 │    │      │     │     ├── ScreenSecond.kt
 │    │      │     │     └── ScreenThird.kt
 │    │      │     ├── components/
 │    │      │     │     └── DotsIndicator.kt
 │    │      │     └── theme/
 │    │
 │    └── MainActivity.kt
 │
 ├── src/main/res/
 │    ├── drawable/ (images)
 │    ├── raw/
 │    │     ├── challenges_star.json
 │    │     ├── onboarding_video.mp4
 │    │     ├── screen_one.jpeg
 │    │     ├── screen_two.jpeg
 │    │     └── screen_three.jpeg
 │    ├── font/ (Montserrat fonts)
 │    └── values/
 │
 └── AndroidManifest.xml
```

---

## 🚀 Getting Started

### Clone the repository

```bash
git clone https://github.com/kartik-workspace/onboarding_screens.git
```

### Run

Open in **Android Studio**, let Gradle sync, and click **Run ▶**.

---

## ⭐ Support

If you found this project helpful or inspiring,  
please support it with a **⭐ star** on GitHub!

