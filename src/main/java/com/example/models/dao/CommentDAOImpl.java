package com.example.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.exceptions.AppException;
import com.example.models.dto.CommentDTO;
import com.example.models.dxo.CommentDXO;

public class CommentDAOImpl extends BaseDAO implements CommentDAO {

	public CommentDAOImpl(Connection connection) {
		super(connection);
	}

	private static final String FETCH_BY_ID = "fetchByIdComments";
	
	@Override
	public CommentDTO fetchById(Integer id) {
		CommentDTO dto = null;
		String sql = QueryPropertyLoader.getQuery(FETCH_BY_ID);
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dto = CommentDXO.convert(rs);
			}
		} catch (SQLException e) {
			throw new AppException("SQLエラー: " + FETCH_BY_ID, e);
		}
		return dto;
	}

	private static final String FETCH_ALL = "fetchAllComments";
	
	@Override
	public List<CommentDTO> fetchAll() {
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		String sql = QueryPropertyLoader.getQuery(FETCH_ALL);
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CommentDTO dto = CommentDXO.convert(rs);
				list.add(dto);
			}
		} catch (SQLException e) {
			throw new AppException("SQLエラー: " + FETCH_ALL, e);
		}
		return list;
	}

	private static final String INSERT = "insertComments";
	
	@Override
	public int insert(CommentDTO dto) {
		int result = -1;
		String sql = QueryPropertyLoader.getQuery(INSERT);
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, dto.getTopicId());
			ps.setString(2, dto.getContents());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			throw new AppException("SQLエラー: " + INSERT, e);
		}
		return result;
	}

	private static final String UPDATE = "updateComments";
	
	@Override
	public int update(CommentDTO dto) {
		int result = -1;
		String sql = QueryPropertyLoader.getQuery(UPDATE);
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, dto.getContents());
			ps.setTimestamp(2, Timestamp.valueOf(dto.getModified()));
			ps.setInt(3, dto.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			throw new AppException("SQLエラー: " + UPDATE, e);
		}
		return result;
	}

	private static final String DELETE = "deleteComments";
	
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
