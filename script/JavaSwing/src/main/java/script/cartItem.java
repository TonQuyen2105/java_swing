package script;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
<<<<<<< HEAD

=======
import script.connectionDB;
>>>>>>> f504e55fb860ac25cdbae292524890a45ff4a7ae

/**
 *
 * @author MSI
 */
public class cartItem extends javax.swing.JPanel {
    public cartItem(String name, String code, String color, int price, int quantity) {
        initComponents();
        name_lbl.setText(name);
        code_lbl.setText(code);
        color_lbl.setText(color);
        price_lbl.setText(String.valueOf(price + "đ"));
        quantity_lbl.setText(String.valueOf(quantity));
        total_lbl.setText(String.valueOf(quantity * price + "đ"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        del_btn = new javax.swing.JButton();
        img_lbl = new javax.swing.JLabel();
        name_lbl = new javax.swing.JLabel();
        code_lbl = new javax.swing.JLabel();
        color_lbl = new javax.swing.JLabel();
        price_lbl = new javax.swing.JLabel();
        minus_btn = new javax.swing.JButton();
        plus_btn = new javax.swing.JButton();
        total_lbl = new javax.swing.JLabel();
        quantity_lbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(764, 160));

        del_btn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        del_btn.setText("X");
        del_btn.setBorder(null);
        del_btn.setContentAreaFilled(false);
        del_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_btnActionPerformed(evt);
            }
        });

        img_lbl.setIcon(new javax.swing.ImageIcon("C:\\Users\\MSI\\Desktop\\anh.jpg")); // NOI18N
        img_lbl.setText("jLabel1");

        name_lbl.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        name_lbl.setText("Tên sản phẩm");

        code_lbl.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        code_lbl.setText("Mã sản phẩm");

        color_lbl.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        color_lbl.setText("Màu");

        price_lbl.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        price_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price_lbl.setText("1 080 000");

        minus_btn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        minus_btn.setText("-");
        minus_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        minus_btn.setContentAreaFilled(false);
        minus_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus_btnMouseClicked(evt);
            }
        });
        minus_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minus_btnActionPerformed(evt);
            }
        });

        plus_btn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        plus_btn.setText("+");
        plus_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        plus_btn.setContentAreaFilled(false);
        plus_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus_btnMouseClicked(evt);
            }
        });
        plus_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plus_btnActionPerformed(evt);
            }
        });

        total_lbl.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        total_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total_lbl.setText("1 080 000");

        quantity_lbl.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        quantity_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantity_lbl.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(del_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(code_lbl)
                            .addComponent(color_lbl))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name_lbl)
                        .addGap(34, 34, 34)
                        .addComponent(price_lbl)
                        .addGap(18, 18, 18)
                        .addComponent(minus_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(quantity_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plus_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(del_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(img_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_lbl)
                    .addComponent(price_lbl)
                    .addComponent(minus_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plus_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_lbl)
                    .addComponent(quantity_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(code_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(color_lbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void del_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_btnActionPerformed
        try {
<<<<<<< HEAD
            ConnectDB conn = new ConnectDB();
=======
            connectionDB conn = new connectionDB();
>>>>>>> f504e55fb860ac25cdbae292524890a45ff4a7ae
            Connection connect = conn.getConnection();
            String sql_query = "DELETE FROM Cart WHERE UsersID = ? AND ProductID = ?";
            PreparedStatement ps = connect.prepareStatement(sql_query);
            ps.setInt(1, userSession.getUserID());
            ps.setString(2, code_lbl.getText());
            ps.executeUpdate();
            
         } catch (SQLException ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_del_btnActionPerformed

    private void minus_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minus_btnActionPerformed
         try {
<<<<<<< HEAD
            ConnectDB conn = new ConnectDB();
=======
            connectionDB conn = new connectionDB();
>>>>>>> f504e55fb860ac25cdbae292524890a45ff4a7ae
            Connection connect = conn.getConnection();
            String sql_query = "UPDATE Cart SET Quantity = ? WHERE UsersID = ? AND ProductID = ?";
            PreparedStatement ps = connect.prepareStatement(sql_query);
            ps.setInt(2, userSession.getUserID());
            ps.setString(3, code_lbl.getText());
            int quantity = Integer.parseInt(quantity_lbl.getText());
            if(quantity > 1){
                int minusQuantity = quantity - 1;
                quantity_lbl.setText(String.valueOf(minusQuantity));
                ps.setInt(1, minusQuantity);
                ps.executeUpdate();
                
                ps.close();
                connect.close();
            }
         } catch (SQLException ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_minus_btnActionPerformed

    private void plus_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plus_btnActionPerformed
        try {
<<<<<<< HEAD
            ConnectDB conn = new ConnectDB();
=======
            connectionDB conn = new connectionDB();
>>>>>>> f504e55fb860ac25cdbae292524890a45ff4a7ae
            Connection connect = conn.getConnection();
            String sql_query = "UPDATE Cart SET Quantity = ? WHERE UsersID = ? AND ProductID = ?";
            PreparedStatement ps = connect.prepareStatement(sql_query);
            ps.setInt(2, userSession.getUserID());
            ps.setString(3, code_lbl.getText());
            
            int quantity = Integer.parseInt(quantity_lbl.getText());
            if(quantity >= 1){
                int plusQuantity = quantity + 1;
                quantity_lbl.setText(String.valueOf(plusQuantity));
                ps.setInt(1, plusQuantity);
                ps.executeUpdate();
                
                ps.close();
                connect.close();
            }
            
         } catch (SQLException ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_plus_btnActionPerformed

    private void minus_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus_btnMouseClicked
        
    }//GEN-LAST:event_minus_btnMouseClicked

    private void plus_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus_btnMouseClicked
       
    }//GEN-LAST:event_plus_btnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel code_lbl;
    private javax.swing.JLabel color_lbl;
    private javax.swing.JButton del_btn;
    private javax.swing.JLabel img_lbl;
    private javax.swing.JButton minus_btn;
    private javax.swing.JLabel name_lbl;
    private javax.swing.JButton plus_btn;
    private javax.swing.JLabel price_lbl;
    private javax.swing.JLabel quantity_lbl;
    private javax.swing.JLabel total_lbl;
    // End of variables declaration//GEN-END:variables
}
