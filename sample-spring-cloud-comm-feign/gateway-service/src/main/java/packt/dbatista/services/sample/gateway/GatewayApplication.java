package packt.dbatista.services.sample.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import packt.dbatista.services.sample.gateway.fallback.AccountFallbackProvider;
import packt.dbatista.services.sample.gateway.filter.AddResponseIDHeaderFilter;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }


    @Bean
    public AddResponseIDHeaderFilter filter() {
        return new AddResponseIDHeaderFilter();
    }

    @Bean
    public AccountFallbackProvider fallback() {
        return new AccountFallbackProvider();
    }

    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }
}
