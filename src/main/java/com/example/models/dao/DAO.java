package com.example.models.dao;

import java.util.List;

public interface DAO<T> {
	public abstract T fetchById(Integer id);
	public abstract List<T> fetchAll();
	public abstract int insert(T dto);
	public abstract int update(T dto);
	public abstract int delete(Integer id);
}
