echo "compiling proyect"
./mvnw install -Ppre
echo "init docker-compose images"
docker-compose up -d simulado influxdb grafana
echo "init spring application"
./mvnw -pl org.backendDevTest:app-products spring-boot:run
