package Views;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Models.Model_Server;

import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Vector;
import java.awt.SystemColor;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;

public class View_Server extends JFrame {
	private JTable TB_Table;
	private DefaultTableModel DTM_Table;
	private JLabel LB_NameTable;
	private JLabel LB_Question;
	private JLabel LB_Answer_A;
	private JLabel LB_Answer_B;
	private JLabel LB_Answer_C;
	private JLabel LB_Answer_D;
	private JLabel LB_Answer_Correct;
	private JLabel LB_NumberOfQuestion;
	private JLabel LB_GroupOfQuestion;
	private JLabel LB_Ratio_A;
	private JLabel LB_Ratio_B;
	private JLabel LB_Ratio_C;
	private JLabel LB_Ratio_D;

	private JTextField TF_Question;
	private JTextField TF_Answer_A;
	private JTextField TF_Answer_B;
	private JTextField TF_Answer_C;
	private JTextField TF_Answer_D;
	private JTextField TF_Answer_Correct;
	private JTextField TF_NumberOfQuestion;
	private JTextField TF_GroupOfQuestion;
	private JTextField TF_Ratio_A;
	private JTextField TF_Ratio_B;
	private JTextField TF_Ratio_C;
	private JTextField TF_Ratio_D;

	private JButton BT_Add;
	private JButton BT_Edit;
	private JButton BT_Delete;
	private JButton BT_Refresh;

	private Model_Server model_Server;

	public View_Server() {
		getContentPane().setEnabled(false);
		setTitle("SERVER");
		getContentPane().setLayout(null);

		setVisible(true);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setBackground(Color.decode("#004AAD"));
		getContentPane().setLayout(null);

		// Button
		BT_Refresh = new JButton("LÀM MỚI");
		BT_Refresh.setBounds(530, 739, 89, 36);
		BT_Refresh.setBackground(Color.decode("#004AAD"));
		BT_Refresh.setFont(new Font("Arial", Font.BOLD, 14));
		BT_Refresh.setForeground(new Color(0, 255, 0));
		getContentPane().add(BT_Refresh);
		BT_Refresh.setBorder(null);
		BT_Refresh.setBorder(BorderFactory.createEmptyBorder());
		BT_Refresh.setUI(new BasicButtonUI() {
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

		BT_Add = new JButton("THÊM");
		BT_Add.setBounds(655, 739, 89, 36);
		BT_Add.setBackground(Color.decode("#004AAD"));
		BT_Add.setFont(new Font("Arial", Font.BOLD, 14));
		BT_Add.setForeground(new Color(0, 255, 0));
		getContentPane().add(BT_Add);
		BT_Add.setBorder(null);
		BT_Add.setBorder(BorderFactory.createEmptyBorder());
		BT_Add.setUI(new BasicButtonUI() {
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

		BT_Edit = new JButton("SỬA");
		BT_Edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		BT_Edit.setBackground(Color.decode("#004AAD"));
		BT_Edit.setForeground(new Color(255, 255, 0));
		BT_Edit.setBounds(794, 739, 95, 36);
		getContentPane().add(BT_Edit);
		BT_Edit.setBorder(null);
		BT_Edit.setBorder(BorderFactory.createEmptyBorder());
		BT_Edit.setUI(new BasicButtonUI() {
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

		BT_Delete = new JButton("XÓA");
		BT_Delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		BT_Delete.setBackground(Color.decode("#004AAD"));
		BT_Delete.setForeground(new Color(255, 215, 0));
		BT_Delete.setBounds(941, 739, 89, 36);
		getContentPane().add(BT_Delete);
		BT_Delete.setBorder(new EmptyBorder(1, 3, 1, 1));
		BT_Delete.setBorder(BorderFactory.createEmptyBorder());
		BT_Delete.setUI(new BasicButtonUI() {
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

		// Label
		LB_Question = new JLabel("BỘ CÂU HỎI");
		LB_Question.setForeground(new Color(255, 255, 255));
		LB_Question.setFont(new Font("Verdana", Font.BOLD, 20));
		LB_Question.setBounds(777, 10, 138, 46);
		getContentPane().add(LB_Question);

		LB_NameTable = new JLabel("CÂU HỎI");
		LB_NameTable.setForeground(new Color(255, 255, 255));
		LB_NameTable.setFont(new Font("Tahoma", Font.BOLD, 14));
		LB_NameTable.setBounds(29, 66, 71, 23);
		getContentPane().add(LB_NameTable);

		LB_Answer_A = new JLabel("ĐÁP ÁN A");
		LB_Answer_A.setForeground(new Color(255, 255, 255));
		LB_Answer_A.setFont(new Font("Tahoma", Font.BOLD, 14));
		LB_Answer_A.setBounds(29, 105, 71, 30);
		getContentPane().add(LB_Answer_A);

		LB_Answer_B = new JLabel("ĐÁP ÁN B");
		LB_Answer_B.setForeground(new Color(255, 255, 255));
		LB_Answer_B.setFont(new Font("Tahoma", Font.BOLD, 14));
		LB_Answer_B.setBounds(29, 148, 71, 36);
		getContentPane().add(LB_Answer_B);

		LB_Answer_C = new JLabel("ĐÁP ÁN C");
		LB_Answer_C.setForeground(new Color(255, 255, 255));
		LB_Answer_C.setFont(new Font("Tahoma", Font.BOLD, 14));
		LB_Answer_C.setBounds(29, 194, 71, 36);
		getContentPane().add(LB_Answer_C);

		LB_Answer_D = new JLabel("ĐÁP ÁN D");
		LB_Answer_D.setForeground(new Color(255, 255, 255));
		LB_Answer_D.setFont(new Font("Tahoma", Font.BOLD, 14));
		LB_Answer_D.setBounds(29, 240, 71, 36);
		getContentPane().add(LB_Answer_D);

		LB_NumberOfQuestion = new JLabel("CÂU HỎI SỐ");
		LB_NumberOfQuestion.setForeground(new Color(255, 255, 255));
		LB_NumberOfQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		LB_NumberOfQuestion.setBounds(29, 280, 95, 36);
		getContentPane().add(LB_NumberOfQuestion);

		LB_Answer_Correct = new JLabel("ĐÁP ÁN ĐÚNG");
		LB_Answer_Correct.setForeground(new Color(255, 255, 255));
		LB_Answer_Correct.setFont(new Font("Tahoma", Font.BOLD, 14));
		LB_Answer_Correct.setBounds(777, 66, 113, 23);
		getContentPane().add(LB_Answer_Correct);

		LB_Ratio_A = new JLabel("TỈ LỆ A");
		LB_Ratio_A.setForeground(new Color(255, 255, 255));
		LB_Ratio_A.setFont(new Font("Tahoma", Font.BOLD, 14));
		LB_Ratio_A.setBounds(777, 102, 113, 36);
		getContentPane().add(LB_Ratio_A);

		LB_Ratio_B = new JLabel("TỈ LỆ B");
		LB_Ratio_B.setForeground(new Color(255, 255, 255));
		LB_Ratio_B.setFont(new Font("Tahoma", Font.BOLD, 14));
		LB_Ratio_B.setBounds(777, 148, 71, 36);
		getContentPane().add(LB_Ratio_B);

		LB_Ratio_C = new JLabel("TỈ LỆ C");
		LB_Ratio_C.setForeground(new Color(255, 255, 255));
		LB_Ratio_C.setFont(new Font("Tahoma", Font.BOLD, 14));
		LB_Ratio_C.setBounds(777, 194, 76, 36);
		getContentPane().add(LB_Ratio_C);

		LB_Ratio_D = new JLabel("TỈ LỆ D");
		LB_Ratio_D.setForeground(new Color(255, 255, 255));
		LB_Ratio_D.setFont(new Font("Tahoma", Font.BOLD, 14));
		LB_Ratio_D.setBounds(777, 240, 76, 36);
		getContentPane().add(LB_Ratio_D);

		LB_GroupOfQuestion = new JLabel("NHÓM");
		LB_GroupOfQuestion.setForeground(new Color(255, 255, 255));
		LB_GroupOfQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		LB_GroupOfQuestion.setBounds(777, 280, 76, 36);
		getContentPane().add(LB_GroupOfQuestion);

		// TEXTFIELD
		TF_Question = new JTextField();
		TF_Question.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TF_Question.setBounds(125, 66, 613, 23);
		getContentPane().add(TF_Question);

		TF_Answer_A = new JTextField();
		TF_Answer_A.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TF_Answer_A.setBounds(125, 109, 613, 23);
		getContentPane().add(TF_Answer_A);

		TF_Answer_B = new JTextField();
		TF_Answer_B.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TF_Answer_B.setBounds(125, 155, 613, 23);
		getContentPane().add(TF_Answer_B);

		TF_Answer_C = new JTextField();
		TF_Answer_C.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TF_Answer_C.setBounds(125, 201, 613, 23);
		getContentPane().add(TF_Answer_C);

		TF_Answer_D = new JTextField();
		TF_Answer_D.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TF_Answer_D.setBounds(125, 244, 613, 23);
		getContentPane().add(TF_Answer_D);

		TF_NumberOfQuestion = new JTextField();
		TF_NumberOfQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TF_NumberOfQuestion.setBounds(125, 287, 613, 23);
		getContentPane().add(TF_NumberOfQuestion);

		TF_Answer_Correct = new JTextField();
		TF_Answer_Correct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TF_Answer_Correct.setBounds(916, 66, 598, 23);
		getContentPane().add(TF_Answer_Correct);

		TF_Ratio_A = new JTextField();
		TF_Ratio_A.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TF_Ratio_A.setBounds(916, 109, 598, 23);
		getContentPane().add(TF_Ratio_A);

		TF_Ratio_B = new JTextField();
		TF_Ratio_B.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TF_Ratio_B.setBounds(916, 155, 598, 23);
		getContentPane().add(TF_Ratio_B);

		TF_Ratio_C = new JTextField();
		TF_Ratio_C.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TF_Ratio_C.setBounds(916, 201, 598, 23);
		getContentPane().add(TF_Ratio_C);

		TF_Ratio_D = new JTextField();
		TF_Ratio_D.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TF_Ratio_D.setBounds(916, 247, 598, 23);
		getContentPane().add(TF_Ratio_D);

		TF_GroupOfQuestion = new JTextField();
		TF_GroupOfQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TF_GroupOfQuestion.setBounds(916, 287, 598, 23);
		getContentPane().add(TF_GroupOfQuestion);

		// Table
		Vector<String> columnNames = new Vector<>();
		columnNames.add("CÂU HỎI");
		columnNames.add("ĐÁP ÁN A");
		columnNames.add("ĐÁP ÁN B");
		columnNames.add("ĐÁP ÁN C");
		columnNames.add("ĐÁP ÁN D");
		columnNames.add("TỈ LỆ A");
		columnNames.add("TỈ LỆ B");
		columnNames.add("TỈ LỆ C");
		columnNames.add("TỈ LỆ D");
		columnNames.add("ĐÁP ÁN ĐÚNG");
		columnNames.add("CÂU HỎI SỐ");
		columnNames.add("NHÓM");

		this.model_Server = new Model_Server();
		DTM_Table = new DefaultTableModel(this.model_Server.Data(), columnNames);
		DTM_Table.fireTableDataChanged();

		TB_Table = new JTable(DTM_Table);
		getContentPane().add(TB_Table);
		JScrollPane scr = new JScrollPane(TB_Table);
		scr.setBounds(29, 342, 1485, 387);
		scr.setBackground(new Color(44, 136, 190));
		getContentPane().add(scr);

		for (int i = 0; i < TB_Table.getColumnModel().getColumnCount(); i++) {
			TableColumn column = TB_Table.getColumnModel().getColumn(i);
			DefaultTableCellRenderer renderer1 = new DefaultTableCellRenderer();
			TB_Table.getTableHeader().getDefaultRenderer();
			renderer1.setFont(new Font("Arial", Font.BOLD, 13));
			renderer1.setBackground(new Color(44, 136, 190));
			renderer1.setForeground(Color.WHITE);
			column.setHeaderRenderer(renderer1);
			renderer1.setHorizontalAlignment(JLabel.CENTER);
		}

	}

	public JTable getTB_Table() {
		return TB_Table;
	}

	public void setTB_Table(JTable tB_Table) {
		TB_Table = tB_Table;
	}

	public JTextField getTF_Question() {
		return TF_Question;
	}

	public void setTF_Question(String tF_Question) {
		TF_Question.setText(tF_Question);
		;
	}

	public JTextField getTF_Answer_A() {
		return TF_Answer_A;
	}

	public void setTF_Answer_A(String tF_Answer_A) {
		TF_Answer_A.setText(tF_Answer_A);
		;
	}

	public JTextField getTF_Answer_B() {
		return TF_Answer_B;
	}

	public void setTF_Answer_B(String tF_Answer_B) {
		TF_Answer_B.setText(tF_Answer_B);
		;
	}

	public JTextField getTF_Answer_C() {
		return TF_Answer_C;
	}

	public void setTF_Answer_C(String tF_Answer_C) {
		TF_Answer_C.setText(tF_Answer_C);
		;
	}

	public JTextField getTF_Answer_D() {
		return TF_Answer_D;
	}

	public void setTF_Answer_D(String tF_Answer_D) {
		TF_Answer_D.setText(tF_Answer_D);
		;
	}

	public JTextField getTF_Answer_Correct() {
		return TF_Answer_Correct;
	}

	public void setTF_Answer_Correct(String tF_Answer_Correct) {
		TF_Answer_Correct.setText(tF_Answer_Correct);
		;
	}

	public JTextField getTF_NumberOfQuestion() {
		return TF_NumberOfQuestion;
	}

	public void setTF_NumberOfQuestion(String tF_NumberOfQuestion) {
		TF_NumberOfQuestion.setText(tF_NumberOfQuestion);
		;
	}

	public JTextField getTF_GroupOfQuestion() {
		return TF_GroupOfQuestion;
	}

	public void setTF_GroupOfQuestion(String tF_GroupOfQuestion) {
		TF_GroupOfQuestion.setText(tF_GroupOfQuestion);
		;
	}

	public JTextField getTF_Ratio_A() {
		return TF_Ratio_A;
	}

	public void setTF_Ratio_A(String tF_Ratio_A) {
		TF_Ratio_A.setText(tF_Ratio_A);
		;
	}

	public JTextField getTF_Ratio_B() {
		return TF_Ratio_B;
	}

	public void setTF_Ratio_B(String tF_Ratio_B) {
		TF_Ratio_B.setText(tF_Ratio_B);
		;
	}

	public JTextField getTF_Ratio_C() {
		return TF_Ratio_C;
	}

	public void setTF_Ratio_C(String tF_Ratio_C) {
		TF_Ratio_C.setText(tF_Ratio_C);
		;
	}

	public JTextField getTF_Ratio_D() {
		return TF_Ratio_D;
	}

	public void setTF_Ratio_D(String tF_Ratio_D) {
		TF_Ratio_D.setText(tF_Ratio_D);
		;
	}

	public JButton getBT_Add() {
		return BT_Add;
	}

	public void setBT_Add(JButton bT_Add) {
		BT_Add = bT_Add;
	}

	public JButton getBT_Edit() {
		return BT_Edit;
	}

	public void setBT_Edit(JButton bT_Edit) {
		BT_Edit = bT_Edit;
	}

	public JButton getBT_Delete() {
		return BT_Delete;
	}

	public void setBT_Delete(JButton bT_Delete) {
		BT_Delete = bT_Delete;
	}

	public void setTB_Table(Vector<Vector<String>> data) {
		Vector<String> columnNames = new Vector<>();
		columnNames.add("CÂU HỎI");
		columnNames.add("ĐÁP ÁN A");
		columnNames.add("ĐÁP ÁN B");
		columnNames.add("ĐÁP ÁN C");
		columnNames.add("ĐÁP ÁN D");
		columnNames.add("TỈ LỆ A");
		columnNames.add("TỈ LỆ B");
		columnNames.add("TỈ LỆ C");
		columnNames.add("TỈ LỆ D");
		columnNames.add("ĐÁP ÁN ĐÚNG");
		columnNames.add("CÂU HỎI SỐ");
		columnNames.add("NHÓM");
		DTM_Table = new DefaultTableModel(data, columnNames);
		TB_Table.setModel(DTM_Table);
	}

	public JButton getBT_Refresh() {
		return BT_Refresh;
	}
}
