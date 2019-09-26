FROM openjdk:11
MAINTAINER danhull@gmail.com
VOLUME /tmp
ADD planets-0.0.1-SNAPSHOT.jar planets.jar
ENTRYPOINT ["java", "-jar", "/planets.jar"]
#CMD ["-jar", "/opt/spring-cloud/lib/planets.jar"]
EXPOSE 8888