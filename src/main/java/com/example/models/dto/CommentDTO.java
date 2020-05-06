package com.example.models.dto;

import java.time.LocalDateTime;

public class CommentDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	private Integer topicId;
	private String contents;

	public CommentDTO() {
		super();
	}

	public CommentDTO(Integer id, LocalDateTime created, LocalDateTime modified, Integer topicId, String contents) {
		super(id, created, modified);
		this.topicId = topicId;
		this.contents = contents;
	}
	
	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
}
