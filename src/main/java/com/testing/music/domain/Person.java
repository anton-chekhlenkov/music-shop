package com.testing.music.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Объект <code>Person</code> отражает человека, который может выступать по
 * отношению к другим сущностям как композитор, автор текста, сольный певец или
 * участник группы.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true)
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
	private Set<Composition> writedCompositions;

	@JsonIgnore
	@OneToMany(mappedBy = "composer", cascade = CascadeType.ALL)
	private Set<Composition> composedCompositions;

	public Person() {
	}

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Person [id=%d, name=%s]", id, name);
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null || getClass() != other.getClass())
			return false;

		Person otherPerson = (Person) other;
		return id == otherPerson.id;
	}

}
