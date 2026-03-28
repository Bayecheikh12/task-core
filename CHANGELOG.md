# Changelog

Toutes les modifications notables de ce projet seront documentées dans ce fichier.

Le format suit [Keep a Changelog](https://keepachangelog.com/fr/1.1.0/),
et ce projet adhère au [Semantic Versioning](https://semver.org/lang/fr/).

## [0.3.0] - 2026-03-28

### Ajouté
- ✨ REST Controller (`TaskController`) avec endpoints CRUD
- 🛡️ Gestion globale des exceptions (`GlobalExceptionHandler`)
- ⚙️ Configuration CORS globale (`CorsConfig`)
- 🐳 Dockerfile multi-stage (JDK build → JRE runtime)
- 🐳 Docker Compose (app + MySQL)
- 🔄 Pipeline CI/CD GitHub Actions (build, test, package, docker)
- 📄 Template Pull Request
- 🔒 Politique de sécurité (`SECURITY.md`)
- 📝 Changelog (`CHANGELOG.md`)
- 🔐 Template `.env.example` pour les variables d'environnement

### Modifié
- 🔐 Suppression du mot de passe en dur dans `application.properties`
- ⚙️ Utilisation de variables d'environnement pour la configuration
- 🔧 Fix du scan des packages Spring Boot (`@ComponentScan`, `@EntityScan`)
- 📖 README.md entièrement refondu avec badges, architecture, et documentation API
- 🚫 `.gitignore` étendu (`.env`, logs, fichiers OS)

### Sécurité
- 🔒 Les credentials de base de données sont désormais gérés via variables d'environnement
- 🔒 L'image Docker utilise un utilisateur non-root

## [0.2.0] - Précédent

### Ajouté
- Modèle `Task` avec JPA
- Enum `TaskStatus` (TODO, IN_PROGRESS, DONE)
- Repository `TaskRepository`
- Service `TaskService`
- Templates d'issues GitHub
- Guide de contribution
- Licence MIT
