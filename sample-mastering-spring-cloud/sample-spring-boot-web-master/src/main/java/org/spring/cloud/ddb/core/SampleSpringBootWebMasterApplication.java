package org.spring.cloud.ddb.core;

import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrador
 */
@EnableSwagger2
@SpringBootApplication
public class SampleSpringBootWebMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringBootWebMasterApplication.class, args);
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws XmlPullParserException
	 */
	@Bean
	public Docket apiDoc() throws IOException, XmlPullParserException {

		MavenXpp3Reader reader = new MavenXpp3Reader();

		Model model = reader.read(new FileReader("pom.xml"));

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.spring.cloud.ddb.core.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().title("Person Microservice Api Documentation")
				.description("Documentation automatically generated")
					.version(model.getVersion())
				.contact(new Contact("DouglasdDb", "", "abraham.dias.douglas@gmail.com"))
				.build());

	}
	

	/**
	 * 
	 * @return
	 */
	@Bean
	public UiConfiguration uiConfig() {
		return new UiConfiguration("validatorUrl", "list", "alpha", "schema",
				UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
	}

}
