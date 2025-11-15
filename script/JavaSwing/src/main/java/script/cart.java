/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package script;
import java.sql.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class cart extends javax.swing.JFrame {

    /**
     * Creates new form Cart
     */
    public cart() {
        initComponents();
        setLocationRelativeTo(null);
        load_cartItem();
    }
    public void load_cartItem(){
        try {
            connectionDB conn = new connectionDB();
            Connection connect = conn.getConnection();
            
            String sql_query = "SELECT p.ProductName, p.ProductID, cl.ColorName, p.Price, c.Quantity FROM Cart c "
                            + "JOIN Users u ON c.UsersID=u.UsersID "
                            + "JOIN Products p ON c.ProductID=p.ProductID "
                            + "JOIN Color cl ON p.ColorID=cl.ColorID "
                            + "WHERE c.UsersID = ?";
            PreparedStatement ps = connect.prepareStatement(sql_query);
            ps.setInt(1, userSession.getUserID());
            ResultSet rs = ps.executeQuery();
            int sum_price = 0;
            while(rs.next())
            {
                String name = rs.getString("ProductName");
                String code = rs.getString("ProductID");
                String color = rs.getString("ColorName");
                int price = rs.getInt("Price");
                int quantity = rs.getInt("Quantity"); 
                
                sum_price += price * quantity;
                sum_lbl.setText(String.valueOf(sum_price));
                cartItem item = new cartItem(name, code, color, price, quantity);
                cartItem_container.add(item);
            }
            cartItem_container.revalidate();
            cartItem_container.repaint();
            
        } catch (SQLException ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        left_container = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartItem_container = new javax.swing.JPanel();
        right_container = new javax.swing.JPanel();
        pay_container = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        sum_lbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        reset_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        container.setBackground(new java.awt.Color(255, 255, 255));

        left_container.setBackground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 0, 51));
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Sản phẩm");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Đơn giá");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("Số lượng");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Thành tiền");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(63, 63, 63)
                .addComponent(jLabel5)
                .addGap(58, 58, 58))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setColumnHeaderView(null);
        jScrollPane1.setViewportView(cartItem_container);

        cartItem_container.setBackground(new java.awt.Color(255, 255, 255));
        cartItem_container.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                cartItem_containerComponentAdded(evt);
            }
        });
        cartItem_container.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cartItem_containerComponentShown(evt);
            }
        });
        cartItem_container.setLayout(new javax.swing.BoxLayout(cartItem_container, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(cartItem_container);

        javax.swing.GroupLayout left_containerLayout = new javax.swing.GroupLayout(left_container);
        left_container.setLayout(left_containerLayout);
        left_containerLayout.setHorizontalGroup(
            left_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        left_containerLayout.setVerticalGroup(
            left_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_containerLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );

        right_container.setBackground(new java.awt.Color(255, 255, 255));

        pay_container.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setText("Tổng tiền:");

        sum_lbl.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        sum_lbl.setForeground(new java.awt.Color(255, 0, 0));
        sum_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sum_lbl.setText("Tổng tiền");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton1.setText("Thanh toán");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.setContentAreaFilled(false);

        javax.swing.GroupLayout pay_containerLayout = new javax.swing.GroupLayout(pay_container);
        pay_container.setLayout(pay_containerLayout);
        pay_containerLayout.setHorizontalGroup(
            pay_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pay_containerLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pay_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pay_containerLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sum_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        pay_containerLayout.setVerticalGroup(
            pay_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pay_containerLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pay_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(sum_lbl))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        reset_lbl.setIcon(new javax.swing.ImageIcon("C:\\Users\\MSI\\Downloads\\9041913_reset_icon.png")); // NOI18N
        reset_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reset_lblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout right_containerLayout = new javax.swing.GroupLayout(right_container);
        right_container.setLayout(right_containerLayout);
        right_containerLayout.setHorizontalGroup(
            right_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, right_containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pay_container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, right_containerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reset_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        right_containerLayout.setVerticalGroup(
            right_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(right_containerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(reset_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pay_container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(421, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(left_container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(right_container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(left_container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(right_container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reset_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset_lblMouseClicked
        
        cartItem_container.removeAll();
        load_cartItem();
        
        pay_container.revalidate();
        pay_container.repaint();
                
        cartItem_container.revalidate();
        cartItem_container.repaint();
        
    }//GEN-LAST:event_reset_lblMouseClicked

    private void cartItem_containerComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cartItem_containerComponentShown

    }//GEN-LAST:event_cartItem_containerComponentShown

    private void cartItem_containerComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_cartItem_containerComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cartItem_containerComponentAdded
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cartItem_container;
    private javax.swing.JPanel container;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel left_container;
    private javax.swing.JPanel pay_container;
    private javax.swing.JLabel reset_lbl;
    private javax.swing.JPanel right_container;
    private javax.swing.JLabel sum_lbl;
    // End of variables declaration//GEN-END:variables
}
