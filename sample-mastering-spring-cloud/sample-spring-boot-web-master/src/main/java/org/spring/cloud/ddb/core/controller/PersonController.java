package org.spring.cloud.ddb.core.controller;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.cloud.ddb.core.model.Person;
import org.spring.cloud.ddb.core.service.PersonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reactivex.Observable;

/**
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/person/v1")
public class PersonController {

	private final PersonService svc;
	private static final Logger log = LoggerFactory.getLogger(PersonController.class);

	@Value("${spring.profiles}")
	private String zone;

	/**
	 * 
	 */
	public PersonController(PersonService svc) {
		// TODO Auto-generated constructor stub
		this.svc = svc;
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/ping")
	public Observable<String> getReadnessProbe() {

		return Observable.<String>just("I'm in zone ".concat(zone));
			
			//.orElse(Observable.just( ResponseEntity.ok().body(null)));
			
			
	}

	/**
	 * 
	 * @param paging
	 * @return
	 */
	@Async
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CompletableFuture<ResponseEntity<Page<Person>>> getPersonByList(final Pageable paging) {
		return this.svc.getAllPerson(paging)
				.<ResponseEntity<Page<Person>>>thenApply(
						r3sult -> new ResponseEntity<Page<Person>>(r3sult, HttpStatus.OK))
				.exceptionally(handleGetUsersFailure);
	}

	/**
	 * 
	 */

	private Function<Throwable, ResponseEntity<Page<Person>>> handleGetUsersFailure = throwable -> {
		log.error("Unable to retrieve users", throwable);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	};
}
