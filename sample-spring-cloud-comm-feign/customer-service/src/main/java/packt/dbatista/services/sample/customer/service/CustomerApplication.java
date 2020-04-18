package packt.dbatista.services.sample.customer.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import packt.dbatista.services.sample.customer.service.domain.Customer;
import packt.dbatista.services.sample.customer.service.domain.CustomerType;
import packt.dbatista.services.sample.customer.service.repository.CustomerRepository;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludePayload(true);
        loggingFilter.setIncludeHeaders(true);
        loggingFilter.setMaxPayloadLength(1000);
        loggingFilter.setAfterMessagePrefix("REQ:");
        return loggingFilter;
    }

    @Bean
    public CustomerRepository repository() {
        CustomerRepository repository = new CustomerRepository();
        repository.add(new Customer("John Scott", CustomerType.NEW));
        repository.add(new Customer("Adam Smith", CustomerType.REGULAR));
        repository.add(new Customer("Jacob Ryan", CustomerType.VIP));
        return repository;
    }

    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }


}
