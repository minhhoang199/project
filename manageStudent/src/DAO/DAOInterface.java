package DAO;

import java.util.ArrayList;

public interface DAOInterface<T> {
    void insert(T t);
    void delete(String id);
    void update(T t);
    ArrayList<T> selectAll();
    T selectByID(String id);
}
