#  sample-client-service
https://github.com/PacktPublishing/Mastering-Spring-Cloud

# Refs
mvn clean -DskipTests compile spring-boot:run -D"spring.profiles.active"=zone1

# Zuul API Invoke
http://localhost:8765/api/client/ping


docker run --rm --cap-add=IPC_LOCK -d --name vault -e 'VAULT_DEV_ROOT_TOKEN_ID=client' -p 8200:8200 vault:latest
docker run --rm -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management