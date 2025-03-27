# 1. Base image có Maven + JDK
FROM maven:3.8.5-openjdk-17-slim AS build

# 2. Sao chép toàn bộ source code vào image
COPY . /app
WORKDIR /app

# 3. Build jar
RUN mvn clean package -DskipTests

# 4. Tạo image chạy app từ JDK nhẹ
FROM openjdk:17-jdk-slim
WORKDIR /app

# 5. Copy jar đã build ở bước trên
COPY --from=build /app/target/*.jar app.jar

# 6. Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
