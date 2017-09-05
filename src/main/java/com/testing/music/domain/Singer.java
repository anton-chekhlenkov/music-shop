package com.testing.music.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.testing.music.common.SingerType;

/**
 * Объект <code>Singer</code> абстрагирует понятие исполнителя трека. Это может
 * быть сольный певец или группа. Тип солист/группа определяется полем
 * <code>singerType</code>. Состав группы на конкретный момент времени
 * определяется сущностью <code>SingerStructure</code>. Для солиста поле
 * <code>name</code> объекта <code>Singer</code> может быть пустым или содержать
 * сценический псевдоним, а <code>SingerStructure</code> должна связывать данный
 * объект только с одним объектом <code>Person</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
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

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "track_singer", joinColumns = @JoinColumn(name = "singer_id", nullable = false, updatable = false), inverseJoinColumns = @JoinColumn(name = "track_id", nullable = false, updatable = false))
	private List<Track> tracks;

	@JsonIgnore
	@OneToMany(mappedBy = "singer", cascade = CascadeType.ALL)
	private Set<SingerStructure> singerStructure;

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

	public Set<SingerStructure> getSingerStructure() {
		return singerStructure;
	}

	public void setSingerStructure(Set<SingerStructure> singerStructure) {
		this.singerStructure = singerStructure;
	}

	@Override
	public String toString() {
		return String.format(
				"Singer [id=%d, name=%s, singerType=%s, tracks=%s]", id, name,
				singerType, tracks);
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

		Singer otherSinger = (Singer) other;
		return id == otherSinger.id;
	}

}
