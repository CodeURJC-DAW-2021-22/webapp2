


#Imagen base 
FROM maven:3.6.3-openjdk-11 as builder
#Directorio de trabajo
WORKDIR /project
#Copiamos el código
COPY pom.xml /project/

#Mandamos compilar el proyecto
RUN mvn clean verify --fail-never

COPY src/main/resources /project/src/main/resources
COPY src/main/java /project/src/main/java

RUN mvn package -o -DskipTests=true

#-----------------------------------------------------------------

#Imagen base
FROM openjdk:11-jre-slim
#Directorio de trabajo
WORKDIR /usr/src/app/
#Copiamos el .jar 
COPY --from=builder /project/target/*.jar /usr/src/app/
#Indicamos el puerto expuesto
EXPOSE 8080
#Comando que se debe ejecutar
CMD [ "java", "-jar", "flyventas-spring-0.0.1-SNAPSHOT.jar" ]

