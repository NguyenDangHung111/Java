package Views;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComponent;

public class View_Login extends JFrame {
	private JTextField TF_Account;
	private JPasswordField TF_Password;
	private  JButton BT_Login;
	private JButton BT_Logout;
	
    public View_Login() {
    	setTitle("ĐĂNG NHẬP");
    	getContentPane().setBackground(new Color(30, 144, 255));
        getContentPane().setLayout(null);
        setVisible(true);
        setSize(817,558);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 144, 255));
        panel.setBounds(0, 0, 802, 521);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        
        BT_Logout = new JButton("THOÁT");
        BT_Logout.setForeground(new Color(240, 255, 240));
        BT_Logout.setFont(new Font("Tahoma", Font.BOLD, 15));
        BT_Logout.setBackground(new Color(30, 144, 255));
        BT_Logout.setBounds(521, 423, 164, 41);
        panel.add(BT_Logout);
        BT_Logout.setBorder(null);
        BT_Logout.setBorder(BorderFactory.createEmptyBorder());
        BT_Logout.setUI(new BasicButtonUI() {
			@Override
			public void paint(Graphics g, JComponent c) {
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				AbstractButton b = (AbstractButton) c;
				ButtonModel model = b.getModel();
				int width = b.getWidth();
				int height = b.getHeight();
				int arcSize = 40; // Đặt kích thước cong viền ở đây (5px)
				if (model.isArmed()) {
					g2d.setColor(Color.lightGray);
				} else {
					g2d.setColor(b.getBackground());
				}
				g2d.fillRoundRect(0, 0, width - 1, height - 1, arcSize, arcSize);
				g2d.setColor(b.getForeground());
				g2d.drawRoundRect(0, 0, width - 1, height - 1, arcSize, arcSize);
				FontMetrics fm = g2d.getFontMetrics();
				Rectangle textRect = new Rectangle(width, height);
				String text = SwingUtilities.layoutCompoundLabel(b, fm, b.getText(), null, // No icon
						b.getVerticalAlignment(), b.getHorizontalAlignment(), b.getVerticalTextPosition(),
						b.getHorizontalTextPosition(), textRect, new Rectangle(), textRect, 0);
				int textX = (width - fm.stringWidth(text)) / 2; // Tính toán vị trí ngang của văn bản
				int textY = (height - fm.getHeight()) / 2 + fm.getAscent(); // Tính toán vị trí dọc của văn bản
				g2d.setColor(b.getForeground());
				g2d.setFont(b.getFont());
				g2d.drawString(text, textX, textY);
				g2d.dispose();
			}
		});
        
        JLabel lblNewLabel = new JLabel("\r\n");
        lblNewLabel.setBounds(54, 154, 212, 209);
        panel.add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon(View_Login.class.getResource("/Images/logo.png")));
        
        JLabel lblNewLabel_1 = new JLabel("ĐĂNG NHẬP");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_1.setBounds(537, 101, 164, 35);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("TÀI KHOẢN\r\n");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(324, 196, 131, 22);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("MẬT KHẨU\r\n");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_1.setBounds(324, 284, 112, 22);
        panel.add(lblNewLabel_2_1);
        
        TF_Account = new JTextField();
        TF_Account.setBounds(465, 193, 314, 35);
        panel.add(TF_Account);
        TF_Account.setColumns(10);
        
        TF_Password = new JPasswordField();
        TF_Password.setBounds(465, 281, 314, 35);
        panel.add(TF_Password);
        
         BT_Login = new JButton("ĐĂNG NHẬP");
         BT_Login.setFont(new Font("Tahoma", Font.BOLD, 15));
         BT_Login.setForeground(new Color(240, 255, 255));
         BT_Login.setBackground(new Color(30, 144, 255));
         BT_Login.setBounds(521, 359, 164, 35);
        panel.add( BT_Login);
        BT_Login.setBorder(null);
        BT_Login.setBorder(BorderFactory.createEmptyBorder());
        BT_Login.setUI(new BasicButtonUI() {
			@Override
			public void paint(Graphics g, JComponent c) {
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				AbstractButton b = (AbstractButton) c;
				ButtonModel model = b.getModel();
				int width = b.getWidth();
				int height = b.getHeight();
				int arcSize = 40; // Đặt kích thước cong viền ở đây (5px)
				if (model.isArmed()) {
					g2d.setColor(Color.lightGray);
				} else {
					g2d.setColor(b.getBackground());
				}
				g2d.fillRoundRect(0, 0, width - 1, height - 1, arcSize, arcSize);
				g2d.setColor(b.getForeground());
				g2d.drawRoundRect(0, 0, width - 1, height - 1, arcSize, arcSize);
				FontMetrics fm = g2d.getFontMetrics();
				Rectangle textRect = new Rectangle(width, height);
				String text = SwingUtilities.layoutCompoundLabel(b, fm, b.getText(), null, // No icon
						b.getVerticalAlignment(), b.getHorizontalAlignment(), b.getVerticalTextPosition(),
						b.getHorizontalTextPosition(), textRect, new Rectangle(), textRect, 0);
				int textX = (width - fm.stringWidth(text)) / 2; // Tính toán vị trí ngang của văn bản
				int textY = (height - fm.getHeight()) / 2 + fm.getAscent(); // Tính toán vị trí dọc của văn bản
				g2d.setColor(b.getForeground());
				g2d.setFont(b.getFont());
				g2d.drawString(text, textX, textY);
				g2d.dispose();
			}
		});
       
    }
	public JButton getBT_Login() {
		return BT_Login;
	}
	public void setBT_Login(JButton bT_Login) {
		BT_Login = bT_Login;
	}
	public JButton getBT_Logout() {
		return BT_Logout;
	}
	public void setBT_Logout(JButton bT_Logout) {
		BT_Logout = bT_Logout;
	}
	public JTextField getTF_Account() {
		return TF_Account;
	}
	public void setTF_Account(JTextField tF_Account) {
		TF_Account = tF_Account;
	}
	public JPasswordField getTF_Password() {
		return TF_Password;
	}
	public void setTF_Password(JPasswordField tF_Password) {
		TF_Password = tF_Password;
	}
}
