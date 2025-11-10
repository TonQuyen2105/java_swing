package myapp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.lang.model.SourceVersion;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
public class chitiet1 extends javax.swing.JFrame {

    public chitiet1() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chi tiết sản phẩm - Jimmy’s Shoes");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(new GridLayout(5, 1, 10, 10));
        String[] images = {"giay2.jpg","giay2.jpg","giay2.jpg","giay2.jpg","giay2.jpg"};

        JLabel lblMainImage = new JLabel();
        lblMainImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblMainImage.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        lblMainImage.setPreferredSize(new Dimension(400, 400));

        for (String imgName : images) {
            JLabel lbl = new JLabel();
            lbl.setHorizontalAlignment(SwingConstants.CENTER);
            lbl.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            lbl.setPreferredSize(new Dimension(80, 80));
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource("/HINHANH/" + imgName));
                Image img = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
                lbl.setIcon(new ImageIcon(img));
            } catch (Exception e) {
                lbl.setText("Ảnh");
            }

            lbl.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    lblMainImage.setIcon(lbl.getIcon());
                }
            });
            leftPanel.add(lbl);
        }

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(lblMainImage, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JLabel lblTen = new JLabel("Nike Zoom Vomero 5 SE");
        lblTen.setFont(new Font("Segoe UI", Font.BOLD, 22));

        JLabel lblMoTaNgan = new JLabel("Sport / Brown White Blue");
        lblMoTaNgan.setForeground(Color.GRAY);
        lblMoTaNgan.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel lblGia = new JLabel("4.999.000₫");
        lblGia.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblGia.setForeground(new Color(153, 0, 0));

        JPanel sizePanel = new JPanel();
        sizePanel.setBackground(Color.WHITE);
        String[] sizes = {"37", "38", "39", "40"};
        for (String s : sizes) {
            JButton btn = new JButton(s);
            btn.setFocusPainted(false);
            btn.setBackground(Color.WHITE);
            btn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            btn.addActionListener(evt -> JOptionPane.showMessageDialog(this, "Đã chọn size: " + s));
            sizePanel.add(btn);
        }

        JButton btnThem = new JButton("Thêm vào giỏ hàng");
        btnThem.setBackground(new Color(153, 0, 0));
        btnThem.setForeground(Color.WHITE);
        btnThem.setFocusPainted(false);
        btnThem.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnThem.addActionListener(evt -> JOptionPane.showMessageDialog(this, "Đã thêm vào giỏ hàng!"));

        JLabel lblMoTa = new JLabel("Mô tả sản phẩm");
        lblMoTa.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JTextArea txtMoTa = new JTextArea("Chất liệu: 50% Viscose, 22% Nylon, 28% PBT.\n"
                + "Zoom Vomero 5 là lựa chọn hoàn hảo cho sự tinh tế và dễ phối đồ.\n"
                + "Thiết kế nhiều lớp phong phú với chi tiết vải, da và nhựa, mang phong cách hiện đại.");
        txtMoTa.setEditable(false);
        txtMoTa.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtMoTa.setLineWrap(true);
        txtMoTa.setWrapStyleWord(true);
        txtMoTa.setBorder(null);

        rightPanel.add(lblTen);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(lblMoTaNgan);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(lblGia);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(sizePanel);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(btnThem);
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(lblMoTa);
        rightPanel.add(Box.createVerticalStrut(5));
        rightPanel.add(txtMoTa);

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        add(mainPanel, BorderLayout.CENTER);

        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/HINHANH/giay2.jpg"));
            Image img = icon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            lblMainImage.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            lblMainImage.setText("Không tìm thấy ảnh");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new chitiet1().setVisible(true));
    }
}

