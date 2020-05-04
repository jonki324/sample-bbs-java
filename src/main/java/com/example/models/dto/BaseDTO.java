package com.example.models.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private LocalDateTime created;
	private LocalDateTime modified;
	
	public BaseDTO() {
	}
	
	public BaseDTO(Integer id, LocalDateTime created, LocalDateTime modified) {
		this.id = id;
		this.created = created;
		this.modified = modified;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDateTime getCreated() {
		return created;
	}
	
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	public LocalDateTime getModified() {
		return modified;
	}
	
	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}
}
