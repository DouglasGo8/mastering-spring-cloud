package packt.dbatista.services.sample.customer.service.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {


    private Long id;
    private String number;
    private int balance;


    public Account(Long id, String number, int balance) {
        this.id = id;
        this.number = number;
        this.balance = balance;
    }
}
