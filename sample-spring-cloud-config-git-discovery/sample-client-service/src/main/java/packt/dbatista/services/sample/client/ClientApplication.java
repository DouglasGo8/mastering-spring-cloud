package packt.dbatista.services.sample.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {


    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);


    public static void main(String[] args) {

        SpringApplication.run(ClientApplication.class, args);


    }


    @RestController
    public class ClientController {


        @Autowired
        private DiscoveryClient discoveryClient;

        @GetMapping("/ping")
        public List<ServiceInstance> ping() {
            List<ServiceInstance> instances = discoveryClient.getInstances("CLIENT-SERVICE");
            LOGGER.info("INSTANCES: count={}", instances.size());
            instances.forEach(it -> LOGGER.info("INSTANCE: id={}, port={}", it.getServiceId(), it.getPort()));
            return instances;
        }

    }
}
