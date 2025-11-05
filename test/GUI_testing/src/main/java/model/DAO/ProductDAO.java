/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import DB.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Entity.Products;
import java.util.List;

/**
 *
 * @author acebi
 */
public class ProductDAO extends BaseDAO<Products> {

    public ProductDAO(){
        super(ConnectDB.getConnection(true));
    }

    @Override
    public boolean insert(Products obj) {
        String sql = "INSERT INTO Products (ProductName, Price, Stock, Size, PicturePath, ColorID, CategoryID, DescriptionID) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getProductName());
            ps.setFloat(2, obj.getPrice());
            ps.setInt(3, obj.getStock());
            ps.setInt(4, obj.getSize());
            ps.setString(5, obj.getPicturePath());
            ps.setInt(6, obj.getColorID());
            ps.setInt(7, obj.getCategoryID());
            ps.setInt(8, obj.getDescriptionID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Products obj) {
        String sql = "UPDATE Products SET ProductName = ?, Price = ?, Stock = ?, Size = ?, PicturePath = ?, "
            + "ColorID = ?, CategoryID = ?, DescriptionID = ? WHERE ProductID = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getProductName());
            ps.setFloat(2, obj.getPrice());
            ps.setInt(3, obj.getStock());
            ps.setInt(4, obj.getSize());
            ps.setString(5, obj.getPicturePath());
            ps.setInt(6, obj.getColorID());
            ps.setInt(7, obj.getCategoryID());
            ps.setInt(8, obj.getDescriptionID());
            ps.setInt(9, obj.getProductID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM Products WHERE ProductID = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Products getById(int id) {
        String sql = "SELECT * FROM Products WHERE ProductID = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Products(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getFloat("Price"),
                        rs.getInt("Stock"),
                        rs.getInt("Size"),
                        rs.getString("PicturePath"),
                        rs.getInt("ColorID"),
                        rs.getInt("CategoryID"),
                        rs.getInt("DescriptionID")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Products> getAll() {
        List<Products> list = new ArrayList<>();
        String sql = "SELECT * FROM Products";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Products p = new Products(
                    rs.getInt("ProductID"),
                    rs.getString("ProductName"),
                    rs.getFloat("Price"),
                    rs.getInt("Stock"),
                    rs.getInt("Size"),
                    rs.getString("PicturePath"),
                    rs.getInt("ColorID"),
                    rs.getInt("CategoryID"),
                    rs.getInt("DescriptionID")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Products> getAllDistinct() {
        List<Products> list = new ArrayList<>();
        String sql = "SELECT \n" +
                    "    MIN(ProductID) AS ProductID,\n" +
                    "    LEFT(ProductName, CHARINDEX(' - Size', ProductName + ' - Size') - 1) AS ProductName,\n" +
                    "    MIN(Price) AS Price,\n" +
                    "    MIN(Stock) AS Stock,\n" +
                    "    MIN(Size) AS Size,\n" +
                    "    MIN(PicturePath) AS PicturePath,\n" +
                    "    MIN(ColorID) AS ColorID,\n" +
                    "    MIN(CategoryID) AS CategoryID,\n" +
                    "    MIN(DescriptionID) AS DescriptionID\n" +
                    "FROM Products\n" +
                    "GROUP BY \n" +
                    "    LEFT(ProductName, CHARINDEX(' - Size', ProductName + ' - Size') - 1)\n" +
                    "ORDER BY \n" +
                    "    CAST(\n" +
                    "        SUBSTRING(\n" +
                    "            LEFT(ProductName, CHARINDEX(' - Size', ProductName + ' - Size') - 1),\n" +
                    "            CHARINDEX('#', LEFT(ProductName, CHARINDEX(' - Size', ProductName + ' - Size') - 1)) + 1,\n" +
                    "            10\n" +
                    "        ) AS INT\n" +
                    "    );";
             

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Products p = new Products(
                    rs.getInt("ProductID"),
                    rs.getString("ProductName"),
                    rs.getFloat("Price"),
                    rs.getInt("Stock"),
                    rs.getInt("Size"),
                    rs.getString("PicturePath"),
                    rs.getInt("ColorID"),
                    rs.getInt("CategoryID"),
                    rs.getInt("DescriptionID")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
