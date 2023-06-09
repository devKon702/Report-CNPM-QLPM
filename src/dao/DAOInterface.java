
package dao;

import java.util.ArrayList;


public interface DAOInterface<T> {
    public boolean insert(T obj);
    
    public boolean delete(T obj);
    
    public boolean update(T obj);
    
    public ArrayList<T> getAll();
}

