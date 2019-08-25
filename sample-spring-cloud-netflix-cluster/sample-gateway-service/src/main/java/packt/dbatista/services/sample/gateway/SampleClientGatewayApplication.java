package packt.dbatista.services.sample.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 
 * @author Administrator
 *
 */
@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class SampleClientGatewayApplication {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * 
		 */
		SpringApplication.run(SampleClientGatewayApplication.class, args);
	}

}
