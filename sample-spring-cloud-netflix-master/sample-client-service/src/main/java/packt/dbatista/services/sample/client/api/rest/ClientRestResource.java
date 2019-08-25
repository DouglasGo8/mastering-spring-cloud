package packt.dbatista.services.sample.client.api.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;

/**
 * 
 * @author Administrator
 *
 */
@RestController
@NoArgsConstructor
public class ClientRestResource {

	private static Logger LOGGER = LoggerFactory.getLogger(ClientRestResource.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	/**
	 * 
	 * @return
	 */
	@GetMapping("/ping")
	public ResponseEntity<List<ServiceInstance>> ping() {

		final List<ServiceInstance> instances = discoveryClient.getInstances("CLIENT-SERVICE");

		LOGGER.info("INSTANCES: count={}", instances.size());
		instances.parallelStream().forEach(ServiceInstanceInfo::new);

		return ResponseEntity.<List<ServiceInstance>>ok(instances);
	}

	/**
	 * 
	 * @author Administrator
	 *
	 */
	final class ServiceInstanceInfo {

		public ServiceInstanceInfo(ServiceInstance it) {
			// TODO Auto-generated constructor stub
			LOGGER.info("INSTANCE: id={}, port={}", it.getServiceId(), it.getPort());
		}
	}
}
