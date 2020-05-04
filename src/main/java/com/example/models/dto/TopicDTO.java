package com.example.models.dto;

import java.time.LocalDateTime;

public class TopicDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	private String name;

	public TopicDTO() {
		super();
	}

	public TopicDTO(Integer id, LocalDateTime created, LocalDateTime modified, String name) {
		super(id, created, modified);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
