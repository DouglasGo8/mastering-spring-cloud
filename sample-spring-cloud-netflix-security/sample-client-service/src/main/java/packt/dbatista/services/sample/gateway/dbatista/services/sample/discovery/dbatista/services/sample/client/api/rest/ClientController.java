package packt.dbatista.services.sample.gateway.dbatista.services.sample.discovery.dbatista.services.sample.client.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dbatista
 */
@RestController
public class ClientController {

    @GetMapping("/ping")
    public String ping() {
        return "I'm alive";
    }
}
