FROM openjdk:11
WORKDIR /app
EXPOSE 5000:5000
COPY ./app-products/target/app-products/app-products-1.0-SNAPSHOT.jar ./app-products/
ENTRYPOINT ["java", "-jar", "app-products/app-products-1.0-SNAPSHOT.jar"]