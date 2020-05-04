package com.example.models.dto;

import java.time.LocalDateTime;

public class CommentDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	private String contents;

	public CommentDTO() {
		super();
	}

	public CommentDTO(Integer id, LocalDateTime created, LocalDateTime modified, String contents) {
		super(id, created, modified);
		this.contents = contents;
	}

	public String getContents() {
		return contents;
	}

	public void setName(String contents) {
		this.contents = contents;
	}
}
