FROM openjdk:latest
WORKDIR /work
COPY mvnw /work/mvnw
COPY .mvn /work/.mvn
COPY pom.xml /work/pom.xml
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline
COPY . /work/
RUN chmod +x mvnw
RUN ./mvnw install
RUN chmod +x /work/target/payrollService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/work/target/payrollService-0.0.1-SNAPSHOT.jar"]
EXPOSE 8001
