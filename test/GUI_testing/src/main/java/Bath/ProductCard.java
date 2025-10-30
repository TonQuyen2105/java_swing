package Bath;

import java.awt.*;
import javax.swing.*;

public class ProductCard extends javax.swing.JPanel {

    /**
     * Creates new form ProductCard
     */
    public ProductCard(String name, String price, ImageIcon img) {
        initComponents();
        tênsp.setText(name);
        giásp.setText(price);
        setProductImage(img);
    }

    /**
     * Hàm resize ảnh cho vừa khung JLabel "ảnh"
     */
    private void setProductImage(ImageIcon imageIcon) {
        if (imageIcon != null) {
            Image img = imageIcon.getImage();

            // Lấy kích thước khung ảnh (JLabel)
            int width = ảnh.getWidth();
            int height = ảnh.getHeight();

            // Nếu chưa render, đặt mặc định kích thước
            if (width <= 0 || height <= 0) {
                width = 200;
                height = 200;
            }

            // ✅ Resize ảnh cho vừa khung
            Image scaled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ảnh.setIcon(new ImageIcon(scaled));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ảnh = new javax.swing.JLabel();
        tênsp = new javax.swing.JLabel();
        giásp = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 245));
//        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                BorderFactory.createEmptyBorder(10,10,10,10)
        ));
        setPreferredSize(new java.awt.Dimension(250, 350));

        ảnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ảnh.setPreferredSize(new java.awt.Dimension(200, 200));

        tênsp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tênsp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tênsp.setText("Tên sản phẩm");

        giásp.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        giásp.setForeground(new java.awt.Color(204, 0, 0));
        giásp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        giásp.setText("Giá sản phẩm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ảnh, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(tênsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(giásp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(ảnh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tênsp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(giásp)
                                .addGap(0, 10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ảnh;
    private javax.swing.JLabel giásp;
    private javax.swing.JLabel tênsp;
    // End of variables declaration//GEN-END:variables
}
