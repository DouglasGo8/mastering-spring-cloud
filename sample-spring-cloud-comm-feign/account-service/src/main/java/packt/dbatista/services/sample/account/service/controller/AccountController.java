package packt.dbatista.services.sample.account.service.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import packt.dbatista.services.sample.account.service.domain.Account;
import packt.dbatista.services.sample.account.service.repository.AccountRepository;

import java.util.Collections;
import java.util.List;

@RestController
public class AccountController {

    private final ObjectMapper mapper = new ObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountRepository repository;

    @PostMapping
    public Account add(@RequestBody Account account) {
        return repository.add(account);
    }

    @PutMapping
    public Account update(@RequestBody Account account) {
        return repository.update(account);
    }

    @PutMapping("/withdraw/{id}/{amount}")
    public Account withdraw(@PathVariable("id") Long id, @PathVariable("amount") int amount) throws JsonProcessingException {
        Account account = repository.findById(id);
        LOGGER.info("Account found: {}", mapper.writeValueAsString(account));
        account.setBalance(account.getBalance() - amount);
        LOGGER.info("Current balance: {}", mapper.writeValueAsString(Collections.singletonMap("balance", account.getBalance())));
        return repository.update(account);
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Account> findByCustomerId(@PathVariable("customerId") Long customerId) {
        return repository.findByCustomer(customerId);
    }

    @PostMapping("/ids")
    public List<Account> find(@RequestBody List<Long> ids) {
        return repository.find(ids);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.delete(id);
    }

}
