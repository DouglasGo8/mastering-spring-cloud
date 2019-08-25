package org.spring.cloud.ddb.core.service;

import java.util.concurrent.CompletableFuture;

import org.spring.cloud.ddb.core.model.Person;
import org.spring.cloud.ddb.core.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	private PersonRepository repo;

	public PersonService(PersonRepository repo) {
		// TODO Auto-generated constructor stub
		this.repo = repo;
	}

	/**
	 *
	 * 
	 * @return
	 */
	public CompletableFuture<Page<Person>> getAllPerson(final Pageable pageable) {
		return repo.findAllBy(pageable);
	}
}
