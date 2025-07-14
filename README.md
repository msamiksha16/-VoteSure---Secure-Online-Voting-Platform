🗳️ VoteSure - Secure Online Voting Platform

CastSure is a modern, secure, and transparent web-based voting platform designed for educational institutions, organizations, and small-scale elections. Built with **Spring Boot**, **Thymeleaf**, and **H2 Database**, it allows users to register, log in, and cast their vote securely — all from a clean and responsive web UI.


🚀 Features

- 🔒 Secure voter registration with **strong password validation**
- 📧 Email-based login system
- ✅ Prevents multiple voting with one account
- 🧠 Session-based authentication
- 🖥️ Responsive and modern UI using **Bootstrap 5**
- 💾 In-memory H2 database (perfect for demos/interviews)
- ⚡ Fast and lightweight Spring Boot backend


🛠️ Tech Stack

| Layer        | Technology             |
|--------------|------------------------|
| Backend      | Spring Boot (3.5.3)    |
| Frontend     | Thymeleaf + Bootstrap  |
| Database     | H2 (in-memory)         |
| Build Tool   | Maven                  |
| Java Version | 21                     |

📂 Project Structure
securevoting/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── votingsystem/
│       │           └── securevoting/
│       │               ├── controller/
│       │               │   └── VoterViewController.java
│       │               ├── entity/
│       │               │   └── Voter.java
│       │               └── repository/
│       │                   └── VoterRepository.java
│       └── resources/
│           ├── templates/
│           │   ├── register.html
│           │   ├── success.html
│           │   ├── login.html
│           │   ├── vote.html
│           │   ├── voteSuccess.html
│           │   └── alreadyVoted.html
│           └── application.properties

