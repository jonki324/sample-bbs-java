package com.example.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
			ps.setInt(1, id);
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
		List<TopicDTO> list = new ArrayList<TopicDTO>();
		String sql = QueryPropertyLoader.getQuery(FETCH_ALL);
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TopicDTO dto = TopicDXO.convert(rs);
				list.add(dto);
			}
		} catch (SQLException e) {
			throw new AppException("SQLエラー: " + FETCH_ALL, e);
		}
		return list;
	}

	private static final String INSERT = "insertTopics";
	
	@Override
	public int insert(TopicDTO dto) {
		int result = -1;
		String sql = QueryPropertyLoader.getQuery(INSERT);
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, dto.getName());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			throw new AppException("SQLエラー: " + INSERT, e);
		}
		return result;
	}

	private static final String UPDATE = "updateTopics";
	
	@Override
	public int update(TopicDTO dto) {
		int result = -1;
		String sql = QueryPropertyLoader.getQuery(UPDATE);
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, dto.getName());
			ps.setTimestamp(2, Timestamp.valueOf(dto.getModified()));
			ps.setInt(3, dto.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			throw new AppException("SQLエラー: " + UPDATE, e);
		}
		return result;
	}

	private static final String DELETE = "deleteTopics";
	
	@Override
	public int delete(Integer id) {
		int result = -1;
		String sql = QueryPropertyLoader.getQuery(DELETE);
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			throw new AppException("SQLエラー: " + DELETE, e);
		}
		return result;
	}
}
