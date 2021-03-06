FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=KlepininTestBot
ENV BOT_TOKEN=1498375289:AAHyz4JiRebFRTB4rvmePF4p6cyL9AW1s9I
ENV BOT_DB_USERNAME=tntb_db_user
ENV BOT_DB_PASSWORD=tntb_db_password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar", "app.jar"]