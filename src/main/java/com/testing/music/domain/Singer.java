package com.testing.music.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.testing.music.common.SingerType;

@Entity
public class Singer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = true)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private SingerType singerType;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "track_singer", joinColumns = @JoinColumn(name = "singer_id", nullable = false, updatable = false), inverseJoinColumns = @JoinColumn(name = "track_id", nullable = false, updatable = false))
	private List<Track> tracks;

	public Singer() {
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

	public SingerType getSingerType() {
		return singerType;
	}

	public void setSingerType(SingerType singerType) {
		this.singerType = singerType;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Singer [id=" + id + ", name=" + name + ", singerType=" + singerType + "]";
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

		Singer otherSigner = (Singer) other;
		return id == otherSigner.id;
	}

}
