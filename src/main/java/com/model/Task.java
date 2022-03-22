package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "task", schema = "public")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
		@NamedQuery(name = "Task.findByForm", query = "SELECT t FROM Task t WHERE "
				+ "((:title is null or t.title = :title) or (:id is null or t.id = :id))"
				+ "and (t.status = :status)"			
				),
		@NamedQuery(name = "Task.findById", query = "SELECT t FROM Task t where (t.id = :id)")
})
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "seq", sequenceName = "task_sequence", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "id")
	Long id;
	@Column(name = "title")
	String title;
	@Column(name = "description")
	String description;
	@OneToOne
	@JoinColumn(name = "responsible")
	Profile responsible;
	@Column(name = "priority")
	String priority;
	@Column(name = "status")
	Boolean status;
	@Column(name = "deadline")
	String dealine;

	public Task() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Profile getResponsible() {
		return responsible;
	}

	public void setResponsible(Profile responsible) {
		this.responsible = responsible;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getDealine() {
		return dealine;
	}

	public void setDealine(String dealine) {
		this.dealine = dealine;
	}
}
