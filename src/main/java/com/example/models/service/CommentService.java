package com.example.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.models.dao.CommentDAO;
import com.example.models.dao.CommentDAOImpl;
import com.example.models.dbaccess.ConnectionManager;
import com.example.models.dto.CommentDTO;

public class CommentService {
	private static Logger logger = LoggerFactory.getLogger(CommentService.class);
	
	public CommentDTO findById(Integer id) {
		CommentDTO dto = null;
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			CommentDAO dao = new CommentDAOImpl(connectionManager.getConnection());
			dto = dao.fetchById(id);
		} catch (RuntimeException e) {
			logger.error("findByIdエラー");
			throw e;
		} finally {
			connectionManager.closeConnection();
		}
		return dto;
	}
	
	public List<CommentDTO> findAll() {
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			CommentDAO dao = new CommentDAOImpl(connectionManager.getConnection());
			list = dao.fetchAll();
		} catch (RuntimeException e) {
			logger.error("findAllエラー");
			throw e;
		} finally {
			connectionManager.closeConnection();
		}
		return list;
	}
	
	public int add(CommentDTO dto) {
		int result = -1;
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			CommentDAO dao = new CommentDAOImpl(connectionManager.getConnection());
			result = dao.insert(dto);
		} catch (RuntimeException e) {
			logger.error("addエラー");
			throw e;
		} finally {
			connectionManager.closeConnection();
		}
		return result;
	}
	
	public int edit(CommentDTO dto) {
		int result = -1;
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			CommentDAO dao = new CommentDAOImpl(connectionManager.getConnection());
			result = dao.update(dto);
		} catch (RuntimeException e) {
			logger.error("editエラー");
			throw e;
		} finally {
			connectionManager.closeConnection();
		}
		return result;
	}
	
	public int remove(Integer id) {
		int result = -1;
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			CommentDAO dao = new CommentDAOImpl(connectionManager.getConnection());
			result = dao.delete(id);
		} catch (RuntimeException e) {
			logger.error("removeエラー");
			throw e;
		} finally {
			connectionManager.closeConnection();
		}
		return result;
	}
	
	public List<CommentDTO> findByTopicId(Integer topicId) {
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			CommentDAO dao = new CommentDAOImpl(connectionManager.getConnection());
			list = dao.fetchByTopicId(topicId);
		} catch (RuntimeException e) {
			logger.error("findByTopicIdエラー");
			throw e;
		} finally {
			connectionManager.closeConnection();
		}
		return list;
	}
}
