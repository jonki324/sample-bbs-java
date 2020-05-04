package com.example.models.dao;

import java.sql.Connection;
import java.util.List;

import com.example.models.dto.TopicDTO;

public class TopicDAOImpl extends BaseDAO implements TopicDAO {

	public TopicDAOImpl(Connection connection) {
		super(connection);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public TopicDTO fetchById(String sqlId, Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<TopicDTO> fetchAll(String sqlId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int insert(String sqlId, TopicDTO dto) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int update(String sqlId, TopicDTO dto) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int delete(String sqlId, TopicDTO dto) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
