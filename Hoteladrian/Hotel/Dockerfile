# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/Hotel-0.0.1-SNAPSHOT.jar /app/hotel.jar

# Exponer el puerto que usará la aplicación
EXPOSE 8002

# Ejecutar el archivo JAR cuando el contenedor arranque
ENTRYPOINT ["java", "-jar", "hotel.jar"]
