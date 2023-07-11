package Views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import java.awt.BorderLayout;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.io.File;
import java.awt.Font;

public class View_Game_Over extends JFrame{
	
	private JButton BT_GiaiThuong;
    private Clip clip;

	public View_Game_Over() {
		setTitle("GAME OVER");
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(1206,686);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		BT_GiaiThuong = new JButton("Giai Thuong");
		BT_GiaiThuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		BT_GiaiThuong.setForeground(Color.WHITE);
		BT_GiaiThuong.setBackground(new Color(0, 153, 255));
		BT_GiaiThuong.setBounds(509, 392, 195, 47);
		BT_GiaiThuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		BT_GiaiThuong.setContentAreaFilled(false);
		BT_GiaiThuong.setBorder(BorderFactory.createEmptyBorder());
		BT_GiaiThuong.setUI(new BasicButtonUI() {
			@Override
			public void paint(Graphics g, JComponent c) {
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				AbstractButton b = (AbstractButton) c;
				ButtonModel model = b.getModel();
				int width = b.getWidth();
				int height = b.getHeight();
				int arcSize = 50; // Đặt kích thước cong viền ở đây (5px)
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
		getContentPane().add(BT_GiaiThuong);

		
		JLabel lblNewLabel_1 = new JLabel("GIẢI THƯỞNG");
		lblNewLabel_1.setForeground(new Color(102, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(520, 331, 184, 47);
		getContentPane().add(lblNewLabel_1);
		
		JLabel LB_Background = new JLabel("");
		LB_Background.setIcon(new ImageIcon(View_Game_Over.class.getResource("/Images/background.png")));
		LB_Background.setBounds(0, 0, 1247, 663);
		getContentPane().add(LB_Background);
		
	}

	public void Sound_Over2(int number) {		 
		if(number >= 7) {
			try {
	            File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/gameover.wav");
	            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	            clip = AudioSystem.getClip();
	            clip.open(audioIn);
	            clip.start();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		}else {
			try {
	            File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/gameover2.wav");
	            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	            clip = AudioSystem.getClip();
	            clip.open(audioIn);
	            clip.start();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		}
}
	
	public Clip getClip() {
		return clip;
	}

	public void setClip(Clip clip) {
		this.clip = clip;
	}
	
	public JButton getBT_GiaiThuong() {
		return BT_GiaiThuong;
	}

	public void setBT_GiaiThuong(JButton bT_GiaiThuong) {
		BT_GiaiThuong = bT_GiaiThuong;
	}
}
