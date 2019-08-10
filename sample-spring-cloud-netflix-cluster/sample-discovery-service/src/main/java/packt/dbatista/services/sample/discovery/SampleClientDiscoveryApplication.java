package packt.dbatista.services.sample.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author Administrator
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class SampleClientDiscoveryApplication {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 
		 */
		SpringApplication.run(SampleClientDiscoveryApplication.class, args);
	}

}
