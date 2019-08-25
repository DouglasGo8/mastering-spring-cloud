# Docker
docker run --name mongodb -d -p 27017:27017 -v /opt/mongodb:/data/db mongodb

# Chapter 04 -- cluster
mvn spring-boot:run -Dspring.profiles.active=zone2 -Drun.jvmArguments="-Dspring.profiles.active=peer[2]" -Drun.jvmArguments="-Xmx196m"
mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=zone[2]" -Drun.jvmArguments="-Dspring.profiles.active=peer[2]" -Drun.jvmArguments="-Xmx196m"
java -jar -Dspring.profiles.active=peer[2] -Dspring.profiles.active=zone[2] 

# Git