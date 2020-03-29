
package packt.dbatista.services.sample.customer.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import packt.dbatista.services.sample.customer.service.model.Customer;
import packt.dbatista.services.sample.customer.service.model.CustomerType;
import packt.dbatista.services.sample.customer.service.repo.CustomerRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CustomerRepository repository() {
        CustomerRepository repository = new CustomerRepository();
        repository.add(new Customer("John Scott", CustomerType.NEW));
        repository.add(new Customer("Adam Smith", CustomerType.REGULAR));
        repository.add(new Customer("Jacob Ryan", CustomerType.VIP));
        return repository;
    }

}
