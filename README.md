# 📱 Mobile Automation Framework

![Java](https://img.shields.io/badge/Java-17+-orange?logo=openjdk)
![Appium](https://img.shields.io/badge/Appium-Mobile%20Automation-662D91?logo=appium)
![TestNG](https://img.shields.io/badge/TestNG-Testing-red)
![Maven](https://img.shields.io/badge/Maven-Build-blue?logo=apachemaven)
![GitHub Actions](https://img.shields.io/badge/CI-GitHub%20Actions-blue?logo=githubactions)

A scalable **Mobile Test Automation Framework** built using **Appium**, **Java**, and **TestNG** following the **Page Object Model (POM)** design pattern.

This project demonstrates industry-standard mobile automation practices including reusable page objects, clean test architecture, reporting, and support for Android device automation.

---

# 🚀 Features

- ✅ Appium-based Mobile Automation
- ✅ Page Object Model (POM)
- ✅ TestNG Framework
- ✅ Reusable Page Objects
- ✅ Explicit Waits
- ✅ Data-Driven Testing
- ✅ Android Device Support
- ✅ HTML Reports
- ✅ Screenshot Capture on Failure
- ✅ Easy to Extend and Maintain
- ✅ CI/CD Ready

---

# 🏗 Framework Architecture

```
Test Scripts
      │
      ▼
Page Objects
      │
      ▼
Utility Classes
      │
      ▼
Appium Driver
      │
      ▼
Android Device / Emulator
```

The framework follows the **Page Object Model (POM)**, separating test logic from UI interactions to improve readability, maintainability, and scalability.

---

# 📂 Project Structure

```text
MobileAutomation
│
├── src
│   ├── main
│   │   ├── pages
│   │   ├── base
│   │   ├── utils
│   │   └── driver
│   │
│   └── test
│       ├── tests
│       └── resources
│
├── reports
├── screenshots
├── test-output
├── pom.xml
└── README.md
```

---

# 🧪 Test Scenarios

Current automation includes:

- Application Launch
- Login Flow
- Navigation Validation
- UI Element Verification
- User Interaction Testing
- Regression Test Execution

The framework is designed to support additional test scenarios with minimal effort.

---

# 🛠 Tech Stack

- Java
- Appium
- TestNG
- Maven
- Android Studio
- Android SDK
- Page Object Model (POM)
- Git & GitHub

---

# 📋 Prerequisites

Before running the project, ensure the following are installed:

- Java JDK 17+
- Maven
- Android Studio
- Android SDK
- Appium Server
- Node.js
- Appium Inspector (Optional)

---

# ⚙️ Installation

## Clone the Repository

```bash
git clone https://github.com/affan-bugbuster/MobileAutomation.git
```

```bash
cd MobileAutomation
```

---

## Install Dependencies

```bash
mvn clean install
```

---

## Start Appium Server

```bash
appium
```

---

## Connect Android Device

Enable:

- Developer Options
- USB Debugging

Verify device connection:

```bash
adb devices
```

Expected output:

```
List of devices attached
emulator-5554    device
```

---

# ▶️ Running Tests

Run all tests:

```bash
mvn test
```

Run a specific TestNG suite:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

# 📊 Reporting

After execution, reports are generated automatically.

Reports:

```
test-output/
```

Screenshots:

```
screenshots/
```

---

# 📱 Supported Platform

| Platform | Status |
|----------|--------|
| Android Emulator | ✅ |
| Physical Android Device | ✅ |
| iOS | 🚧 Planned |

---

# 🎯 Skills Demonstrated

This project showcases practical mobile automation skills including:

- Mobile Test Automation
- Appium
- Java
- TestNG
- Page Object Model (POM)
- Explicit Waits
- Framework Design
- Maven
- Android Automation
- Git & GitHub
- CI/CD Ready Framework

---

# 🔄 Future Enhancements

- iOS Automation Support
- Parallel Execution
- Allure Reporting
- Jenkins Integration
- GitHub Actions Pipeline
- Data-Driven Framework
- API Integration
- Cloud Device Farm Support (BrowserStack / Sauce Labs)

---

# 👨‍💻 Author

**Affan Ahmed**

QA Automation Engineer

### Skills

- Appium
- Playwright
- Selenium
- Java
- JavaScript
- API Testing
- Test Automation

**GitHub**

https://github.com/affan-bugbuster

**LinkedIn**

https://www.linkedin.com/in/affanahmedq/

---

# ⭐ Support

If you found this project helpful, consider giving it a ⭐ on GitHub. Your support helps increase the visibility of the project and encourages future improvements.
