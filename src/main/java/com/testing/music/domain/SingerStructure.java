package com.testing.music.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	protected SingerStructure() {
	}

	public SingerStructure(Singer singer, Person person, Calendar dateFrom, Calendar dateTill) {
		this.singer = singer;
		this.person = person;
		this.dateFrom = dateFrom;
		this.dateTill = dateTill;
	}

	public int getId() {
		return id;
	}

	public Singer getSinger() {
		return singer;
	}

	public Person getPerson() {
		return person;
	}

	public Calendar getDateFrom() {
		return dateFrom;
	}

	public Calendar getDateTill() {
		return dateTill;
	}

	@Override
	public String toString() {
		return "SingerStructure [id=" + id + ", singer=" + singer + ", person=" + person + ", dateFrom=" + dateFrom + ", dateTill=" + dateTill + "]";
	}

}
