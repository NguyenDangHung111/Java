package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 634);
		setSize(1088, 643);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		BT_A = new JButton("A");
		BT_A.setBackground(Color.WHITE);
		BT_A.setBounds(144, 345, 261, 58);
		BT_A.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(101, 59, 134, 36);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		LB_Money = new JLabel("0$");
		LB_Money.setBounds(0, 0, 124, 32);
		panel_1.add(LB_Money);
		LB_Money.setFont(new Font("Tahoma", Font.BOLD, 18));
		LB_Money.setForeground(new Color(255, 153, 0));

		JPanel panel = new JPanel();
		panel.setBounds(140, 198, 65, 42);
		contentPane.add(panel);
		panel.setLayout(null);

		LB_NumberOfQuestion = new JLabel("");
		LB_NumberOfQuestion.setBounds(0, 0, 41, 36);
		panel.add(LB_NumberOfQuestion);
		LB_NumberOfQuestion.setForeground(new Color(205, 133, 63));
		LB_NumberOfQuestion.setFont(new Font("Tahoma", Font.BOLD, 17));

		BT_Exit = new JButton("quay lai");
		BT_Exit.setBackground(Color.WHITE);
		BT_Exit.setBounds(952, 431, 95, 42);
		contentPane.add(BT_Exit);

		BT_Ratio = new JButton("NGUOI KHAC");
		BT_Ratio.setBackground(Color.WHITE);
		BT_Ratio.setBounds(952, 358, 95, 45);
		contentPane.add(BT_Ratio);

		BT_Next = new JButton("bo qua");
		BT_Next.setBackground(Color.WHITE);
		BT_Next.setBounds(952, 268, 78, 42);
		contentPane.add(BT_Next);

		BT_50_50 = new JButton("50/50");
		BT_50_50.setBounds(952, 195, 78, 45);
		BT_50_50.setFont(new Font("Tahoma", Font.BOLD, 12));
		BT_50_50.setBackground(Color.WHITE);
		contentPane.add(BT_50_50);

		BT_D = new JButton("D");
		BT_D.setBackground(Color.WHITE);
		BT_D.setBounds(550, 447, 261, 58);
		BT_D.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(BT_D);

		BT_C = new JButton("C");
		BT_C.setBackground(Color.WHITE);
		BT_C.setBounds(550, 345, 261, 58);
		BT_C.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(BT_C);

		BT_B = new JButton("B");
		BT_B.setBackground(Color.WHITE);
		BT_B.setBounds(144, 447, 261, 58);
		BT_B.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(BT_B);
		contentPane.add(BT_A);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(144, 252, 786, 58);
		contentPane.add(panel_1_1);

		LB_Question = new JLabel("");
		LB_Question.setBounds(0, 0, 776, 58);
		panel_1_1.add(LB_Question);
		LB_Question.setBackground(new Color(0, 255, 255));
		LB_Question.setForeground(new Color(0, 0, 0));
		LB_Question.setFont(new Font("Tahoma", Font.BOLD, 14));

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(101, 119, 88, 36);
		contentPane.add(panel_1_1_1);

		LB_Time = new JLabel("60");
		LB_Time.setBounds(0, 0, 71, 36);
		panel_1_1_1.add(LB_Time);
		LB_Time.setForeground(Color.green);
		LB_Time.setFont(new Font("Tahoma", Font.BOLD, 19));
		LB_Time.setBackground(Color.CYAN);
	}

}
