## Prerequisites
1- JDK 11

2- Maven

3- Docker

## How To Run:
1- Go to ./greeting path

2- run  the following commands
- mvn install
- docker build -t "greeting" . 
- docker run --publish 5000:5000 --name greeting  "greeting" 

## Sample Requests
http://localhost:5000/greeting?account=personal&id=123

http://localhost:5000/greeting?account=business&type=big

http://localhost:5000/greeting?account=business&type=small
