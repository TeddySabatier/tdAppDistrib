package org.tse.kabanboard.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Task {
	public @Id @GeneratedValue Long  id;
	private String title;
	private Integer nbHoursForecast;
	private Integer nbHoursReal;
	private LocalDate created;
	@ManyToOne
	private TaskType Type;
	@ManyToOne
	private TaskStatus status;
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Developer>developers;
}
