package packt.dbatista.services.sample.client.api.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Administrator
 *
 */
@RestController
public class ClientRestResource {

	/**
	 * 
	 */
	@Value("${spring.profiles}")
	private String zone;

	/**
	 * 
	 * @return
	 */
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
		return ResponseEntity.<String>ok("Hi, I'm in zone " + zone);
	}

}
