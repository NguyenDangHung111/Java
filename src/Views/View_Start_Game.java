package Views;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;

public class View_Start_Game extends JFrame{

	private JButton BT_Start;
	private JButton BT_Exit;
	private Clip clip;
	
	public Clip getClip() {
		return clip;
	}

	public void setClip(Clip clip) {
		this.clip = clip;
	}

	public View_Start_Game () {
		setVisible(true);
		setTitle("Start Game");
		setSize(1207,676);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
			
		Nhac_Nen();
		
		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 204, 255));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// BT Play
		BT_Start = new JButton("BẮT ĐẦU");
		BT_Start.setForeground(new Color(255, 255, 255));
		BT_Start.setFont(new Font("Tahoma", Font.BOLD, 20));
		BT_Start.setBackground(new Color(51, 204, 102));
		BT_Start.setBounds(507, 416, 174, 68);
		BT_Start.setContentAreaFilled(false);
		BT_Start.setBorder(BorderFactory.createEmptyBorder());
		BT_Start.setUI(new BasicButtonUI() {
			@Override
			public void paint(Graphics g, JComponent c) {
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				AbstractButton b = (AbstractButton) c;
				ButtonModel model = b.getModel();
				int width = b.getWidth();
				int height = b.getHeight();
				int arcSize = 80; // Đặt kích thước cong viền ở đây (5px)
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
		contentPane.add(BT_Start);
		
		//BT Exit
		BT_Exit = new JButton("THOÁT");
		BT_Exit.setContentAreaFilled(false);
		BT_Exit.setBorder(BorderFactory.createEmptyBorder());
		BT_Exit.setUI(new BasicButtonUI() {
			@Override
			public void paint(Graphics g, JComponent c) {
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				AbstractButton b = (AbstractButton) c;
				ButtonModel model = b.getModel();
				int width = b.getWidth();
				int height = b.getHeight();
				int arcSize = 80; // Đặt kích thước cong viền ở đây (5px)
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
		BT_Exit.setBackground(new Color(204, 51, 51));
		BT_Exit.setFont(new Font("Tahoma", Font.BOLD, 20));
		BT_Exit.setForeground(new Color(255, 255, 255));
		BT_Exit.setBounds(507, 507, 174, 68);
		contentPane.add(BT_Exit);
		
		JLabel LB_Exit = new JLabel("");
		LB_Exit.setIcon(new ImageIcon(View_Start_Game.class.getResource("/Images/background.png")));
		LB_Exit.setBounds(0, -23, 1226, 686);
		contentPane.add(LB_Exit);
	}

	public void Nhac_Nen() {		 
			 try {
		            File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/Nhac_Nen.wav");
		            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
		            clip = AudioSystem.getClip();
		            clip.open(audioIn);
		            clip.loop(Clip.LOOP_CONTINUOUSLY);
		            clip.start();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
	}
	
	public JButton getBT_Start() {
		return BT_Start;
	}

	public void setBT_Start(JButton bT_Start) {
		BT_Start = bT_Start;
	}

	public JButton getBT_Exit() {
		return BT_Exit;
	}

	public void setBT_Exit(JButton bT_Exit) {
		BT_Exit = bT_Exit;
	}
}
