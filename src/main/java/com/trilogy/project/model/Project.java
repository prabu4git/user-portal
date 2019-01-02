package com.trilogy.project.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.Temporal;

@Entity
@Table(name = "Project")
public class Project {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="project_id")
	private long id;
	@Column(name="projectDesc")
	private String projectDesc;
	@Column(name="projectAbbr")
	private String projectAbbr;
	@Column(name="purchaseOrder")
	private String purchaseOrder;
	
	@CreationTimestamp
	@Column(name = "created_date", nullable = false, updatable = false)
    private Date createdDate;
	
	@UpdateTimestamp
    @Column(name = "modified_date",nullable = false)
    private Date modifiedDate;
    @Column(name = "lastModUser")
    private long lastModUser;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	public String getProjectAbbr() {
		return projectAbbr;
	}
	public void setProjectAbbr(String projectAbbr) {
		this.projectAbbr = projectAbbr;
	}
	public String getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public long getLastModUser() {
		return lastModUser;
	}
	public void setLastModUser(long lastModUser) {
		this.lastModUser = lastModUser;
	}
	
   
    
	
}
