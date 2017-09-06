package com.testing.music.domain;

import java.util.Calendar;
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
 * Данная сущность представляет альбом или сборник, к которому может относиться
 * конкретный трек <code>Track</code>. Если альбом в треке не указан (
 * <code>null</code>), то трек считается "синглом". Если у объекта
 * <code>Album</code> не указан исполнитель (<code>singer</code>), то это
 * сборник.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "singer_id", nullable = true)
	private Singer singer;

	@JsonIgnore
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
	private Set<Track> tracks;

	private Calendar releaseDate;

	public Album() {
	}

	public Album(int id, String name, Singer singer, Calendar releaseDate) {
		super();
		this.id = id;
		this.name = name;
		this.singer = singer;
		this.releaseDate = releaseDate;
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

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	public Calendar getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
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
				"Album [id=%d, name=%s, singer=%s, releaseDate=%s]", id, name,
				singer, releaseDate);
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

		Album otherAlbum = (Album) other;
		return id == otherAlbum.id;
	}

}
