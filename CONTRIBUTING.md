# Contributing to Task Core

Thank you for your interest in contributing to Task Core! This document provides guidelines and information for contributors.

## 🤝 How to Contribute

### Reporting Bugs

1. Search existing issues to avoid duplicates
2. Use the bug report template when creating a new issue
3. Provide detailed information about the bug
4. Include steps to reproduce the issue
5. Add screenshots if applicable

### Suggesting Features

1. Search existing issues to avoid duplicates
2. Use the feature request template when creating a new issue
3. Provide a clear and detailed description of the feature
4. Explain why this feature would be useful

### Making Changes

1. Fork the repository
2. Create a feature branch from the main branch
3. Make your changes following the coding standards
4. Test your changes thoroughly
5. Submit a pull request

## 🛠️ Development Setup

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Git

### Setup Steps

1. Clone your forked repository:
```bash
git clone https://github.com/YOUR_USERNAME/task-core.git
cd task-core
```

2. Add the original repository as upstream:
```bash
git remote add upstream https://github.com/Bayecheikh12/task-core.git
```

3. Create a new branch for your feature:
```bash
git checkout -b feature/your-feature-name
```

4. Set up your database configuration in `application.properties`

5. Build and run the application:
```bash
mvn clean install
mvn spring-boot:run
```

## 📝 Coding Standards

### Code Style

- Follow Java naming conventions
- Use meaningful variable and method names
- Keep methods small and focused
- Add comments for complex logic
- Use proper indentation (4 spaces)

### Git Commit Messages

Use the following format for commit messages:
```
type(scope): description

[optional body]

[optional footer]
```

Types:
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting, etc.)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Maintenance tasks

Examples:
```
feat(api): add task creation endpoint
fix(database): resolve null pointer exception in task repository
docs(readme): update installation instructions
```

## 🧪 Testing

- Write unit tests for new functionality
- Ensure all tests pass before submitting a pull request
- Use descriptive test names
- Test both positive and negative scenarios

## 📋 Pull Request Process

1. Update the README.md with details of your changes if applicable
2. Ensure your PR description clearly describes your changes
3. Link any relevant issues in your PR description
4. Wait for code review and address any feedback
5. Once approved, your PR will be merged

## 📧 Getting Help

If you need help with contributing:

- Create an issue with the "question" label
- Start a discussion in the repository
- Contact the maintainers

## 📄 License

By contributing to this project, you agree that your contributions will be licensed under the MIT License.

## 🙏 Code of Conduct

Please be respectful and professional in all interactions. Follow these guidelines:

- Be welcoming to newcomers
- Be constructive in feedback
- Focus on what is best for the community
- Show empathy towards other community members

Thank you for contributing to Task Core! 🎉
