package script;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.border.EmptyBorder;


public class thanhtoan extends JFrame {

    public thanhtoan() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Thông tin giao hàng - Jimmy’s Shoes");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelMain = new JPanel(new BorderLayout());
        panelMain.setBackground(Color.WHITE);
        panelMain.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblTitle = new JLabel("Thanh toán đơn hàng", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setBorder(new EmptyBorder(10, 0, 30, 0));
        panelMain.add(lblTitle, BorderLayout.NORTH);

        JPanel panelCenter = new JPanel(new GridLayout(1, 2, 40, 0));
        panelCenter.setBackground(Color.WHITE);

      
        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.setBackground(Color.WHITE);

        //JLabel lblDiaChiShop = new JLabel("Địa chỉ shop");
       // JTextField txtDiaChiShop = new JTextField("TP. Hồ Chí Minh");
        JLabel lblHoTen = new JLabel("Họ và Tên");
        JTextField txtHoTen = new JTextField("Trần Ngọc Phương Nhi");
        JLabel lblSDT = new JLabel("Số điện thoại");
        JTextField txtSDT = new JTextField("0968798030");

        JLabel lblGiaoHang = new JLabel("Giao hàng");
        JRadioButton rdGiaoTanNoi = new JRadioButton("Giao hàng tận nơi", true);
        JRadioButton rdNhanTaiShop = new JRadioButton("Nhận tại cửa hàng");
        ButtonGroup groupGiaoHang = new ButtonGroup();
        groupGiaoHang.add(rdGiaoTanNoi);
        groupGiaoHang.add(rdNhanTaiShop);

        JLabel lblDiaChi = new JLabel("Địa chỉ");
        JTextField txtDiaChi = new JTextField("24/3 ấp 7 Xã XTT Huyện HM");
        JLabel lblEmail = new JLabel("Email");
        JTextField txtEmail = new JTextField("thaonhi.77787@gmail.com");

        JLabel lblPhuongThuc = new JLabel("Phương thức thanh toán");
        JRadioButton rdTienMat = new JRadioButton("Tiền mặt khi nhận hàng (COD)", true);
        JRadioButton rdThe = new JRadioButton("Thanh toán bằng thẻ");
        ButtonGroup groupThanhToan = new ButtonGroup();
        groupThanhToan.add(rdTienMat);
        groupThanhToan.add(rdThe);

        Font fontLabel = new Font("Segoe UI", Font.BOLD, 14);
        for (JLabel lbl : new JLabel[]{ lblHoTen, lblSDT, lblGiaoHang, lblDiaChi, lblEmail, lblPhuongThuc}) {
            lbl.setFont(fontLabel);
        }

       // panelLeft.add(lblDiaChiShop); panelLeft.add(txtDiaChiShop);
       // panelLeft.add(Box.createVerticalStrut(10));
        panelLeft.add(lblHoTen); panelLeft.add(txtHoTen);
        panelLeft.add(Box.createVerticalStrut(10));
        panelLeft.add(lblSDT); panelLeft.add(txtSDT);
        panelLeft.add(Box.createVerticalStrut(10));
        panelLeft.add(lblGiaoHang); panelLeft.add(rdGiaoTanNoi); panelLeft.add(rdNhanTaiShop);
        panelLeft.add(Box.createVerticalStrut(10));
        panelLeft.add(lblDiaChi); panelLeft.add(txtDiaChi);
        panelLeft.add(Box.createVerticalStrut(10));
        panelLeft.add(lblEmail); panelLeft.add(txtEmail);
        panelLeft.add(Box.createVerticalStrut(10));
        panelLeft.add(lblPhuongThuc); panelLeft.add(rdTienMat); panelLeft.add(rdThe);

       
        JPanel panelRight = new JPanel();
        panelRight.setBackground(Color.WHITE);
        panelRight.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.setPreferredSize(new Dimension(400, 0));

        JLabel lblTomTat = new JLabel("Tóm tắt đơn hàng");
        lblTomTat.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTomTat.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTomTat.setBorder(new EmptyBorder(10, 0, 15, 0));
        panelRight.add(lblTomTat);

        // ========== DANH SÁCH 2 SẢN PHẨM ==========
        panelRight.add(createSanPhamPanel("Giày thể thao vàng", "1.699.000₫", "1", "/asset/picture/product/giay6.jpg"));
        panelRight.add(Box.createVerticalStrut(30));
        panelRight.add(createSanPhamPanel("Giày thể thao trắng xanh", "2.199.000₫", "2", "/asset/picture/product/giaychinh.jpg"));

        // ========== TỔNG TIỀN ==========
        JLabel lblTong = new JLabel("Tổng tiền: 5.997.000₫");
        lblTong.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblTong.setForeground(new Color(150, 0, 0));
        lblTong.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTong.setBorder(new EmptyBorder(30, 0, 15, 0));

     
        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panelButtons.setBackground(Color.WHITE);

        JButton btnBack = new JButton("Quay lại giỏ hàng");
        JButton btnHoanTat = new JButton("Hoàn tất đơn hàng");
        btnBack.setBackground(Color.GRAY);
        btnBack.setForeground(Color.WHITE);
        btnHoanTat.setBackground(new Color(128, 0, 0));
        btnHoanTat.setForeground(Color.WHITE);
        btnBack.setFocusPainted(false);
        btnHoanTat.setFocusPainted(false);

        btnHoanTat.addActionListener(e -> {
            String phuongThuc = rdTienMat.isSelected() ? "Tiền mặt khi nhận hàng (COD)" : "Thanh toán bằng thẻ";
            JOptionPane.showMessageDialog(this,
                    "Cảm ơn bạn, đơn hàng đã được xác nhận!\nPhương thức thanh toán: " + phuongThuc,
                    "Xác nhận", JOptionPane.INFORMATION_MESSAGE);
        });

        panelButtons.add(btnBack);
        panelButtons.add(btnHoanTat);

        panelRight.add(lblTong);
        panelRight.add(panelButtons);
        panelRight.add(Box.createVerticalGlue());

        panelCenter.add(panelLeft);
        panelCenter.add(panelRight);
        panelMain.add(panelCenter, BorderLayout.CENTER);

        add(panelMain);
    }

    private JPanel createSanPhamPanel(String ten, String gia, String soLuong, String imgPath) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panel.setBackground(Color.WHITE);

        JLabel lblAnh = new JLabel();
        lblAnh.setPreferredSize(new Dimension(130, 100));
        try {
            ImageIcon img = new ImageIcon(getClass().getResource(imgPath));
            Image scaled = img.getImage().getScaledInstance(130, 100, Image.SCALE_SMOOTH);
            lblAnh.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            lblAnh.setText("[Ảnh]");
            lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
        }

        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.WHITE);
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));

        JLabel lblTen = new JLabel(ten);
        lblTen.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JLabel lblGia = new JLabel("Giá: " + gia);
        lblGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel lblSL = new JLabel("Số lượng: " + soLuong);
        lblSL.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        panelInfo.add(lblTen);
        panelInfo.add(lblGia);
        panelInfo.add(lblSL);

        panel.add(lblAnh);
        panel.add(panelInfo);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new thanhtoan().setVisible(true));
    }
}//a
