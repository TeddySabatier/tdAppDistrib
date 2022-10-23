package org.tse.kabanboard.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskType {
	public TaskType() {
		super();
		// TODO Auto-generated constructor stub
	}
	private @Id Long id;
	private String label;
	public TaskType(Long tASK_TYPE_ID, String tASK_TYPE_LABEL) {
		id=tASK_TYPE_ID;
		label=tASK_TYPE_LABEL;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, label);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskType other = (TaskType) obj;
		return Objects.equals(id, other.id) && Objects.equals(label, other.label);
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
