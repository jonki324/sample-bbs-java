package com.example.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.exceptions.AppException;
import com.example.models.dto.TopicDTO;
import com.example.models.dxo.TopicDXO;

public class TopicDAOImpl extends BaseDAO implements TopicDAO {

	public TopicDAOImpl(Connection connection) {
		super(connection);
	}

	private static final String FETCH_BY_ID = "fetchByIdTopics";
	
	@Override
	public TopicDTO fetchById(Integer id) {
		TopicDTO dto = null;
		String sql = QueryPropertyLoader.getQuery(FETCH_BY_ID);
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(0, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dto = TopicDXO.convert(rs);
			}
		} catch (SQLException e) {
			throw new AppException("SQLエラー: " + FETCH_BY_ID, e);
		}
		return dto;
	}

	private static final String FETCH_ALL = "fetchAllTopics";
	
	@Override
	public List<TopicDTO> fetchAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	private static final String INSERT = "insertTopics";
	
	@Override
	public int insert(TopicDTO dto) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	private static final String UPDATE = "updateTopics";
	
	@Override
	public int update(TopicDTO dto) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	private static final String DELETE = "deleteTopics";
	
	@Override
	public int delete(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
