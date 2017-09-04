package com.testing.music.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Composition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "writer_id", nullable = false)
	private Person writer;
	
	@ManyToOne
	@JoinColumn(name = "composer_id", nullable = false)
	private Person composer;

	protected Composition() {
	}

	public Composition(String name, Person writer, Person composer) {
		this.name = name;
		this.writer = writer;
		this.composer = composer;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Person getWriter() {
		return writer;
	}

	public Person getComposer() {
		return composer;
	}

	@Override
	public String toString() {
		return "Composition [id=" + id + ", name=" + name + ", writer=" + writer + ", composer=" + composer + "]";
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Composition otherComposition = (Composition) other;
        return id == otherComposition.id;
	}

}
