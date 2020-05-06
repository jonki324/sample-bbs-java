package com.example.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.models.dao.TopicDAO;
import com.example.models.dao.TopicDAOImpl;
import com.example.models.dbaccess.ConnectionManager;
import com.example.models.dto.TopicDTO;

public class TopicService {
	private static Logger logger = LoggerFactory.getLogger(TopicService.class);
	
	public TopicDTO findById(Integer id) {
		TopicDTO dto = null;
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			TopicDAO dao = new TopicDAOImpl(connectionManager.getConnection());
			dto = dao.fetchById(id);
		} catch (RuntimeException e) {
			logger.error("findByIdエラー");
			throw e;
		} finally {
			connectionManager.closeConnection();
		}
		return dto;
	}
	
	public List<TopicDTO> findAll() {
		List<TopicDTO> list = new ArrayList<TopicDTO>();
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			TopicDAO dao = new TopicDAOImpl(connectionManager.getConnection());
			list = dao.fetchAll();
		} catch (RuntimeException e) {
			logger.error("findAllエラー");
			throw e;
		} finally {
			connectionManager.closeConnection();
		}
		return list;
	}
	
	public int add(TopicDTO dto) {
		int result = -1;
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			TopicDAO dao = new TopicDAOImpl(connectionManager.getConnection());
			result = dao.insert(dto);
		} catch (RuntimeException e) {
			logger.error("addエラー");
			throw e;
		} finally {
			connectionManager.closeConnection();
		}
		return result;
	}
	
	public int edit(TopicDTO dto) {
		int result = -1;
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			TopicDAO dao = new TopicDAOImpl(connectionManager.getConnection());
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
			TopicDAO dao = new TopicDAOImpl(connectionManager.getConnection());
			result = dao.delete(id);
		} catch (RuntimeException e) {
			logger.error("removeエラー");
			throw e;
		} finally {
			connectionManager.closeConnection();
		}
		return result;
	}
}
