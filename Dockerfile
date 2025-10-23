# Usa una imagen base oficial de Java 21.
FROM eclipse-temurin:21-jdk-jammy

# Crea un argumento para el nombre del archivo JAR.
ARG JAR_FILE=target/*.jar

# Crea un directorio de trabajo dentro del contenedor.
WORKDIR /app

# Copia el archivo JAR construido desde la carpeta 'target' a la raíz del directorio de trabajo.
COPY ${JAR_FILE} app.jar

# Expone el puerto 8080 (el puerto por defecto de Spring Boot) para que Render pueda acceder a él.
EXPOSE 8080

# El comando que se ejecutará cuando el contenedor se inicie.
ENTRYPOINT ["java", "-jar", "app.jar"]