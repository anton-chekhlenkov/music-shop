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

import com.testing.music.SingerType;

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
	@JoinTable(
			name = "track_singer", 
			joinColumns = @JoinColumn(name = "singer_id", nullable = false, updatable = false), 
			inverseJoinColumns = @JoinColumn(name = "track_id", nullable = false, updatable = false))
	private List<Track> tracks;

	protected Singer() {
	}

	public Singer(String name, SingerType signerType) {
		this.name = name;
		this.singerType = signerType;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public SingerType getSingerType() {
		return singerType;
	}

	@Override
	public String toString() {
		return "Singer [id=" + id + ", name=" + name + ", singerType=" + singerType + "]";
	}

}
