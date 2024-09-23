FROM openjdk:17
COPY "./target/DonaAnita-1.jar" "app.jar"
EXPOSE 8040
ENTRYPOINT [ "java", "-jar", "app.jar" ]

