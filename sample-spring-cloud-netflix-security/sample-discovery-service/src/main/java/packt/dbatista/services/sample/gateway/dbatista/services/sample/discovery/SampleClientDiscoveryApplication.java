package packt.dbatista.services.sample.gateway.dbatista.services.sample.discovery;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author dbatista
 */
@EnableEurekaServer
@SpringBootApplication
public class SampleClientDiscoveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleClientDiscoveryApplication.class, args);
    }
}
