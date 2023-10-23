# Используем базовый образ с Java 17
FROM openjdk:17

# Устанавливаем переменную окружения для Spring Boot
ENV SPRING_PROFILES_ACTIVE=production

# Создаем директорию приложения
RUN mkdir /app

# Копируем JAR-файл приложения в директорию /app
COPY build/libs/twitter-0.0.1-SNAPSHOT.jar /app/app.jar

# Рабочая директория
WORKDIR /app

# Определение порта, который будет прослушивать Spring Boot
EXPOSE 8080

# Запускаем приложение
CMD ["java", "-jar", "app.jar"]
