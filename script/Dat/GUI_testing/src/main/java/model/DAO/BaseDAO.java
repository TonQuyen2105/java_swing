/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author acebi
 * @param <T>
 */
public abstract class BaseDAO<T> {
        
//    private final Connection conn;
    protected Connection conn;

    public BaseDAO(Connection conn) {
        this.conn = conn;
    }
    // Thêm một đối tượng
    public abstract boolean insert(T obj);

    // Cập nhật đối tượng
    public abstract boolean update(T obj);

    // Xóa theo id
    public abstract boolean delete(int id);

    // Lấy theo id
    public abstract T getById(int id);

    // Lấy tất cả
    public abstract List<T> getAll();
}
