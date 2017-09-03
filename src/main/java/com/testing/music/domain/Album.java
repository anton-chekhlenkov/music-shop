package com.testing.music.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "singer_id", nullable = true)
	private Singer singer;
	private Calendar releaseDate;

	protected Album() {
	}

	public Album(String name, Singer singer, Calendar releaseDate) {
		this.name = name;
		this.singer = singer;
		this.releaseDate = releaseDate;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Singer getSinger() {
		return singer;
	}

	public Calendar getReleaseDate() {
		return releaseDate;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", singer=" + singer + ", releaseDate=" + releaseDate + "]";
	}

}
