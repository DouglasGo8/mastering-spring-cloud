#  sample-client-service
https://github.com/PacktPublishing/Mastering-Spring-Cloud

# Refs
mvn spring-boot:run -D"spring.profiles.active"=zone1

# Zuul API Invoke
http://localhost:8765/api/client/ping


docker run --rm --cap-add=IPC_LOCK -d --name vault -e 'VAULT_DEV_ROOT_TOKEN_ID=client' -p 8200:8200 vault:latest