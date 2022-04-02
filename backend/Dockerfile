#Imagen base 
FROM maven:3.6.3-openjdk-11 as builder
#Directorio de trabajo
WORKDIR /project
#Copiamos el código
COPY pom.xml /project/
RUN mvn clean verify
COPY /src /project/src
#Mandamos compilar el proyecto
RUN mvn package -DskipTests=true

#-----------------------------------------------------------------

#Imagen base
FROM openjdk:11-jre-slim
#Directorio de trabajo
WORKDIR /usr/src/app/
#Copiamos el .jar 
COPY --from=builder /project/target/*.jar /usr/src/app/
#Indicamos el puerto expuesto
EXPOSE 8443
#Comando que se debe ejecutar
CMD [ "java", "-jar", "flyventas-spring-0.0.1-SNAPSHOT.jar" ]
