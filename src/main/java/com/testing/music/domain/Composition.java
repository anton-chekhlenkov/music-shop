package com.testing.music.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Композиция представляет собой своего рода комбинацию нот и текста песни,
 * созданных композитором и автором текста соответственно. Результатом
 * исполнения композиции является трек (<code>Track</code>). Композиция может
 * быть исполнена сколько угодно раз, т.е. одному объекту
 * <code>Composition</code> может соответствовать множество объектов
 * <code>Track</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
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

	@JsonIgnore
	@OneToMany(mappedBy = "composition", cascade = CascadeType.ALL)
	private Set<Track> tracks;

	public Composition() {
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

	public Person getWriter() {
		return writer;
	}

	public void setWriter(Person writer) {
		this.writer = writer;
	}

	public Person getComposer() {
		return composer;
	}

	public void setComposer(Person composer) {
		this.composer = composer;
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return String.format(
				"Composition [id=%d, name=%s, writer=%s, composer=%s]", id,
				name, writer, composer);
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

		Composition otherComposition = (Composition) other;
		return id == otherComposition.id;
	}

}
