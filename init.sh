#! /bin/bash

if [ -d "app-products/target" ]
then
    echo "delete target directory"
    rm -r "./app-products/target/"
fi
echo "building target"
./mvnw install -Ppro
echo "build docker"
docker build -t "app-products" .
echo "clean docker-compose"
docker-compose stop appproducts
docker-compose rm -f appproducts
docker-comppose pull appproducts

echo "start docker-compose images"
docker-compose up -d simulado influxdb grafana appproducts
echo "Spring app expose in :5000"