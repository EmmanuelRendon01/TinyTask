# --- Etapa 1: Compilación (Builder) ---
# Usamos una imagen que contiene Maven y el JDK para compilar el proyecto.
FROM maven:3.9-eclipse-temurin-21 AS builder

# Establecemos el directorio de trabajo dentro del contenedor de compilación.
WORKDIR /build

# Copiamos primero el pom.xml para aprovechar el caché de capas de Docker.
# Si las dependencias no cambian, Docker no las descargará de nuevo.
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el resto del código fuente del proyecto.
COPY src ./src

# Compilamos la aplicación. Esto creará la carpeta /build/target/*.jar
RUN mvn clean package -DskipTests


# --- Etapa 2: Ejecución (Final) ---
# Usamos una imagen ligera que solo contiene el entorno de ejecución de Java (JRE).
FROM eclipse-temurin:21-jre-jammy

# Creamos un argumento para el nombre del archivo JAR.
ARG JAR_FILE=target/*.jar

# Creamos un directorio de trabajo dentro del contenedor final.
WORKDIR /app

# Copiamos ÚNICAMENTE el archivo .jar desde la etapa de compilación 'builder'.
COPY --from=builder /build/${JAR_FILE} app.jar

# Expone el puerto 8080.
EXPOSE 8080

# El comando que se ejecutará cuando el contenedor se inicie.
ENTRYPOINT ["java", "-jar", "app.jar"]
