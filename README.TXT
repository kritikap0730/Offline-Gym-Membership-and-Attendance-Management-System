# 🏋️ Offline Gym Membership and Attendance Management System

A Java-based desktop application for managing gym members, memberships, attendance, and member records. The system provides a graphical user interface (GUI) and supports different membership types, including Regular and Premium members.

This project was developed as an academic project to demonstrate **Object-Oriented Programming (OOP), Java GUI development, file handling, inheritance, and member management**.

---

## 📌 Project Overview

The **Offline Gym Membership and Attendance Management System** is designed to help gym administrators manage member information and gym activities without requiring an internet connection or online database.

The system allows administrators to register members, manage their membership information, handle different membership types, track attendance, and store member records using local files.

---

## ✨ Features

### 👤 Member Management

* Add new gym members
* Store member details
* View existing members
* Manage Regular and Premium memberships
* Update member information

### 🏃 Membership Management

* Supports **Regular Members**
* Supports **Premium Members**
* Different membership charges and features
* Membership status management
* Membership-related information tracking

### 📋 Attendance Management

* Record member attendance
* Track attendance-related information
* Manage member attendance through the GUI

### 💾 File Handling

* Stores Regular Member information in `RegularMembers.txt`
* Stores Premium Member information in `PremiumMembers.txt`
* Allows member information to persist between program sessions

### 🖥️ Graphical User Interface

* Java GUI-based interface
* User-friendly controls
* Forms for entering member information
* Buttons for performing different management operations

---

## 🛠️ Technologies Used

| Technology                      | Purpose                             |
| ------------------------------- | ----------------------------------- |
| **Java**                        | Main programming language           |
| **Java Swing / GUI**            | Graphical user interface            |
| **Object-Oriented Programming** | Application architecture            |
| **File Handling**               | Storing member information          |
| **BlueJ**                       | Development environment             |
| **Git & GitHub**                | Version control and project hosting |

---

## 🧠 OOP Concepts Demonstrated

This project demonstrates several important Object-Oriented Programming concepts:

### Inheritance

`RegularMember` and `PremiumMember` inherit common attributes and functionality from the `GymMember` class.

```text
                 GymMember
                 /       \
                /         \
       RegularMember   PremiumMember
```

### Encapsulation

Member information and related operations are organized within individual classes.

### Polymorphism

Different member types can implement or behave differently while sharing common functionality from the parent class.

### Abstraction

Common member-related functionality is separated from the specific behavior of Regular and Premium members.

---

## 📂 Project Structure

```text
Offline-Gym-Membership-and-Attendance-Management-System/
│
├── GymGUI.java
├── GymMember.java
├── RegularMember.java
├── PremiumMember.java
│
├── RegularMembers.txt
├── PremiumMembers.txt
│
├── package.bluej
│
└── README.md
```

### Main Classes

**`GymMember.java`**

Contains the common attributes and functionality shared by gym members.

**`RegularMember.java`**

Represents members registered under the Regular membership category.

**`PremiumMember.java`**

Represents members registered under the Premium membership category.

**`GymGUI.java`**

Provides the graphical interface through which users interact with the system.

---

## 🚀 How to Run

### Using BlueJ

1. Clone or download this repository.
2. Open **BlueJ**.
3. Open the project folder.
4. Open the project containing `package.bluej`.
5. Compile the Java classes.
6. Run the `GymGUI` class.
7. The application GUI will open.

### Using Command Prompt

Make sure Java is installed on your computer.

Compile the Java files:

```bash
javac *.java
```

Run the GUI:

```bash
java GymGUI
```

---

## 💾 Data Storage

The application uses local text files instead of an online database.

```text
RegularMembers.txt
PremiumMembers.txt
```

This makes the application suitable for **offline gym management** and demonstrates Java file-handling techniques.

---

## 🎯 Project Objectives

The main objectives of this project are to:

* Develop a functional gym management application using Java.
* Apply Object-Oriented Programming principles.
* Implement inheritance using different membership types.
* Develop a graphical user interface.
* Manage member information efficiently.
* Implement attendance management.
* Use file handling for persistent data storage.
* Develop an application that can operate without an internet connection.

---

## 🔮 Future Improvements

The system could be further improved by adding:

* 🔐 Admin login and authentication
* 📊 Attendance reports and statistics
* 🔎 Member search and filtering
* 💳 Payment and transaction management
* 📅 Membership expiry notifications
* 📈 Dashboard with gym statistics
* 🗄️ Database integration using MySQL
* 📄 Report generation
* 📱 Mobile application support
* ☁️ Online/cloud-based data synchronization
* 🖼️ Improved modern GUI design

---

## 📚 Academic Context

This project was developed as part of an academic **Java/Object-Oriented Programming** project, with emphasis on practical implementation of:

* Classes and objects
* Inheritance
* Encapsulation
* Polymorphism
* GUI programming
* File handling
* Application design

---

## 👩‍💻 Author

**Kritika Pandey**



---

## 📄 License

This project was developed for educational and academic purposes.

