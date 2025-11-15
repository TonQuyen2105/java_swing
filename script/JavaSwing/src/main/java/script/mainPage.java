/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package script;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import script.orderitem;
import javax.swing.JLabel;


/**
 *
 * @author TonQuyen
 */
public class mainPage extends javax.swing.JFrame {

    static boolean maximized = true;
    int xMouse;
    int yMouse;
    int width = 200;

    boolean isMenuOpen = false;
    public mainPage() {
        initComponents();
        loadOrderList();
        loadDetailOrderList();
        
        
        
        // chỉnh menu
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(sidemenu, BorderLayout.WEST);
        jPanel2.add(listsanpham, BorderLayout.CENTER);
        
        sidemenu.setPreferredSize(new Dimension(0, sidemenu.getHeight()));
        sidemenu.revalidate();
        sidemenu.repaint();
        
        // đại đại mà fix được bug =))) khó hiểu thật, mấy trang khác cũng add vào contentContainer
        // Thay đổi layout của taiKhoan thành BorderLayout
        taiKhoan.setLayout(new BorderLayout());
        // Thêm khoảng trống phía trên
        taiKhoan.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH);
        //// Tạo panel chứa toàn bộ nội dung
        JPanel contentContainer = new JPanel();
        taiKhoan.add(contentContainer, BorderLayout.CENTER);
        
//        JLabel lblBackToOrder = new JLabel("← Quay lại đơn hàng");
//        lblBackToOrder.setForeground(new java.awt.Color(0, 102, 204));
//        lblBackToOrder.setFont(new java.awt.Font("Segoe UI", 1, 14));
//        lblBackToOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//
//        // Gắn sự kiện click
//        lblBackToOrder.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                // Hiển thị lại trang đơn hàng
//                trangChu.setVisible(false);
//                taiKhoan.setVisible(false);
//                chitietdonhang.setVisible(false);
//                donhang.setVisible(true);
//            }
//
//            @Override
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                lblBackToOrder.setForeground(new java.awt.Color(0, 51, 153));
//            }
//
//            @Override
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                lblBackToOrder.setForeground(new java.awt.Color(0, 102, 204));
//            }
//        });
//
//        // Thêm nó vào phần đầu của panel chi tiết
//        jPanel18.add(lblBackToOrder);
//  

//        int width_image = jLabel25.getWidth();
//        int height_image = jLabel25.getHeight();
//        ImageIcon icon = new ImageIcon("C:\\Users\\admin\\Documents\\NetBeansProjects\\app\\src\\main\\resources\\com\\mycompany\\icon\\advertise.jpg");
//        Image scaledImage = icon.getImage().getScaledInstance(width_image, height_image, Image.SCALE_SMOOTH);
//        ImageIcon scaledIcon = new ImageIcon(scaledImage);
//        jLabel25.setIcon(scaledIcon);
        
//        jPanel17.setLayout(new BoxLayout(jPanel17, BoxLayout.X_AXIS));
//        jPanel17.add(jLabel26);
//        jPanel17.add(Box.createHorizontalGlue());
//        jPanel17.add(jLabel27);
//        jPanel17.add(Box.createHorizontalGlue());
//        jPanel17.add(jLabel28);

    pnlProducts.setLayout(new GridLayout(0, 4, 30 , 30));

    itemProduct sp1 = new itemProduct("/C:/Users/acebi/Documents/GitHub/java_swing/script/JavaSwing/src/main/resources/asset/picture/product/AYTT001-2.jpg", "Giày bóng rổ", 130.501);
//    file:/C:/Users/acebi/Documents/GitHub/java_swing/script/JavaSwing/src/main/resources/asset/picture/product/AYTT001-2.jpg

    itemProduct sp2 = new itemProduct("/C:/Users/acebi/Documents/GitHub/java_swing/script/JavaSwing/src/main/resources/asset/picture/product/AYTT001-4.jpg", "Giày chạy bộ", 130.501);
    itemProduct sp3 = new itemProduct("/C:/Users/acebi/Documents/GitHub/java_swing/script/JavaSwing/src/main/resources/asset/picture/product/AYTT001-5.jpg", "Giày chạy bộ", 130.501);
    itemProduct sp4 = new itemProduct("/C:/Users/acebi/Documents/GitHub/java_swing/script/JavaSwing/src/main/resources/asset/picture/product/AYTT001-6.jpg", "Giày chạy bộ", 130.501);
    itemProduct sp5 = new itemProduct("/C:/Users/acebi/Documents/GitHub/java_swing/script/JavaSwing/src/main/resources/asset/picture/product/AYTT001-5.jpg", "Giày chạy bộ", 130.501);
    itemProduct sp6 = new itemProduct("/C:/Users/acebi/Documents/GitHub/java_swing/script/JavaSwing/src/main/resources/asset/picture/product/AYTT001-6.jpg", "Giày bóng rổ", 130.501);
    itemProduct sp7 = new itemProduct("/C:/Users/acebi/Documents/GitHub/java_swing/script/JavaSwing/src/main/resources/asset/picture/product/AYTT001-2.jpg", "Giày chạy bộ", 130.501);
    itemProduct sp8 = new itemProduct("/C:/Users/acebi/Documents/GitHub/java_swing/script/JavaSwing/src/main/resources/asset/picture/product/AYTT001-4.jpg", "Giày chạy bộ", 130.501);
    itemProduct sp9 = new itemProduct("/C:/Users/acebi/Documents/GitHub/java_swing/script/JavaSwing/src/main/resources/asset/picture/product/AYTT001-2.jpg", "Giày chạy bộ", 130.501);
    itemProduct sp10 = new itemProduct("/C:/Users/acebi/Documents/GitHub/java_swing/script/JavaSwing/src/main/resources/asset/picture/product/AYTT001-6.jpg", "Giày chạy bộ", 130.501);
    itemProduct sp11 = new itemProduct("/C:/Users/acebi/Documents/GitHub/java_swing/script/JavaSwing/src/main/resources/asset/picture/product/AYTT001-4.jpg", "Giày bóng rổ", 130.501);
    itemProduct sp12 = new itemProduct("/C:/Users/acebi/Documents/GitHub/java_swing/script/JavaSwing/src/main/resources/asset/picture/product/AYTT001-5.jpg", "Giày chạy bộ", 130.501);
    itemProduct sp13 = new itemProduct("images/chaybo.png", "Giày chạy bộ", 130.501);
    itemProduct sp14 = new itemProduct("images/chaybo.png", "Giày chạy bộ", 130.501);
    itemProduct sp15 = new itemProduct("images/chaybo.png", "Giày chạy bộ", 130.501);
    itemProduct sp16 = new itemProduct("images/bongro.png", "Giày bóng rổ", 130.501);
    itemProduct sp17 = new itemProduct("images/chaybo.png", "Giày chạy bộ", 130.501);
    itemProduct sp18 = new itemProduct("images/chaybo.png", "Giày chạy bộ", 130.501);
    itemProduct sp19 = new itemProduct("images/chaybo.png", "Giày chạy bộ", 130.501);
    itemProduct sp20 = new itemProduct("images/chaybo.png", "Giày chạy bộ", 130.501);
    pnlProducts.add(sp1);
    pnlProducts.add(sp2);
    pnlProducts.add(sp3);
    pnlProducts.add(sp4);
    pnlProducts.add(sp5);
    pnlProducts.add(sp6);
    pnlProducts.add(sp7);
    pnlProducts.add(sp8);
    pnlProducts.add(sp9);
    pnlProducts.add(sp10);
    pnlProducts.add(sp11);
    pnlProducts.add(sp12);
    pnlProducts.add(sp13);
    pnlProducts.add(sp14);
    pnlProducts.add(sp15);
    pnlProducts.add(sp16);
    pnlProducts.add(sp17);
    pnlProducts.add(sp18);
    pnlProducts.add(sp19);
    pnlProducts.add(sp20);
    
    pnlProducts.revalidate();
    pnlProducts.repaint();
    
            // ---------------------- LABEL QUAY LẠI ----------------------
    JLabel lblBackToOrder = new JLabel("← Quay lại đơn hàng");
    lblBackToOrder.setForeground(new java.awt.Color(0, 102, 204));
    lblBackToOrder.setFont(new java.awt.Font("Segoe UI", 1, 14));
    lblBackToOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    lblBackToOrder.setHorizontalAlignment(SwingConstants.RIGHT);
    lblBackToOrder.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 20)); // padding cho đẹp

    // Gắn sự kiện click
    lblBackToOrder.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            chitietdonhang.setVisible(false);
            donhang.setVisible(true);
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            lblBackToOrder.setForeground(new java.awt.Color(0, 51, 153));
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
            lblBackToOrder.setForeground(new java.awt.Color(0, 102, 204));
        }
    });

    // Panel chứa label quay lại
    JPanel backPanel = new JPanel(new BorderLayout());
    backPanel.setBackground(java.awt.Color.WHITE);
    backPanel.add(lblBackToOrder, BorderLayout.EAST);

    // Thêm panel này vào trên đầu của phần chi tiết đơn hàng
    chitietdonhang.add(backPanel, BorderLayout.NORTH);
    chitietdonhang.revalidate();
    chitietdonhang.repaint();




    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlHeader = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        sidemenu = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        logo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        mainPage = new javax.swing.JLabel();
        account = new javax.swing.JLabel();
        order = new javax.swing.JLabel();
        cart_lbl = new javax.swing.JLabel();
        thongKe = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        listsanpham = new javax.swing.JPanel();
        trangChu = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pnlProducts = new javax.swing.JPanel();
        taiKhoan = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        donhang = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        ListOrder = new javax.swing.JPanel();
        chitietdonhang = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        ListChiTietOrder = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel43 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderMouseDragged(evt);
            }
        });
        pnlHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderMousePressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/picture/user/exit.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setOpaque(true);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/picture/user/square.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setOpaque(true);
        jButton2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jButton2MouseDragged(evt);
            }
        });
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/picture/user/minus.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setOpaque(true);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(1500, 1500));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/picture/user/menu.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        sidemenu.setBackground(new java.awt.Color(255, 255, 255));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/picture/user/exit.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        jButton4.setOpaque(true);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/picture/user/logo.png"))); // NOI18N

        javax.swing.GroupLayout logoLayout = new javax.swing.GroupLayout(logo);
        logo.setLayout(logoLayout);
        logoLayout.setHorizontalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        logoLayout.setVerticalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        mainPage.setBackground(new java.awt.Color(255, 255, 255));
        mainPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainPage.setText("Trang Chủ");
        mainPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mainPage.setOpaque(true);
        mainPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainPageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mainPageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mainPageMouseExited(evt);
            }
        });

        account.setBackground(new java.awt.Color(255, 255, 255));
        account.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        account.setText("Tài Khoản");
        account.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        account.setOpaque(true);
        account.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountMouseExited(evt);
            }
        });

        order.setBackground(new java.awt.Color(255, 255, 255));
        order.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        order.setText("Đơn Hàng");
        order.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        order.setOpaque(true);
        order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                orderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                orderMouseExited(evt);
            }
        });

        cart_lbl.setBackground(new java.awt.Color(255, 255, 255));
        cart_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cart_lbl.setText("Giỏ Hàng");
        cart_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cart_lbl.setOpaque(true);
        cart_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cart_lblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cart_lblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cart_lblMouseExited(evt);
            }
        });

        thongKe.setBackground(new java.awt.Color(255, 255, 255));
        thongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thongKe.setText("Thống kê");
        thongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        thongKe.setOpaque(true);
        thongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                thongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                thongKeMouseExited(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cart_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(thongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(mainPage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(order, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cart_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(thongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Trợ Giúp");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.setOpaque(true);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Đăng Xuất");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.setOpaque(true);

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator4)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 508, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout sidemenuLayout = new javax.swing.GroupLayout(sidemenu);
        sidemenu.setLayout(sidemenuLayout);
        sidemenuLayout.setHorizontalGroup(
            sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidemenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4))
            .addComponent(jSeparator5)
        );
        sidemenuLayout.setVerticalGroup(
            sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidemenuLayout.createSequentialGroup()
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listsanpham.setBackground(new java.awt.Color(255, 255, 255));
        listsanpham.setLayout(new java.awt.CardLayout());

        trangChu.setBackground(new java.awt.Color(255, 255, 255));
        trangChu.setPreferredSize(new java.awt.Dimension(1063, 594));
        trangChu.setLayout(new javax.swing.BoxLayout(trangChu, javax.swing.BoxLayout.Y_AXIS));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/picture/user/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        trangChu.add(jPanel12);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setMaximumSize(new java.awt.Dimension(2000, 1000));
        jPanel16.setLayout(new java.awt.GridLayout(1, 3));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("GIÀY CHẠY BỘ");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel16.add(jLabel19);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("GIÀY BÓNG RỔ");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel16.add(jLabel23);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("GIÀY CẦU LÔNG");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel16.add(jLabel24);

        trangChu.add(jPanel16);

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(50, 60));

        pnlProducts.setBackground(new java.awt.Color(255, 255, 255));
        pnlProducts.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 0, 0));
        pnlProducts.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 20));
        jScrollPane3.setViewportView(pnlProducts);

        trangChu.add(jScrollPane3);

        listsanpham.add(trangChu, "card2");

        taiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        taiKhoan.setMaximumSize(new java.awt.Dimension(1500, 1500));
        taiKhoan.setOpaque(false);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THÔNG TIN KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/picture/user/avatar.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Name: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Phone:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Address:");

        jLabel12.setText("Tôn Quyền");

        jLabel13.setText("0937685909");

        jLabel14.setText("27C Phạm Vấn, phường Phú Thọ Hòa, quận Tân Phú, TPHCM");

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("DASHBOARD");
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setText("CARTS");
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setText("ORDERS");
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setText("PURCHASE HISTORY");
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel15.setBackground(new java.awt.Color(0, 204, 102));
        jLabel15.setOpaque(true);

        jLabel16.setBackground(new java.awt.Color(0, 204, 102));
        jLabel16.setOpaque(true);

        jLabel17.setBackground(new java.awt.Color(0, 204, 102));
        jLabel17.setOpaque(true);

        jLabel18.setBackground(new java.awt.Color(0, 204, 102));
        jLabel18.setOpaque(true);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(1089, 933));

        jLabel20.setBackground(new java.awt.Color(0, 204, 102));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("VIEW");
        jLabel20.setOpaque(true);

        jButton10.setBackground(new java.awt.Color(242, 242, 242));
        jButton10.setText("jButton10");
        jButton10.setBorder(null);
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel21.setBackground(new java.awt.Color(52, 152, 219));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("MANAGE");
        jLabel21.setOpaque(true);

        jButton11.setBackground(new java.awt.Color(242, 242, 242));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/picture/user/repair.png"))); // NOI18N
        jButton11.setBorder(null);
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.setRequestFocusEnabled(false);
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jLabel22.setBackground(new java.awt.Color(243, 156, 18));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("RANK");
        jLabel22.setOpaque(true);

        jButton12.setBackground(new java.awt.Color(242, 242, 242));
        jButton12.setText("jButton12");
        jButton12.setBorder(null);
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.setOpaque(true);
        jButton12.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(483, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(411, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout taiKhoanLayout = new javax.swing.GroupLayout(taiKhoan);
        taiKhoan.setLayout(taiKhoanLayout);
        taiKhoanLayout.setHorizontalGroup(
            taiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(taiKhoanLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 1266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        taiKhoanLayout.setVerticalGroup(
            taiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taiKhoanLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE))
        );

        listsanpham.add(taiKhoan, "card3");

        donhang.setBackground(new java.awt.Color(255, 255, 255));
        donhang.setLayout(new java.awt.BorderLayout(10, 10));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(80, 1, 1, 1));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel25.setText("Order#");
        jLabel25.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        jPanel1.add(jLabel25);

        jLabel26.setText("NameReciver");
        jPanel1.add(jLabel26);

        jLabel27.setText("Date");
        jPanel1.add(jLabel27);

        jLabel28.setText("Status");
        jPanel1.add(jLabel28);

        jLabel29.setText("Price");
        jPanel1.add(jLabel29);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        jLabel42.setText(" ");
        jLabel42.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 50, 1));
        jPanel8.add(jLabel42);

        jPanel1.add(jPanel8);

        donhang.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        ListOrder.setLayout(new javax.swing.BoxLayout(ListOrder, javax.swing.BoxLayout.Y_AXIS));
        donhang.add(ListOrder, java.awt.BorderLayout.CENTER);

        listsanpham.add(donhang, "card4");

        chitietdonhang.setBackground(new java.awt.Color(255, 255, 255));
        chitietdonhang.setLayout(new java.awt.BorderLayout(10, 10));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createEmptyBorder(80, 1, 1, 1));
        jPanel18.setLayout(new java.awt.GridLayout(1, 0));

        jLabel30.setText("Product#");
        jLabel30.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        jPanel18.add(jLabel30);

        jLabel32.setText("Image");
        jPanel18.add(jLabel32);

        jLabel31.setText("ProductName");
        jPanel18.add(jLabel31);

        jLabel34.setText("Price");
        jPanel18.add(jLabel34);

        jLabel33.setText("Quantity");
        jPanel18.add(jLabel33);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel40.setText(" ");
        jLabel40.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        jPanel7.add(jLabel40);

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Quay Lại");
        jLabel41.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 50, 1));
        jPanel7.add(jLabel41);

        jPanel18.add(jPanel7);

        chitietdonhang.add(jPanel18, java.awt.BorderLayout.PAGE_START);

        ListChiTietOrder.setLayout(new javax.swing.BoxLayout(ListChiTietOrder, javax.swing.BoxLayout.Y_AXIS));
        chitietdonhang.add(ListChiTietOrder, java.awt.BorderLayout.CENTER);

        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 60, 5));

        jLabel35.setText("đang xác thực");
        jPanel19.add(jLabel35);

        jLabel36.setText("đã đóng gói");
        jPanel19.add(jLabel36);

        jLabel37.setText("đã giao cho đơn vị vận chuyển");
        jPanel19.add(jLabel37);

        jLabel38.setText("đang giao hàng");
        jPanel19.add(jLabel38);

        jLabel39.setText("hàng đã được giao");
        jPanel19.add(jLabel39);

        chitietdonhang.add(jPanel19, java.awt.BorderLayout.PAGE_END);

        listsanpham.add(chitietdonhang, "card5");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Search");
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/picture/user/71403.png"))); // NOI18N
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sidemenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listsanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(sidemenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setBackground(new Color(232, 17, 35));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setBackground(new Color(232, 17, 35));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if(maximized) {
            mainPage.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsEnvironment evr = GraphicsEnvironment.getLocalGraphicsEnvironment();
            mainPage.this.setMaximizedBounds(evr.getMaximumWindowBounds());
            maximized = false;
        }
        else {
            setExtendedState(JFrame.NORMAL);
            maximized = true;
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseDragged

    private void pnlHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlHeaderMousePressed

    private void pnlHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMouseDragged
        if (maximized) {
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x-xMouse, y-yMouse);
        }
    }//GEN-LAST:event_pnlHeaderMouseDragged

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setBackground(new Color(232, 17, 35));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton4.setBackground(new Color(232, 17, 35));
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jButton4.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jButton4MouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        if(isMenuOpen) {
            closeMenuBar();
            isMenuOpen = false;
            jLabel9.setVisible(true);
        }
        else {
            openMenuBar();
            isMenuOpen = true;
            jLabel9.setVisible(false);
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        closeMenuBar();
        isMenuOpen = false;
        jLabel9.setVisible(true);
    }//GEN-LAST:event_jButton4MouseClicked

    private void mainPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPageMouseClicked
        trangChu.setVisible(true);
        taiKhoan.setVisible(false);
        donhang.setVisible(false);
        chitietdonhang.setVisible(false);
    }//GEN-LAST:event_mainPageMouseClicked

    private void accountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountMouseClicked
        trangChu.setVisible(false);
        taiKhoan.setVisible(true);
        donhang.setVisible(false);
        chitietdonhang.setVisible(false);
    }//GEN-LAST:event_accountMouseClicked

    private void mainPageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPageMouseEntered
        mainPage.setBackground(new Color(232, 17, 35));
    }//GEN-LAST:event_mainPageMouseEntered

    private void mainPageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPageMouseExited
        mainPage.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_mainPageMouseExited

    private void accountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountMouseEntered
        account.setBackground(new Color(232, 17, 35));
    }//GEN-LAST:event_accountMouseEntered

    private void orderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderMouseEntered
        order.setBackground(new Color(232, 17, 35));
    }//GEN-LAST:event_orderMouseEntered

    private void cart_lblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cart_lblMouseEntered
        cart_lbl.setBackground(new Color(232, 17, 35));
    }//GEN-LAST:event_cart_lblMouseEntered

    private void thongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thongKeMouseEntered
        thongKe.setBackground(new Color(232, 17, 35));
    }//GEN-LAST:event_thongKeMouseEntered

    private void accountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountMouseExited
       account.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_accountMouseExited

    private void orderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderMouseExited
        order.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_orderMouseExited

    private void cart_lblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cart_lblMouseExited
        cart_lbl.setBackground(new Color(255, 255, 255));

    }//GEN-LAST:event_cart_lblMouseExited

    private void thongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thongKeMouseExited
        thongKe.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_thongKeMouseExited

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        repairInformation repair = new repairInformation(this, true, jLabel12.getText(), jLabel13.getText(), jLabel14.getText());
        repair.setVisible(true);
        
        if (repair.isSaved()) {
            jLabel12.setText(repair.getName());
            jLabel13.setText(repair.getPhone());
            jLabel14.setText(repair.getAddress());
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderMouseClicked
        trangChu.setVisible(false);
        taiKhoan.setVisible(false);
        donhang.setVisible(true);
        chitietdonhang.setVisible(false);
        
    }//GEN-LAST:event_orderMouseClicked

    private void cart_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cart_lblMouseClicked
        cart cartOpen = new cart();
        cartOpen.setVisible(true);
    }//GEN-LAST:event_cart_lblMouseClicked

    // Phương thức mở menu
    void openMenuBar() {
    // Sử dụng phương thức đa luồng trong java
    new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < width ;i++){
                sidemenu.setPreferredSize(new Dimension(i, sidemenu.getHeight()));
                sidemenu.revalidate();
                sidemenu.repaint();
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();
}
    
    //Phương thức đóng menu
    void closeMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i > 0; i--){
                    sidemenu.setPreferredSize(new Dimension(i, sidemenu.getHeight()));
                    sidemenu.revalidate();
                    sidemenu.repaint();
                    try {
                    Thread.sleep(1);
                    }
                catch (InterruptedException e) {
                    e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * @param args the command line arguments
     */
    
            private void loadOrderList() {
        // Dữ liệu mô phỏng
        String[][] orders = {
            {"#001", "Nguyễn Văn A", "2025-10-27", "Delivered", "1.200.000"},
            {"#002", "Trần Thị B",  "2025-10-25", "Pending",   "2.000.000"},
            {"#003", "Lê Văn C",    "2025-10-24", "Cancelled", "950.000"},
            {"#004", "Phạm D",      "2025-10-20", "Shipped",   "1.100.000"},
            {"#005", "Hoàng E",     "2025-10-18", "Pending",   "1.450.000"},
            {"#006", "Bùi F",       "2025-10-15", "Delivered", "850.000"}
        };
        for (String[] o : orders) {
            orderitem item = new orderitem(this);
            item.setOrderData(o[0], o[1], o[2], o[3], o[4]);

            // Kéo full ngang + padding đẹp
            item.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 50));
            item.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));

            ListOrder.add(item);
            ListOrder.add(Box.createVerticalStrut(0)); // khoảng cách giữa các dòng
        }

        ListOrder.revalidate();
        ListOrder.repaint();
    }

    private void loadDetailOrderList() {
//        String[][] details = {
//            {"P-001", "Giày Nike Air", "600.000", "1", "600.000", "/asset/picture/product/AYTT001-2.jpg"},
//            {"P-002", "Vớ thể thao", "50.000", "2", "100.000", "/asset/picture/product/AYTT001-2.jpg"},
//            {"P-003", "Dây giày", "30.000", "1", "30.000", "/asset/picture/product/AYTT001-2.jpg"},
//            {"P-004", "Balo thể thao", "450.000", "1", "450.000", "/asset/picture/product/AYTT001-2.jpg"}
//        };
        String[][] details = {
            {"P-001", "/asset/picture/product/AYTT001-2.jpg", "Giày Nike Air", "600.000", "1"}, 
            {"P-002", "/asset/picture/product/AYTT001-2.jpg", "Vớ thể thao", "50.000", "2"},
            {"P-003", "/asset/picture/product/AYTT001-2.jpg", "Dây giày", "30.000", "1"},
            {"P-004", "/asset/picture/product/AYTT001-2.jpg", "Balo thể thao", "450.000", "1"}
        };

        ListChiTietOrder.removeAll();

        for (String[] d : details) {
            orderitem item = new orderitem(this);

            // Gán dữ liệu 5 cột chính
            item.setDetailOrderData(d[0], d[1], d[2], d[3], d[4]);

            item.hideActionButtons();

            item.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 50));
            item.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));

            ListChiTietOrder.add(item);
            ListChiTietOrder.add(Box.createVerticalStrut(0));
        }

        ListChiTietOrder.revalidate();
        ListChiTietOrder.repaint();
    }

       
       public void showChiTietDonHang() {
    trangChu.setVisible(false);
    taiKhoan.setVisible(false);
    donhang.setVisible(false);
    chitietdonhang.setVisible(true);
    }     
            
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainPage().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ListChiTietOrder;
    private javax.swing.JPanel ListOrder;
    private javax.swing.JLabel account;
    private javax.swing.JLabel cart_lbl;
    private javax.swing.JPanel chitietdonhang;
    private javax.swing.JPanel donhang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel listsanpham;
    private javax.swing.JPanel logo;
    private javax.swing.JLabel mainPage;
    private javax.swing.JLabel order;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlProducts;
    private javax.swing.JPanel sidemenu;
    private javax.swing.JPanel taiKhoan;
    private javax.swing.JLabel thongKe;
    private javax.swing.JPanel trangChu;
    // End of variables declaration//GEN-END:variables
}
