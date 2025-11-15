package script;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


public class chitiet1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private int soLuong = 1;
    private double giaSanPham = 4999000;
    private JLabel lblTongTien;

    public chitiet1() throws SQLException {
        initComponents();
        connectionDB conn = new connectionDB();
        conn.getConnection();
    }

    private void initComponents() throws SQLException {
      
       
        setTitle("Chi tiết sản phẩm - Jimmy’s Shoes");
        setSize(1150, 750);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelMain = new JPanel(new BorderLayout());
        panelMain.setBackground(Color.WHITE);

      
        JLabel lblTen = new JLabel("Nike Zoom Vomero 5 SE", SwingConstants.CENTER);
        lblTen.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTen.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        panelMain.add(lblTen, BorderLayout.NORTH);

        JPanel panelThumbs = new JPanel(new GridLayout(5, 1, 10, 10));
        panelThumbs.setBackground(Color.WHITE);
        panelThumbs.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 10));

        String[] hinhAnh = {"giay1.jpg", "giay2.jpg", "giay3.jpg", "giay4.jpg", "giay5.jpg"};

        JLabel lblAnhChinh = new JLabel();
        lblAnhChinh.setHorizontalAlignment(SwingConstants.CENTER);
        lblAnhChinh.setPreferredSize(new Dimension(350, 350));
        lblAnhChinh.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        for (String file : hinhAnh) {
            JLabel thumb = new JLabel();
            thumb.setHorizontalAlignment(SwingConstants.CENTER);
            thumb.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            thumb.setPreferredSize(new Dimension(80, 80));

            try {
                ImageIcon img = new ImageIcon(getClass().getResource("/asset/picture/product/" + file));
                Image scaled = img.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
                thumb.setIcon(new ImageIcon(scaled));
            } catch (Exception e) {
                thumb.setText("Ảnh");
            }

            thumb.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        ImageIcon img = new ImageIcon(getClass().getResource("/asset/picture/product/" + file));
                        Image scaled = img.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
                        lblAnhChinh.setIcon(new ImageIcon(scaled));
                    } catch (Exception ex) {
                        lblAnhChinh.setText("Không tìm thấy ảnh");
                    }
                }
            });

            panelThumbs.add(thumb);
        }

        JPanel panelImage = new JPanel(new BorderLayout());
        panelImage.setBackground(Color.WHITE);
        panelImage.add(lblAnhChinh, BorderLayout.CENTER);

        // Panel thông tin sản phẩm 
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.WHITE);
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 30));
        panelInfo.setMaximumSize(new Dimension(480, 580));

        // Loại và giá
        JPanel panelLoaiGia = new JPanel(new BorderLayout());
        panelLoaiGia.setBackground(Color.WHITE);

        JLabel lblLoai = new JLabel("Sport / Brown White Blue");
        lblLoai.setForeground(Color.GRAY);
        lblLoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel lblGia = new JLabel("4.999.000₫");
        lblGia.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblGia.setForeground(new Color(153, 0, 0));
        lblGia.setHorizontalAlignment(SwingConstants.RIGHT);

        panelLoaiGia.add(lblLoai, BorderLayout.WEST);
        panelLoaiGia.add(lblGia, BorderLayout.EAST);

        // Kích thước
        JPanel panelKichThuoc = new JPanel(new FlowLayout(FlowLayout.LEFT, 9, 4));
        panelKichThuoc.setBackground(Color.WHITE);
        JLabel lblKichThuoc = new JLabel("Kích thước:");
        lblKichThuoc.setFont(new Font("Segoe UI", Font.BOLD, 15));
        panelKichThuoc.add(lblKichThuoc);

        String[] sizes = {"37", "38", "39", "40"};
        for (String s : sizes) {
            JButton btn = new JButton(s);
            btn.setFocusPainted(false);
            btn.setBackground(Color.WHITE);
            btn.setPreferredSize(new Dimension(40, 25));
            btn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            btn.addActionListener(evt -> JOptionPane.showMessageDialog(this, "Đã chọn size: " + s));
            panelKichThuoc.add(btn);
        }

        // Màu sắc
        JPanel panelMau = new JPanel(new FlowLayout(FlowLayout.LEFT, 9, 4));
        panelMau.setBackground(Color.WHITE);
        JLabel lblMau = new JLabel("Màu sắc:");
        lblMau.setFont(new Font("Segoe UI", Font.BOLD, 15));
        panelMau.add(lblMau);

        ButtonGroup groupMau = new ButtonGroup();
        String[] mau = {"Trắng", "Đen", "Xanh", "Đỏ"};
        for (String m : mau) {
            JRadioButton btn = new JRadioButton(m);
            btn.setBackground(Color.WHITE);
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            groupMau.add(btn);
            panelMau.add(btn);
        }

        // Số lượng
        JPanel panelSoLuong = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelSoLuong.setBackground(Color.WHITE);
        JLabel lblSoLuong = new JLabel("Số lượng:");
        lblSoLuong.setFont(new Font("Segoe UI", Font.BOLD, 15));
        panelSoLuong.add(lblSoLuong);

        JButton btnGiam = new JButton("-");
        JButton btnTang = new JButton("+");
        JTextField txtSoLuong = new JTextField("1", 2);
        txtSoLuong.setHorizontalAlignment(JTextField.CENTER);
        txtSoLuong.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtSoLuong.setEditable(false);

       btnGiam.setFont(new Font("Arial", Font.BOLD, 16));
       btnTang.setFont(new Font("Arial", Font.BOLD, 16)); 
       btnGiam.setFocusPainted(false);
       btnTang.setFocusPainted(false);
       btnGiam.setMargin(new Insets(0, 0, 0, 0));
       btnTang.setMargin(new Insets(0, 0, 0, 0));
       btnGiam.setPreferredSize(new Dimension(32, 26));
       btnTang.setPreferredSize(new Dimension(32, 26));


        lblTongTien = new JLabel("Tổng tiền: " + String.format("%,.0f₫", giaSanPham));
        lblTongTien.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblTongTien.setForeground(new Color(0, 128, 0));

        btnGiam.addActionListener(e -> {
            if (soLuong > 1) {
                soLuong--;
                txtSoLuong.setText(String.valueOf(soLuong));
                capNhatTongTien();
            }
        });
        btnTang.addActionListener(e -> {
            soLuong++;
            txtSoLuong.setText(String.valueOf(soLuong));
            capNhatTongTien();
        });

        panelSoLuong.add(btnGiam);
        panelSoLuong.add(txtSoLuong);
        panelSoLuong.add(btnTang);
        panelSoLuong.add(Box.createHorizontalStrut(15));
        panelSoLuong.add(lblTongTien);

       
        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panelButtons.setBackground(Color.WHITE);

        JButton btnAdd = new JButton("Thêm vào giỏ hàng");
        btnAdd.setBackground(new Color(153, 0, 0));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFocusPainted(false);
        btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnAdd.setPreferredSize(new Dimension(180, 25));

        JButton btnDatHang = new JButton("Đặt hàng");
        btnDatHang.setBackground(Color.GRAY);
        btnDatHang.setForeground(Color.WHITE);
        btnDatHang.setFocusPainted(false);
        btnDatHang.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnDatHang.setPreferredSize(new Dimension(180, 25));

        btnAdd.addActionListener(evt -> {
        JOptionPane.showMessageDialog(chitiet1.this, "Đã thêm " + soLuong + " sản phẩm vào giỏ hàng!");
        cart c = new cart(); 
        c.setVisible(true);
        dispose(); 
         });


        

        btnDatHang.addActionListener(evt ->
                JOptionPane.showMessageDialog(chitiet1.this, "Bạn đã chọn đặt hàng " + soLuong + " sản phẩm!")
        );

        panelButtons.add(btnAdd);
        panelButtons.add(btnDatHang);

        // Mô tả sản phẩm
        JLabel lblMoTa = new JLabel("Mô tả sản phẩm");
        lblMoTa.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblMoTa.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea txtMoTa = new JTextArea("""
                Giày cầu lông luyện tập Li-Ning AYTU025-1 – Bền bỉ, nhẹ nhàng, thoải mái mỗi bước di chuyển.
                Chất liệu: Phần upper: Dệt + Da tổng hợp / Đế: Cao su + EVA.
                Thiết kế: Mũi giày hơi cong, đường khâu gọn gàng.
                Xuất xứ: Trung Quốc.
                Đối tượng: Người chơi cầu lông tập luyện hàng ngày.
               
                """);
        txtMoTa.setEditable(false);
        txtMoTa.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtMoTa.setLineWrap(true);
        txtMoTa.setWrapStyleWord(true);
        txtMoTa.setBackground(Color.WHITE);
        txtMoTa.setBorder(BorderFactory.createEmptyBorder());

        // Thêm vào panel info
        panelInfo.add(panelLoaiGia);
        panelInfo.add(Box.createVerticalStrut(20));
        panelInfo.add(panelKichThuoc);
        panelInfo.add(Box.createVerticalStrut(10));
        panelInfo.add(panelMau);
        panelInfo.add(Box.createVerticalStrut(10));
        panelInfo.add(panelSoLuong);
        panelInfo.add(Box.createVerticalStrut(15));
        panelInfo.add(panelButtons);
        panelInfo.add(Box.createVerticalStrut(25));
        panelInfo.add(lblMoTa);
        panelInfo.add(Box.createVerticalStrut(5));
        panelInfo.add(txtMoTa);

        // ===== Gộp ảnh + thông tin =====
        JPanel panelImageAndInfo = new JPanel();
        panelImageAndInfo.setLayout(new BoxLayout(panelImageAndInfo, BoxLayout.X_AXIS));
        panelImageAndInfo.setBackground(Color.WHITE);
        panelImageAndInfo.add(panelImage);
        panelImageAndInfo.add(Box.createRigidArea(new Dimension(30, 0)));
        panelImageAndInfo.add(panelInfo);

        panelMain.add(panelThumbs, BorderLayout.WEST);
        panelMain.add(panelImageAndInfo, BorderLayout.CENTER);
        add(panelMain, BorderLayout.CENTER);

        //  Sản phẩm liên quan 
        JPanel panelLienQuan = new JPanel();
        panelLienQuan.setLayout(new BoxLayout(panelLienQuan, BoxLayout.Y_AXIS));
        panelLienQuan.setBackground(Color.WHITE);
        panelLienQuan.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel lblLienQuan = new JLabel("Sản phẩm liên quan", SwingConstants.CENTER);
        lblLienQuan.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblLienQuan.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelSP = new JPanel(new GridLayout(1, 4, 15, 8));
        panelSP.setBackground(Color.WHITE);

        String[][] sanpham = {
                {"giay7.jpg", "Giày Nike Air Zoom", "3.499.000₫"},
                {"giay8.jpg", "Giày Adidas Ultraboost", "4.299.000₫"},
                {"giay9.jpg", "Giày Puma RS-X", "2.999.000₫"},
                {"giay10.jpg", "Giày Converse Run Star", "2.499.000₫"}
        };

        for (String[] sp : sanpham) {
            JPanel item = new JPanel();
            item.setLayout(new BoxLayout(item, BoxLayout.Y_AXIS));
            item.setBackground(Color.WHITE);
            item.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            JLabel img = new JLabel();
            img.setAlignmentX(Component.CENTER_ALIGNMENT);
            img.setHorizontalAlignment(SwingConstants.CENTER);
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource("/asset/picture/product/" + sp[0]));
                Image scaled = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                img.setIcon(new ImageIcon(scaled));
            } catch (Exception e) {
                img.setText("Ảnh");
            }

            JLabel name = new JLabel(sp[1], SwingConstants.CENTER);
            name.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            name.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel price = new JLabel(sp[2], SwingConstants.CENTER);
            price.setFont(new Font("Segoe UI", Font.BOLD, 14));
            price.setForeground(new Color(153, 0, 0));
            price.setAlignmentX(Component.CENTER_ALIGNMENT);

            item.add(Box.createVerticalStrut(10));
            item.add(img);
            item.add(Box.createVerticalStrut(10));
            item.add(name);
            item.add(price);

            panelSP.add(item);
        }

        panelLienQuan.add(lblLienQuan);
        panelLienQuan.add(Box.createVerticalStrut(20));
        panelLienQuan.add(panelSP);
        add(panelLienQuan, BorderLayout.SOUTH);

        try {
            ImageIcon img = new ImageIcon(getClass().getResource("/asset/picture/product/giaychinh.jpg"));
            Image scaled = img.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
            lblAnhChinh.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            lblAnhChinh.setText("Không tìm thấy ảnh");
        }
    }

    private void capNhatTongTien() {
        double tong = giaSanPham * soLuong;
        lblTongTien.setText("Tổng tiền: " + String.format("%,.0f₫", tong)); 
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new chitiet1().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(chitiet1.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
   
} 