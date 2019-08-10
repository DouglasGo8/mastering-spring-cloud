package packt.dbatista.services.sample.gateway.dbatista.services.sample.discovery.dbatista.services.sample.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dbatista
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SampleClientServiceApplication {

    /**
     * @param args parameter
     */
    public static void main(String[] args) {
        SpringApplication.run(SampleClientServiceApplication.class, args);
    }

}
