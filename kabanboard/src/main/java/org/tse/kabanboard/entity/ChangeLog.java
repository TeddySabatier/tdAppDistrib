package org.tse.kabanboard.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ChangeLog {

	private @Id @GeneratedValue Long id;	
	private LocalDateTime timeOfHappen;	
	@ManyToOne	
	private Task task;	
	@ManyToOne
	private TaskStatus targetStatus;	
	@ManyToOne
	private TaskStatus sourceStatus;
}
