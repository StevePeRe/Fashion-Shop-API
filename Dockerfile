FROM maven:3.9.6-eclipse-temurin-21

# se crea directorio de trabajo
WORKDIR /spring
# se copia el proyecto de un punto A al B
COPY . .
# comando por linea de comandos
RUN mvn clean install
# se ejecuta el proyecto
CMD mvn spring-boot:run