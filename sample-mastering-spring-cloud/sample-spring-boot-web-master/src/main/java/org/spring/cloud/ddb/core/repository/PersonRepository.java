package org.spring.cloud.ddb.core.repository;

import java.util.concurrent.CompletableFuture;

import org.spring.cloud.ddb.core.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 
 * @author Administrador
 *
 */
public interface PersonRepository extends MongoRepository<Person, Long> {

	CompletableFuture<Page<Person>> findAllBy(final Pageable pageable);

}
