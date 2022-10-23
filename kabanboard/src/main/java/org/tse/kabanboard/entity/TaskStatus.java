package org.tse.kabanboard.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskStatus {
	private @Id Long id;
	public TaskStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String label;
	public TaskStatus(Long tASK_STATUS_ID, String tASK_STATUS_LABEL) {
		id=tASK_STATUS_ID;
		label=tASK_STATUS_LABEL;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
