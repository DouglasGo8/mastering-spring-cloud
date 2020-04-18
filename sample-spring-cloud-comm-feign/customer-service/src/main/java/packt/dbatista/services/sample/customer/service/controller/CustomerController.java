package packt.dbatista.services.sample.customer.service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import packt.dbatista.services.sample.customer.service.client.AccountClient;
import packt.dbatista.services.sample.customer.service.domain.Account;
import packt.dbatista.services.sample.customer.service.domain.Customer;
import packt.dbatista.services.sample.customer.service.repository.CustomerRepository;

import java.util.List;

@RestController
public class CustomerController {


    private final ObjectMapper mapper = new ObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private AccountClient accountClient;

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
    public Customer findByIdWithAccounts(@PathVariable("id") Long id) throws JsonProcessingException {
        List<Account> accounts = accountClient.findByCustomer(id);
        LOGGER.info("Accounts found: {}", mapper.writeValueAsString(accounts));
        Customer c = repository.findById(id);
        c.setAccounts(accounts);
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
