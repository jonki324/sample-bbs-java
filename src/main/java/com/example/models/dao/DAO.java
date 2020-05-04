package com.example.models.dao;

import java.util.List;

public interface DAO<T> {
	public abstract T fetchById(String sqlId, Integer id);
	public abstract List<T> fetchAll(String sqlId);
	public abstract int insert(String sqlId, T dto);
	public abstract int update(String sqlId, T dto);
	public abstract int delete(String sqlId, T dto);
}
