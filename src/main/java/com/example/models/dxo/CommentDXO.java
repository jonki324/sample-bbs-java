package com.example.models.dxo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.exceptions.AppException;
import com.example.models.dto.CommentDTO;

public class CommentDXO {
	private CommentDXO() {
	}
	
	public static CommentDTO convert(ResultSet rs) {
		CommentDTO dto = new CommentDTO();
		try {
			dto.setId(rs.getInt("id"));
			dto.setTopicId(rs.getInt("topic_id"));
			dto.setContents(rs.getString("contents"));
			dto.setCreated(rs.getTimestamp("created").toLocalDateTime());
			dto.setModified(rs.getTimestamp("modified").toLocalDateTime());
		} catch (SQLException e) {
			throw new AppException("コンバートエラー: RS > DTO", e);
		}
		return dto;
	}
}
