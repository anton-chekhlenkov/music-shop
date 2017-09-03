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
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "track_singer", 
			joinColumns = @JoinColumn(name = "track_id", nullable = false, updatable = false), 
			inverseJoinColumns = @JoinColumn(name = "singer_id", nullable = false, updatable = false))
	private List<Singer> singers;

	protected Track() {
	}

	public Track(Composition composition, Calendar songDate, Album album) {
		this.composition = composition;
		this.songDate = songDate;
		this.album = album;
	}

	public int getId() {
		return id;
	}

	public Composition getComposition() {
		return composition;
	}

	public Calendar getSongDate() {
		return songDate;
	}

	public Album getAlbum() {
		return album;
	}

	public List<Singer> getSingers() {
		return singers;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", composition=" + composition + ", songDate=" + songDate + ", album=" + album + ", singers=" + singers + "]";
	}

}