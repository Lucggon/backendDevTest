#! /bin/bash

if [ -d "app-products/target" ]
then
    echo "delete target directory"
    rm -r "./app-products/target/"
fi
echo "building target"
./mvnw install
echo "build docker"
docker build -t "app-products" .
echo "docker run"
docker run --rm  -p 5000:5000 app-products
echo "Spring app expose in :5000"