package com.example.models.dxo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.exceptions.AppException;
import com.example.models.dto.TopicDTO;

public class TopicDXO {
	private TopicDXO() {
	}
	
	public static TopicDTO convert(ResultSet rs) {
		TopicDTO dto = new TopicDTO();
		try {
			dto.setId(rs.getInt("id"));
			dto.setName(rs.getString("name"));
			dto.setCreated(rs.getTimestamp("created").toLocalDateTime());
			dto.setModified(rs.getTimestamp("modified").toLocalDateTime());
		} catch (SQLException e) {
			throw new AppException("コンバートエラー: RS > DTO", e);
		}
		return dto;
	}
}
