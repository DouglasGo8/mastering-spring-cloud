package org.spring.cloud.ddb.core.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Administrator
 *
 */
@Data
@RequiredArgsConstructor
@Document(collection = "person")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1320849587688346668L;

	/**
	 * 
	 */
	private final int age;

	/**
	 * 
	 */
	@Id
	private final String id;
	/**
	 * 
	 */
	private final String firstName;

	/**
	 * 
	 */
	private final Gender gender;

}
