/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Bath.ProductCard;
import java.text.DecimalFormat;
import model.Entity.Products;
import model.DAO.ProductDAO;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author acebi
 */
public class ProductController {
    private final ProductDAO productDAO;
    
    public ProductController() {
        productDAO = new ProductDAO();
    }
    
    public List<Products> getProducts () {
        return productDAO.getAllDistinct();
    }
    
    public void showProducts(JPanel panel) {
        List<Products> products = getProducts();
        DecimalFormat df = new DecimalFormat("#,###");
        panel.removeAll(); // xoá cũ

        // Layout dạng lưới 3 cột (bạn có thể đổi tùy ý)
        panel.setLayout(new java.awt.GridLayout(0, 3, 20, 20));

        for (Products p : products) {
            // Load ảnh (nếu null thì dùng ảnh mặc định)
            ImageIcon img = null;
            if (p.getPicturePath() != null && !p.getPicturePath().isEmpty() && p.getPicturePath() == "nill") {
                img = new ImageIcon(p.getPicturePath());
            } else {
//                img = new ImageIcon(getClass().getResource("/Asset/Picture/Screenshot 2025-04-24 182053.png"));
                img = new ImageIcon(getClass().getResource("/Asset/Picture/default.png"));
            }

            // Tạo card cho mỗi sản phẩm
            String priceText = df.format(p.getPrice()) + " VNĐ";
            ProductCard card = new ProductCard(
                p.getProductName(),
//                String.format("%.0f VNĐ", p.getPrice()),
                priceText,
                img
            );

            panel.add(card);
        }

        // Cập nhật lại UI sau khi thêm
        panel.revalidate();
        panel.repaint();
    }
}

