FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=KlepininTestBot
ENV BOT_TOKEN=1498375289:AAFzu-l63J-_e4tRwhK2d-waLdSR7bO9BlM
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]