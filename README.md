🗳️ VoteSure - Secure Online Voting Platform

CastSure is a modern, secure, and transparent web-based voting platform designed for educational institutions, organizations, and small-scale elections. Built with **Spring Boot**, **Thymeleaf**, and **H2 Database**, it allows users to register, log in, and cast their vote securely — all from a clean and responsive web UI.

---
🚀 Features

- 🔒 Secure voter registration with **strong password validation**
- 📧 Email-based login system
- ✅ Prevents multiple voting with one account
- 🧠 Session-based authentication
- 🖥️ Responsive and modern UI using **Bootstrap 5**
- 💾 In-memory H2 database (perfect for demos/interviews)
- ⚡ Fast and lightweight Spring Boot backend
---

🛠️ Tech Stack

| Layer        | Technology                               |
| ------------ | ---------------------------------------- |
| Backend      | Spring Boot, Spring MVC                  |
| Frontend     | Thymeleaf, Bootstrap                     |
| Security     | Custom password validation (regex-based) |
| Database     | H2 (in-memory), MySQL (optional)         |
| ORM          | JPA with Hibernate                       |
| Build Tool   | Maven                                    |
| Java Version | Java 21                                  |
---
📂 Project Structure
```
securevoting/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── votingsystem/
│   │   │           └── securevoting/
│   │   │               ├── controller/
│   │   │               │   └── VoterViewController.java
│   │   │               ├── model/
│   │   │               │   └── Voter.java
│   │   │               ├── repository/
│   │   │               │   └── VoterRepository.java
│   │   │               └── SecureVotingApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   └── (static files: CSS/JS/images if any)
│   │       ├── templates/
│   │       │   ├── register.html
│   │       │   ├── login.html
│   │       │   ├── vote.html
│   │       │   ├── success.html
│   │       │   └── alreadyVoted.html
│   │       └── application.properties
├── .gitignore
├── pom.xml
└── README.md
```

---

## 📝 How It Works

### 🔐 Voter Registration

- Voters must enter a full name, email, and a **strong password**:
  - Minimum 8 characters
  - At least 1 uppercase, 1 lowercase, 1 number, and 1 special character
- Client-side JS ensures instant feedback if the password is weak

### 🔓 Login

- Email + Password-based login
- Validated via the H2 database
- On success, session is initiated

### 🗳️ Voting

- Only authenticated users can vote
- Each voter can vote only **once** (tracked using a `hasVoted` boolean)
- After voting, they are redirected to a success screen

---


## 🔧 How to Run

### ✅ Prerequisites

- Java 21
- Maven 3+

### 💡 Steps

```bash
# Clone the project
git clone https://github.com/your-username/securevoting.git
cd securevoting

# Build & run
./mvnw spring-boot:run



