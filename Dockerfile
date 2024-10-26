FROM openjdk:17-jdk-slim

LABEL authors="bezina"

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл jar вашего приложения в контейнер
COPY target/my-spring-app-0.0.1-SNAPSHOT.jar app.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]