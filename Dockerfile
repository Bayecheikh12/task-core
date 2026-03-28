# =============================================
# Task Core - Docker Multi-Stage Build
# =============================================

# --- Stage 1: Build ---
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copier les fichiers Maven
COPY pom.xml .
COPY .mvn/ .mvn/
COPY mvnw .
RUN chmod +x mvnw

# Télécharger les dépendances (cache Docker)
RUN ./mvnw dependency:go-offline -B

# Copier le code source et compiler
COPY src/ src/
RUN ./mvnw clean package -DskipTests -B

# --- Stage 2: Runtime ---
FROM eclipse-temurin:17-jre-alpine AS runtime

# Créer un utilisateur non-root pour la sécurité
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /app

# Copier le JAR compilé
COPY --from=build /app/target/*.jar app.jar

# Changer de propriétaire
RUN chown -R appuser:appgroup /app
USER appuser

# Exposer le port
EXPOSE 8085

# Health check
HEALTHCHECK --interval=30s --timeout=10s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8085/api/tasks || exit 1

# Démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
