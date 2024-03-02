mvn clean package -DskipTests

docker build -t bits/order-ms .

#docker run  -p 8082:8082 -e "POSTGRES_URL=192.168.1.5:5432" bits/order-ms



