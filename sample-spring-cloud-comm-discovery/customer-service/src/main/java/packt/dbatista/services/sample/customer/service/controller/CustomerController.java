package packt.dbatista.services.sample.customer.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import packt.dbatista.services.sample.customer.service.model.Account;
import packt.dbatista.services.sample.customer.service.model.Customer;
import packt.dbatista.services.sample.customer.service.repo.CustomerRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    @Autowired
    private RestTemplate template;
    @Autowired
    private CustomerRepository repository;

    @PostMapping
    public Customer add(@RequestBody Customer customer) {
        return repository.add(customer);
    }

    @PutMapping
    public Customer update(@RequestBody Customer customer) {
        return repository.update(customer);
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    @GetMapping("/withAccounts/{id}")
    public Customer findByIdWithAccounts(@PathVariable("id") Long id) {
        Account[] accounts = template.getForObject("http://account-service/customer/{customerId}", Account[].class, id);
        Customer c = repository.findById(id);
        c.setAccounts(Arrays.stream(accounts).collect(Collectors.toList()));
        return c;
    }

    @PostMapping("/ids")
    public List<Customer> find(@RequestBody List<Long> ids) {
        return repository.find(ids);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.delete(id);
    }

}
