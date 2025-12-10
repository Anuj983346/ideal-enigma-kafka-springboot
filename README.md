# Kafka Spring Boot Gradle (Kotlin DSL) Demo

This is a minimal Java + Spring Boot project using **Gradle Kotlin DSL** (`build.gradle.kts`) demonstrating Kafka producer and consumer.

## Requirements (Windows)
- Java 17
- Kafka (local) running on localhost:9092
- Git Bash (optional, recommended)

## Run (using installed Gradle)
1. Start Zookeeper & Kafka (run in separate terminals):
   ```bash
   cmd.exe /c "C:\kafka\bin\windows\zookeeper-server-start.bat C:\kafka\config\zookeeper.properties"
   cmd.exe /c "C:\kafka\bin\windows\kafka-server-start.bat C:\kafka\config\server.properties"
   ```

2. Create topic (optional, the app will also create topic via NewTopic bean):
   ```bash
   cmd.exe /c "C:\kafka\bin\windows\kafka-topics.bat --create --topic orders --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1"
   ```
