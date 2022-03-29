#Imagen base 
FROM maven:3.6.3-openjdk-11 as builder
#Directorio de trabajo
WORKDIR /.project
#Copiamos el pom.xml
COPY pom.xml /backend/

RUN mvn clean verify
#Copiamos el código entero
COPY /src /backend/

RUN mvn package -o

#--------------------

#Imagen base
FROM openjdk:11-jre-slim
#Directorio de trabajo
WORKDIR /usr/src/app/
#
COPY --from=builder /project/target/*.jar /usr/src/app/target/
EXPOSE 8443
CMD [ "java", "-jar", "java-webapp-0.0.1.jar" ]
