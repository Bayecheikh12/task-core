<div align="center">

# 🚀 Task Core

**Système de gestion de tâches — API RESTful avec Spring Boot**

[![CI/CD Pipeline](https://github.com/Bayecheikh12/task-core/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/Bayecheikh12/task-core/actions/workflows/ci-cd.yml)
[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.11-6DB33F?style=flat&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=flat&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?style=flat&logo=docker&logoColor=white)](https://www.docker.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

</div>

---

## 📋 Table des matières

- [À propos](#-à-propos)
- [Architecture](#-architecture)
- [Tech Stack](#-tech-stack)
- [Prérequis](#-prérequis)
- [Installation](#-installation)
- [API Endpoints](#-api-endpoints)
- [Docker](#-docker)
- [CI/CD](#-cicd)
- [Structure du projet](#-structure-du-projet)
- [Contribuer](#-contribuer)
- [Licence](#-licence)

---

## 📖 À propos

**Task Core** est une API RESTful de gestion de tâches construite avec Spring Boot. Elle permet de créer, lister, mettre à jour et suivre des tâches avec un système de statuts (`TODO`, `IN_PROGRESS`, `DONE`).

Ce projet suit les bonnes pratiques DevOps : conteneurisation Docker, pipeline CI/CD GitHub Actions, gestion sécurisée des secrets via variables d'environnement, et architecture en couches.

---

## 🏗️ Architecture

```
┌──────────────────────────────────────────────────┐
│                   Client (HTTP)                  │
└──────────────────────┬───────────────────────────┘
                       │
                       ▼
┌──────────────────────────────────────────────────┐
│              TaskController (REST)               │
│         POST / GET / PATCH /api/tasks            │
└──────────────────────┬───────────────────────────┘
                       │
                       ▼
┌──────────────────────────────────────────────────┐
│              TaskService (Business)              │
│     createTask · listTasks · updateStatus        │
└──────────────────────┬───────────────────────────┘
                       │
                       ▼
┌──────────────────────────────────────────────────┐
│          TaskRepository (Spring Data JPA)        │
│             findAll · findByStatus               │
└──────────────────────┬───────────────────────────┘
                       │
                       ▼
┌──────────────────────────────────────────────────┐
│                 MySQL Database                   │
│                  Table: tasks                    │
└──────────────────────────────────────────────────┘
```

---

## 🛠️ Tech Stack

| Technologie | Version | Description |
|---|---|---|
| **Java** | 17 | Langage principal |
| **Spring Boot** | 3.5.11 | Framework backend |
| **Spring Data JPA** | - | ORM et accès aux données |
| **MySQL** | 8.0+ | Base de données relationnelle |
| **Maven** | 3.6+ | Gestion des dépendances et build |
| **Docker** | - | Conteneurisation |
| **GitHub Actions** | - | CI/CD Pipeline |

---

## 📋 Prérequis

- **Java 17** ou supérieur
- **Maven 3.6+**
- **MySQL 8.0+**
- **Docker** & **Docker Compose** (optionnel)

---

## 🚀 Installation

### Option 1 : Démarrage rapide avec Docker

```bash
# Cloner le repo
git clone https://github.com/Bayecheikh12/task-core.git
cd task-core

# Configurer les variables d'environnement
cp .env.example .env
# Éditer .env avec votre mot de passe

# Lancer avec Docker Compose
docker-compose up -d
```

L'API sera disponible sur `http://localhost:8085`

### Option 2 : Installation locale

```bash
# Cloner le repo
git clone https://github.com/Bayecheikh12/task-core.git
cd task-core

# Configurer les variables d'environnement
cp .env.example .env

# Créer la base de données MySQL
mysql -u root -p -e "CREATE DATABASE IF NOT EXISTS taskdb;"

# Builder et lancer
mvn clean install
mvn spring-boot:run
```

---

## 📡 API Endpoints

| Méthode | Endpoint | Description |
|---|---|---|
| `POST` | `/api/tasks` | Créer une nouvelle tâche |
| `GET` | `/api/tasks` | Lister toutes les tâches |
| `PATCH` | `/api/tasks/{id}/status?status=IN_PROGRESS` | Modifier le statut d'une tâche |
| `GET` | `/api/tasks/completed/count` | Compter les tâches terminées |

### Exemples cURL

```bash
# Créer une tâche
curl -X POST http://localhost:8085/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title": "Mon premier task", "description": "Description ici"}'

# Lister toutes les tâches
curl http://localhost:8085/api/tasks

# Mettre à jour le statut
curl -X PATCH "http://localhost:8085/api/tasks/1/status?status=DONE"

# Compter les tâches terminées
curl http://localhost:8085/api/tasks/completed/count
```

---

## 🐳 Docker

### Build et exécution

```bash
# Build l'image
docker build -t task-core .

# Exécuter le conteneur
docker run -p 8085:8085 \
  -e DB_URL=jdbc:mysql://host.docker.internal:3306/taskdb \
  -e DB_USERNAME=root \
  -e DB_PASSWORD=your_password \
  task-core

# Ou avec Docker Compose (recommandé)
docker-compose up -d
```

### Architecture Docker

```
docker-compose.yml
├── app (task-core)      → Port 8085
│   └── Dockerfile       → Multi-stage build (JDK → JRE Alpine)
└── mysql                → Port 3306
    └── Volume persistant
```

---

## ⚙️ CI/CD

Le pipeline GitHub Actions exécute automatiquement :

| Étape | Déclencheur | Description |
|---|---|---|
| 🔨 **Build & Test** | Push / PR | Compile le code et exécute les tests |
| 📦 **Package** | Push sur `main` | Génère le JAR |
| 🐳 **Docker Build** | Push sur `main` | Construit l'image Docker |

---

## 📁 Structure du projet

```
task-core/
├── .github/
│   ├── ISSUE_TEMPLATE/          # Templates pour issues
│   └── workflows/
│       └── ci-cd.yml            # Pipeline CI/CD
├── src/
│   ├── main/
│   │   ├── java/sn/isi/l3g1/core/
│   │   │   ├── config/          # Configuration (CORS, etc.)
│   │   │   ├── controller/      # REST Controllers
│   │   │   ├── exception/       # Gestion globale des erreurs
│   │   │   ├── model/           # Entités JPA
│   │   │   ├── repository/      # Accès aux données
│   │   │   ├── service/         # Logique métier
│   │   │   └── task_core/       # Classe principale
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .env.example                 # Template variables d'environnement
├── .gitignore
├── CONTRIBUTING.md              # Guide de contribution
├── Dockerfile                   # Build multi-stage
├── docker-compose.yml           # Orchestration
├── LICENSE                      # Licence MIT
├── pom.xml                      # Configuration Maven
└── README.md                    # Ce fichier
```

---

## 🤝 Contribuer

Les contributions sont les bienvenues ! Consultez le [Guide de contribution](CONTRIBUTING.md) pour les détails.

```bash
# Fork → Clone → Branch → Commit → Push → Pull Request
git checkout -b feature/ma-feature
git commit -m "feat(api): ajout d'un nouvel endpoint"
git push origin feature/ma-feature
```

---

## 📝 Licence

Ce projet est sous licence **MIT**. Voir le fichier [LICENSE](LICENSE) pour plus de détails.

---

## 👨‍💻 Auteur

<div align="center">

**Baye Cheikh**

[![GitHub](https://img.shields.io/badge/GitHub-@Bayecheikh12-181717?style=flat&logo=github)](https://github.com/Bayecheikh12)

</div>

---

<div align="center">
  <sub>Built with ❤️ using Spring Boot</sub>
</div>
