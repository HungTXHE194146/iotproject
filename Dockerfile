# Sử dụng Java 17 runtime
FROM openjdk:17-jdk-slim

# Tạo thư mục làm việc
WORKDIR /app

# Copy file jar đã build vào container
COPY target/iotProjectNew-0.0.1-SNAPSHOT.jar app.jar

# Mặc định chạy file jar
ENTRYPOINT ["java", "-jar", "app.jar"]
