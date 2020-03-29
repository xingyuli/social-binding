FROM adoptopenjdk/openjdk13-openj9:jdk-13.0.2_8_openj9-0.18.0-alpine-slim
RUN mkdir /opt/app
COPY build/libs/social-binding-*-all.jar /opt/app/app.jar
COPY startup-docker.sh /opt/app
EXPOSE 8080
CMD ["/bin/sh", "/opt/app/startup-docker.sh"]
