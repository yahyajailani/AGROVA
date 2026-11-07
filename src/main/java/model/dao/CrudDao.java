package model.dao;

import java.sql.SQLException;
import java.util.List;

//Kontrak CRUD pada setiap Dao
public interface CrudDao<T> {
    List<T> findAll() throws SQLException;

    T findById(int id) throws SQLException;

    long insert(T data) throws SQLException;

    boolean update(T data) throws SQLException;

    boolean delete(int id) throws SQLException;
}
