package packt.dbatista.services.sample.customer.service.client;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import packt.dbatista.services.sample.customer.service.domain.Account;

import java.util.List;

@FeignClient("account-service")
public interface AccountClient {
    @GetMapping("/customer/{customerId}")
    List<Account> findByCustomer(@PathVariable("customerId") Long customerId);
}
