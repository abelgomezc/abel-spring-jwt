# Usar una imagen base con Java 17
FROM openjdk:21-slim

# Directorio donde se colocará la aplicación en el contenedor
WORKDIR /app

# Copiar el archivo jar del proyecto al directorio /app en el contenedor
COPY target/abel-0.0.1-SNAPSHOT.jar /app/abel.jar

# Exponer el puerto que usa la aplicación
EXPOSE 3000

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app/abel.jar"]