FROM anapsix/alpine-java:base
MAINTAINER danhull@gmail.com
COPY planets-0.0.1-SNAPSHOT.jar /opt/spring-cloud/lib/planets.jar
COPY entrypoint.sh /opt/spring-cloud/bin/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/spring-cloud/lib/planets.jar"]
VOLUME /var/lib/spring-cloud/config-repo
EXPOSE 8888