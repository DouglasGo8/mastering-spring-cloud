package org.spring.cloud.ddb.core;

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
public class SampleSpringBootWebDiscoveryApplication {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SampleSpringBootWebDiscoveryApplication.class, args);
	}

}

