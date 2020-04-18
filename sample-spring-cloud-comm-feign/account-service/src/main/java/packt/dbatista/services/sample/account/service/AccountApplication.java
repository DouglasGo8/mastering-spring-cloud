package packt.dbatista.services.sample.account.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import packt.dbatista.services.sample.account.service.domain.Account;
import packt.dbatista.services.sample.account.service.repository.AccountRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AccountRepository repository() {
        AccountRepository repository = new AccountRepository();
        repository.add(new Account("1234567890", 50000, 1L));
        repository.add(new Account("1234567891", 50000, 1L));
        repository.add(new Account("1234567892", 0, 1L));
        repository.add(new Account("1234567893", 50000, 2L));
        repository.add(new Account("1234567894", 0, 2L));
        repository.add(new Account("1234567895", 50000, 2L));
        repository.add(new Account("1234567896", 0, 3L));
        repository.add(new Account("1234567897", 50000, 3L));
        repository.add(new Account("1234567898", 50000, 3L));
        return repository;
    }

    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }
}
