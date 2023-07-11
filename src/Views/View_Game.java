package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class View_Game extends JFrame {

	private JPanel contentPane;
	private JButton BT_Exit;
	private JButton BT_50_50;
	private JButton BT_Next;
	private JButton BT_Ratio;
	private JButton BT_A;
	private JButton BT_B;
	private JButton BT_C;
	private JButton BT_D;

	private JLabel LB_Money;
	private JLabel LB_Time;
	private JLabel LB_NumberOfQuestion;
	private JLabel LB_Question;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
    private JLabel lblIcon;
	
	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	public void setLblNewLabel_1(JLabel lblNewLabel_1) {
		this.lblNewLabel_1 = lblNewLabel_1;
	}

	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}

	public void setLblNewLabel_2(JLabel lblNewLabel_2) {
		this.lblNewLabel_2 = lblNewLabel_2;
	}

	public JLabel getLblIcon() {
		return lblIcon;
	}

	public void setLblIcon(JLabel lblIcon) {
		this.lblIcon = lblIcon;
	}

	public JButton getBT_Exit() {
		return BT_Exit;
	}

	public void setBT_Exit(JButton bT_Exit) {
		BT_Exit = bT_Exit;
	}

	public JButton getBT_50_50() {
		return BT_50_50;
	}

	public void setBT_50_50(JButton bT_50_50) {
		BT_50_50 = bT_50_50;
	}

	public JButton getBT_Next() {
		return BT_Next;
	}

	public void setBT_Next(JButton bT_Next) {
		BT_Next = bT_Next;
	}

	public JButton getBT_Ratio() {
		return BT_Ratio;
	}

	public void setBT_Ratio(JButton bT_Ratio) {
		BT_Ratio = bT_Ratio;
	}

	public JButton getA() {
		return BT_A;
	}

	public void setA(JButton a) {
		BT_A = a;
	}

	public JButton getB() {
		return BT_B;
	}

	public void setB(JButton b) {
		BT_B = b;
	}

	public JButton getC() {
		return BT_C;
	}

	public void setC(JButton c) {
		BT_C = c;
	}

	public JButton getD() {
		return BT_D;
	}

	public void setD(JButton d) {
		BT_D = d;
	}

	public JLabel getLB_Money() {
		return LB_Money;
	}

	public void setLB_Money(JLabel lB_Money) {
		LB_Money = lB_Money;
	}

	public JLabel getLB_Time() {
		return LB_Time;
	}

	public void setLB_Time(JLabel lB_Time) {
		LB_Time = lB_Time;
	}

	public JLabel getLB_NumberOfQuestion() {
		return LB_NumberOfQuestion;
	}

	public void setLB_NumberOfQuestion(JLabel lB_NumberOfQuestion) {
		LB_NumberOfQuestion = lB_NumberOfQuestion;
	}

	public JLabel getLB_Question() {
		return LB_Question;
	}

	public void setLB_Question(JLabel lB_Question) {
		LB_Question = lB_Question;
	}

	public View_Game() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 634);
		setSize(1088, 643);
		setTitle("Game");
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 255, 102));
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		BT_A = new JButton("A");
		BT_A.setForeground(new Color(255, 255, 255));
		BT_A.setBackground(new Color(102, 204, 255));
		BT_A.setBounds(115, 356, 337, 58);
		BT_A.setFont(new Font("Tahoma", Font.BOLD, 14));
		BT_A.setContentAreaFilled(false);
		BT_A.setBorder(BorderFactory.createEmptyBorder());
		BT_A.setUI(new BasicButtonUI() {
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
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(View_Game.class.getResource("/Images/out.png")));
		lblNewLabel_3.setBounds(980, 512, 52, 45);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D://Eclipse/AiLaTrieuPhu/src/Images/next.png"));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lblNewLabel_2.setBounds(999, 400, 33, 42);
		contentPane.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(15, 15); // Điều chỉnh độ cong ở đây
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Đổ màu nền
                graphics.setColor(new Color(255, 153, 102));
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

                // Vẽ viền
                graphics.setColor(Color.white);
                graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
            }
        };
        panel_1.setOpaque(false); // Vô hiệu hóa sự kiện đổ màu nền tự động của JPanel
		panel_1.setBackground(new Color(255, 153, 102));
		panel_1.setBounds(119, 66, 114, 42);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		LB_Money = new JLabel("0$");
		LB_Money.setHorizontalAlignment(JLabel.CENTER);
		LB_Money.setBounds(0, 0, 114, 42);
		panel_1.add(LB_Money);		
		LB_Money.setFont(new Font("Arial", Font.BOLD, 15));
		LB_Money.setForeground(new Color(255, 255, 255));

		JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(15, 15); // Điều chỉnh độ cong ở đây
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Đổ màu nền
                graphics.setColor(new Color(255, 153, 102));
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

                // Vẽ viền
                graphics.setColor(Color.white);
                graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
            }
        };
        panel.setOpaque(false); // Vô hiệu hóa sự kiện đổ màu nền tự động của JPanel
		panel.setBackground(new Color(255, 153, 102));
		panel.setBounds(29, 66, 65, 42);
		contentPane.add(panel_1);
		panel.setLayout(null);
		panel.setBackground(new Color(255, 153, 102));
		panel.setBounds(29, 66, 65, 42);
		contentPane.add(panel);
		panel.setLayout(null);

		LB_NumberOfQuestion = new JLabel("");
		LB_NumberOfQuestion.setBackground(new Color(0, 255, 102));
		LB_NumberOfQuestion.setBounds(0, 0, 65, 42);
		LB_NumberOfQuestion.setHorizontalAlignment(JLabel.CENTER);
		panel.add(LB_NumberOfQuestion);
		
		LB_NumberOfQuestion.setForeground(new Color(255, 255, 255));
		LB_NumberOfQuestion.setFont(new Font("Arial", Font.BOLD, 15));

		BT_Exit = new JButton("");
		BT_Exit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BT_Exit.setBackground(new Color(64, 224, 208));
		BT_Exit.setBounds(982, 515, 65, 42);
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
				int arcSize = 180; // Đặt kích thước cong viền ở đây (5px)
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
		contentPane.add(BT_Exit);

		lblIcon = new JLabel(new ImageIcon("D://Eclipse/AiLaTrieuPhu/src/Images/icon2.png"));
		lblIcon.setBounds(988, 460, 50, 45);
		contentPane.add(lblIcon);
		BT_Ratio = new JButton("");
		BT_Ratio.setBounds(982, 460, 65, 45);
		BT_Ratio.setBackground(new Color(64, 224, 208));
		BT_Ratio.setBorder(null);
		BT_Ratio.setContentAreaFilled(false);
		contentPane.add(BT_Ratio);

		BT_Ratio.setBorder(BorderFactory.createEmptyBorder());
		BT_Ratio.setUI(new BasicButtonUI() {
			@Override
			public void paint(Graphics g, JComponent c) {
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				AbstractButton b = (AbstractButton) c;
				ButtonModel model = b.getModel();
				int width = b.getWidth();
				int height = b.getHeight();
				int arcSize = 180; // Đặt kích thước cong viền ở đây (5px)
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
		contentPane.add(BT_Ratio);

		BT_Next = new JButton("");
		BT_Next.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BT_Next.setBackground(new Color(0, 206, 209));
		BT_Next.setBounds(982, 400, 65, 42);
		BT_Next.setBorder(null);
		BT_Next.setContentAreaFilled(false);
		contentPane.add(BT_Next);

		BT_Next.setBorder(BorderFactory.createEmptyBorder());
		BT_Next.setUI(new BasicButtonUI() {
			@Override
			public void paint(Graphics g, JComponent c) {
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				AbstractButton b = (AbstractButton) c;
				ButtonModel model = b.getModel();
				int width = b.getWidth();
				int height = b.getHeight();
				int arcSize = 180; // Đặt kích thước cong viền ở đây (5px)
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
		contentPane.add(BT_Next);

		BT_50_50 = new JButton("50:50");
		BT_50_50.setBounds(982, 339, 65, 51);
		BT_50_50.setFont(new Font("Tahoma", Font.BOLD, 5));
		BT_50_50.setBackground(new Color(0, 206, 209));
		BT_50_50.setFont(new Font("Times New Roman", Font.BOLD, 23));
		BT_50_50.setBorder(null);
		BT_50_50.setContentAreaFilled(false);
		contentPane.add(BT_50_50);

		BT_50_50.setBorder(BorderFactory.createEmptyBorder());
		BT_50_50.setUI(new BasicButtonUI() {
			@Override
			public void paint(Graphics g, JComponent c) {
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				AbstractButton b = (AbstractButton) c;
				ButtonModel model = b.getModel();
				int width = b.getWidth();
				int height = b.getHeight();
				int arcSize = 180; // Đặt kích thước cong viền ở đây (5px)
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
		contentPane.add(BT_50_50);

		BT_D = new JButton("D");
		BT_D.setForeground(new Color(255, 255, 255));
		BT_D.setBackground(new Color(51, 204, 255));
		BT_D.setBounds(635, 460, 337, 58);
		BT_D.setFont(new Font("Tahoma", Font.BOLD, 14));
		BT_D.setContentAreaFilled(false);
		BT_D.setBorder(BorderFactory.createEmptyBorder());
		BT_D.setUI(new BasicButtonUI() {
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
		contentPane.add(BT_D);

		BT_C = new JButton("C");
		BT_C.setForeground(new Color(255, 255, 255));
		BT_C.setBackground(new Color(51, 204, 255));
		BT_C.setBounds(635, 356, 337, 58);
		BT_C.setFont(new Font("Tahoma", Font.BOLD, 14));
		BT_C.setContentAreaFilled(false);
		BT_C.setBorder(BorderFactory.createEmptyBorder());
		BT_C.setUI(new BasicButtonUI() {
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
		contentPane.add(BT_C);

		BT_B = new JButton("B");
		BT_B.setForeground(new Color(255, 255, 255));
		BT_B.setBackground(new Color(51, 204, 255));
		BT_B.setBounds(115, 460, 337, 58);
		BT_B.setFont(new Font("Tahoma", Font.BOLD, 14));
		BT_B.setContentAreaFilled(false);
		BT_B.setBorder(BorderFactory.createEmptyBorder());
		BT_B.setUI(new BasicButtonUI() {
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
		contentPane.add(BT_B);
		contentPane.add(BT_A);

		JPanel panel_1_1 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(15, 15); // Điều chỉnh độ cong ở đây
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Đổ màu nền
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

                // Vẽ viền
                graphics.setColor(getBackground());
                graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
            }
        };
        panel_1_1.setOpaque(false); // Vô hiệu hóa sự kiện đổ màu nền tự động của JPanel
		panel_1_1.setBackground(new Color(204, 255, 255));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(29, 251, 1018, 58);
		contentPane.add(panel_1_1);

		LB_Question = new JLabel("");
		LB_Question.setBounds(0, 0, 1018, 58);
		panel_1_1.add(LB_Question);
		LB_Question.setBackground(new Color(0, 204, 255));
		LB_Question.setForeground(new Color(0, 153, 255));
		LB_Question.setFont(new Font("Tahoma", Font.BOLD, 13));
		LB_Question.setHorizontalAlignment(JLabel.CENTER);

		JPanel panel_1_1_1 = new JPanel() {
		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        int cornerRadius = Math.min(getWidth(), getHeight()); // Lấy kích thước nhỏ nhất giữa chiều rộng và chiều cao
		        Graphics2D graphics = (Graphics2D) g;
		        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		        // Đổ màu nền
		        graphics.setColor(getBackground());
		        graphics.fillOval(0, 0, cornerRadius, cornerRadius);

		        // Vẽ viền
		        graphics.setColor(Color.white);
		        graphics.drawOval(0, 0, cornerRadius, cornerRadius);
		    }
		};

		panel_1_1_1.setOpaque(false);
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(244, 164, 96));
		panel_1_1_1.setBounds(517, 410, 71, 67);
		contentPane.add(panel_1_1_1);


		
				LB_Time = new JLabel("60");
				LB_Time.setHorizontalAlignment(JLabel.CENTER);
				LB_Time.setBounds(0, 0, 71, 67);
				panel_1_1_1.add(LB_Time);
				LB_Time.setForeground(new Color(51, 255, 102));
				LB_Time.setFont(new Font("Tahoma", Font.BOLD, 25));
				LB_Time.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D://Eclipse/AiLaTrieuPhu/src/Images/logo.png"));
		lblNewLabel.setBounds(449, 10, 212, 200);
		contentPane.add(lblNewLabel);

	}

	// COLOR CORRECT
	public void Color_Correct(JButton button) {
		button.setBackground(Color.green);
		button.updateUI();
	}

	// COLOR INCORRECT
	public void Color_Incorrect(JButton button) {
		button.setForeground(Color.red);
		button.updateUI();
	}
}
