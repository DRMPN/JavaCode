package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T, ID> {

    Optional<T> find(ID id) throws SQLException;

    List<T> findAll() throws SQLException;

    boolean save(T o) throws SQLException;

    boolean update(T o) throws SQLException;

    boolean delete(T o) throws SQLException;
}