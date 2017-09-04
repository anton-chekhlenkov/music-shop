package com.testing.music.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Объект определяет отношения между объектами <code>Singer</code> и
 * <code>Person</code>. Например, если исполнитель <code>Singer</code> является
 * группой, то <code>SingerStructure</code> будет содержать несколько записей со
 * ссылкой на эту группу, в каждой из которых будет указан конкретный её
 * участник <code>Person</code> с датами начала и завершения участия в ней.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Entity
public class SingerStructure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "singer_id", nullable = false)
	private Singer singer;

	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;

	private Calendar dateFrom;

	private Calendar dateTill;

	public SingerStructure() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Calendar getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Calendar dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Calendar getDateTill() {
		return dateTill;
	}

	public void setDateTill(Calendar dateTill) {
		this.dateTill = dateTill;
	}

	@Override
	public String toString() {
		return String
				.format("SingerStructure [id=%d, singer=%s, person=%s, dateFrom=%s, dateTill=%s]",
						id, singer, person, dateFrom, dateTill);
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

		SingerStructure otherSingerStructure = (SingerStructure) other;
		return id == otherSingerStructure.id;
	}

}
