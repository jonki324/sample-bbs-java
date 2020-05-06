package com.example.models.dao;

import java.util.List;

import com.example.models.dto.CommentDTO;

public interface CommentDAO extends DAO<CommentDTO> {
	public abstract List<CommentDTO> fetchByTopicId(Integer topicId);
}
