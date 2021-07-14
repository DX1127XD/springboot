package cn.edu.usts.cs2018.service.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IBaseService<T, ID extends Serializable> {
 
	public abstract boolean insert(T entity);
	public abstract boolean update(T entity);
	public abstract boolean delete(T entity);
	public abstract Object findById(ID id);
	public abstract List find(Map condition);
	public abstract long count(Map obj);
	public abstract boolean saveOrUpdate(T entity);
}
 
