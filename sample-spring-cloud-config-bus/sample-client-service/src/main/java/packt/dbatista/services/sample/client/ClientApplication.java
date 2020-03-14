package packt.dbatista.services.sample.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @RestController
    public class ClientController {

        private final ClientConfiguration conf;

        public ClientController(ClientConfiguration conf) {
            this.conf = conf;
        }

        @GetMapping("/ping")
        public String ping() {
            return conf.showProperties();
        }

    }


    @Component
    @RefreshScope
    public class ClientConfiguration {

        @Value("${sample.string.property}")
        private String sampleStringProperty;
        @Value("${sample.int.property}")
        private int sampleIntProperty;

        public String showProperties() {
            return String.format("Hello from %s %d", sampleStringProperty, sampleIntProperty);
        }

    }
}
