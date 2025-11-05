package view;

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

        setBackground(new java.awt.Color(204, 204, 204));

        ảnh.setBackground(new java.awt.Color(255, 255, 255));
        ảnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/Picture/Screenshot 2025-04-24 182053.png"))); // NOI18N
        ảnh.setPreferredSize(new java.awt.Dimension(47, 300));

        tênsp.setText("Tên SP");

        giásp.setText("Giá SP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ảnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
            .addComponent(tênsp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(giásp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ảnh, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tênsp, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(giásp, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ảnh;
    private javax.swing.JLabel giásp;
    private javax.swing.JLabel tênsp;
    // End of variables declaration//GEN-END:variables
}
