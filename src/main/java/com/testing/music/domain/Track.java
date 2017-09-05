package com.testing.music.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Трек <code>Track</code> является результатом исполнения(выпуска) некоторой
 * композиции каким либо солистом, группой или комбинацией солистов и/или групп.
 * Трек может быть выпущен "синглом" (<code>album == null</code>) или относиться
 * к какому либо альбому или сборнику (но только к одному).
 *
 * @author antonch
 * @since 02.09.2017
 */
@Entity
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "composition_id", nullable = false, updatable = false)
	private Composition composition;

	private Calendar songDate;

	@ManyToOne
	@JoinColumn(name = "album_id", nullable = true, updatable = false)
	private Album album;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "track_singer", joinColumns = @JoinColumn(name = "track_id", nullable = false, updatable = false), inverseJoinColumns = @JoinColumn(name = "singer_id", nullable = false, updatable = false))
	private List<Singer> singers;

	public Track() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Composition getComposition() {
		return composition;
	}

	public void setComposition(Composition composition) {
		this.composition = composition;
	}

	public Calendar getSongDate() {
		return songDate;
	}

	public void setSongDate(Calendar songDate) {
		this.songDate = songDate;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public List<Singer> getSingers() {
		return singers;
	}

	public void setSingers(List<Singer> singers) {
		this.singers = singers;
	}

	@Override
	public String toString() {
		return String
				.format("Track [id=%d, composition=%s, songDate=%s, album=%s, singers=%s]",
						id, composition, songDate, album, singers);
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

		Track otherTrack = (Track) other;
		return id == otherTrack.id;
	}

}