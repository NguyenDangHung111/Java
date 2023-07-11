package Models;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.io.File;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicButtonUI;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import Configs.Database_AiLaTrieuPhu;
import Controllers.Controller_Game_Over;
import Controllers.Controller_Start_Game;
import Views.View_Game;
import Views.View_Game_Over;
import Views.View_Start_Game;

public class Model_Game {

	private int seconds;
	private int numberOfQuestion = 0;
	private String quesTion;
	private String answer_A;
	private String answer_B;
	private String answer_C;
	private String answer_D;
	private String answer_Correct;
	private String ratio_A;
	private String ratio_B;
	private String ratio_C;
	private String ratio_D;
	private Clip clip;
	private Clip clip2;
    private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Clip getClip2() {
		return clip2;
	}

	public void setClip2(Clip clip2) {
		this.clip2 = clip2;
	}

	private Timer timer;

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public Clip getClip() {
		return clip;
	}

	public void setClip(Clip clip) {
		this.clip = clip;
	}

	public String getRatio_A() {
		return ratio_A;
	}

	public void setRatio_A(String ratio_A) {
		this.ratio_A = ratio_A;
	}

	public String getRatio_B() {
		return ratio_B;
	}

	public void setRatio_B(String ratio_B) {
		this.ratio_B = ratio_B;
	}

	public String getRatio_C() {
		return ratio_C;
	}

	public void setRatio_C(String ratio_C) {
		this.ratio_C = ratio_C;
	}

	public String getRatio_D() {
		return ratio_D;
	}

	public void setRatio_D(String ratio_D) {
		this.ratio_D = ratio_D;
	}

	public Model_Game() {

	}

	// OUT GAME
	@SuppressWarnings("removal")
	public void Out_Game(View_Game view_game) {
		try {

			this.getClip().stop();
			this.getTimer().stop();
			// Tạo một mảng các lựa chọn cho Dialog
			Object[] options = { "CÓ", "KHÔNG" };

			// Hiển thị JOptionPane với hai nút chọn "OK" và "Cancel"
			int choice = JOptionPane.showOptionDialog(null, "BẠN MUỐN THOÁT ?", "Thông báo", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			// Xử lý kết quả từ người dùng
			if (choice == JOptionPane.YES_OPTION) {
				view_game.dispose();
				getClip2().stop();
				this.getClip().stop();
				Model_Start_Game model_start = new Model_Start_Game();
				View_Start_Game view_start_game = new View_Start_Game();
				Controller_Start_Game controller_start_game = new Controller_Start_Game(view_start_game, model_start);
			} else if (choice == JOptionPane.NO_OPTION) {
				this.getClip().start();
				this.getTimer().start();
				getClip2().start();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	// HELP 50 50
	public void Sound_50_50() {
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/50_50.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			clip2 = AudioSystem.getClip();
			clip2.open(audioIn);
			clip2.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void Help_50_50(View_Game view_game) {

		Random random = new Random();
		String[] arr1 = new String[4];
		arr1[0] = view_game.getA().getText();
		arr1[1] = view_game.getB().getText();
		arr1[2] = view_game.getC().getText();
		arr1[3] = view_game.getD().getText();

		String[] arr2 = new String[3];

		int count = 0;

		for (int i = 0; i < 4; i++) {
			if (!arr1[i].equals(this.getAnswer_Correct())) {
				arr2[count] = arr1[i];
				count++;
			}
		}

		for (int i = 0; i < 2; i++) {
			if (arr2[i].equals(view_game.getA().getText())) {
				view_game.getA().setText("");
			} else if (arr2[i].equals(view_game.getB().getText())) {
				view_game.getB().setText("");
			} else if (arr2[i].equals(view_game.getC().getText())) {
				view_game.getC().setText("");
			} else if (arr2[i].equals(view_game.getD().getText())) {
				view_game.getD().setText("");
			}

		}

	}
	
	// SOUND HELP EVERY ONE
	public void Sound_Every_One() {
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/helpeveryone.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			clip2 = AudioSystem.getClip();
			clip2.open(audioIn);
			clip2.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// FALSE
	public void Game_Over(View_Game view_game) {
		this.getClip2().stop();
		View_Game_Over view_game_over = new View_Game_Over();
		view_game_over.Sound_Over2(this.getNumberOfQuestion());
		view_game_over.getBT_GiaiThuong().setText(view_game.getLB_Money().getText());
		Controller_Game_Over controller_game_over = new Controller_Game_Over(view_game_over);
	}

	// SOUND GAME
	public void Sound_Game() {
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/nhacnengame.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			clip2 = AudioSystem.getClip();
			clip2.open(audioIn);
			clip2.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND INCORRECT
	public void Sound_Incorrect() {
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/traloisai.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip3 = AudioSystem.getClip();
			clip3.open(audioIn);
			clip3.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// TIME_SOUND
	public void LB_CountDown_Time(View_Game view_game) {
		seconds = 60;
		timer = new Timer(1000, e -> {
			seconds--;
			view_game.getLB_Time().setText(Integer.toString(seconds));

			if (seconds == 0) {
				((Timer) e.getSource()).stop();
				// Thực hiện các hành động sau khi kết thúc đếm ngược
				view_game.dispose();
				Game_Over(view_game);
			}
			if (seconds <= 30) {
				view_game.getLB_Time().setForeground(Color.red);
			} else {
				view_game.getLB_Time().setForeground(Color.green);
			}

		});
		timer.start();
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/demnguoc.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND BUTTON
	public void Sound_Buttton() {
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/nuttraloi.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioIn);
			clip1.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void Next(View_Game view_game) {
		this.setNumberOfQuestion(this.getNumberOfQuestion() - 1);
	}

	// SOUND SELECT A
	public void Select_A() {
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/selectA.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioIn);
			clip1.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND SELECT B
	public void Select_B() {
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/selectB .wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioIn);
			clip1.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND SELECT C
	public void Select_C() {
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/selectC.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioIn);
			clip1.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND SELECT D
	public void Select_D() {
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/selectD.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioIn);
			clip1.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND CORRECT A
	public void Correct_A() {
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/correctA .wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioIn);
			clip1.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND CORRECT B
	public void Correct_B() {
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/correctB.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioIn);
			clip1.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND CORRECT C
	public void Correct_C() {
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/correctC.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioIn);
			clip1.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND CORRECT D
	public void Correct_D() {
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/correctD.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioIn);
			clip1.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SELECT SOUND QUESTION
	public void Select_Sound(int number) {
		switch (number) {
		case 1:
			Soung_Question1();
			break;
		case 2:
			Soung_Question2();
			break;
		case 3:
			Soung_Question3();
			break;
		case 4:
			Soung_Question4();
			break;
		case 5:
			Soung_Question5();
			break;
		case 6:
			Soung_Question6();
			break;
		case 7:
			Soung_Question7();
			break;
		case 8:
			Soung_Question8();
			break;
		case 9:
			Soung_Question9();
			break;
		case 10:
			Soung_Question10();
			break;

		}
	}

	// SOUND QUESTION 1
	public void Soung_Question1() {

		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/ch1.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioIn);
			clip1.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND QUESTION 2
	public void Soung_Question2() {

		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/ch2.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioIn);
			clip1.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND QUESTION 3
	public void Soung_Question3() {

		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/ch3.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioIn);
			clip1.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND QUESTION4
	public void Soung_Question4() {

		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/ch4.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioIn);
			clip1.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND QUESTION 5
	public void Soung_Question5() {

		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/ch5.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioIn);
			clip1.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND QUESTION 6
	public void Soung_Question6() {

		try {
			File soundFile2 = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/ch6.wav");
			AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(soundFile2);
			Clip clip2 = AudioSystem.getClip();
			clip2.open(audioIn2);
			clip2.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SOUND QUESTION 7
		public void Soung_Question7() {

			try {
				File soundFile2 = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/ch7.wav");
				AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(soundFile2);
				Clip clip2 = AudioSystem.getClip();
				clip2.open(audioIn2);
				clip2.start();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		// SOUND QUESTION 8
		public void Soung_Question8() {

			try {
				File soundFile2 = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/ch8.wav");
				AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(soundFile2);
				Clip clip2 = AudioSystem.getClip();
				clip2.open(audioIn2);
				clip2.start();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		// SOUND QUESTION 9
		public void Soung_Question9() {

			try {
				File soundFile2 = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/ch9.wav");
				AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(soundFile2);
				Clip clip2 = AudioSystem.getClip();
				clip2.open(audioIn2);
				clip2.start();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		// SOUND QUESTION 10
		public void Soung_Question10() {

			try {
				File soundFile2 = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/ch10.wav");
				AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(soundFile2);
				Clip clip2 = AudioSystem.getClip();
				clip2.open(audioIn2);
				clip2.start();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	
	// MONEY
	public int Money(int NumberOfQuestion) {
		int money = 0;
		switch (NumberOfQuestion) {
		case 1:
			money = 0;
			break;
		case 2:
			money = 100000;
			break;
		case 3:
			money = 200000;
			break;
		case 4:
			money = 300000;
			break;
		case 5:
			money = 500000;
			break;
		case 6:
			money = 1000000;
			break;
		case 7:
			money = 2000000;
			break;
		case 8:
			money = 4000000;
			break;
		case 9:
			money = 6000000;
			break;
		case 10:
			money = 10000000;
			break;
		default:
			money = 0;
		}
		return money;
	}

	// CHANGE LABEL MONEY
	public void LB_Money(View_Game view_game, int numberOfQuestion) {
		view_game.getLB_Money().setText(String.valueOf(Money(numberOfQuestion)) + "$");
	}

	// CHANGE LABEL NUMBER QUESTION
	public void LB_Number_Question(View_Game view_game, int numberOfQuestion) {
		view_game.getLB_NumberOfQuestion().setText(String.valueOf(numberOfQuestion) + "/10");
	}

	// NUMBER OF QUESTION
	public int NumberOfQuestion() {
		this.setNumberOfQuestion(numberOfQuestion);
		this.numberOfQuestion++;
		return this.getNumberOfQuestion();

	}

	// GROUP OF QUESTION
	public int GroupOfQuestion() {
		int number_group = 0;
		int group = 0;
		try {
			Database_AiLaTrieuPhu data = new Database_AiLaTrieuPhu();
			Connection connect = data.getConnection();
			Statement conn = connect.createStatement();
			ResultSet rs_Data = conn
					.executeQuery("SELECT * FROM ta_110_question ORDER BY I_GroupQuestion DESC LIMIT 1");

			if (rs_Data.next()) {
				group = rs_Data.getInt("I_GroupQuestion");
			}

			// Tạo một đối tượng Random
			Random random = new Random();
			// Sinh một số nguyên ngẫu nhiên
			number_group = random.nextInt(group) + 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return number_group;
	}

	// QUESTION
	public void LB_Question(View_Game view_game, int numberofquestion, int groupofquestion) {
		try {
			Database_AiLaTrieuPhu connect = new Database_AiLaTrieuPhu();
			Connection conn = connect.getConnection();
			Statement stm_Getdata = conn.createStatement();

			ResultSet search = stm_Getdata.executeQuery("SELECT * FROM ta_110_question WHERE I_NumOfQuestion = "
					+ numberofquestion + " AND I_GroupQuestion = " + groupofquestion);

			if (search.next()) {
				view_game.getLB_Question().setText(search.getString("T_Question"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// ANSWER A
	public void LB_Answer_A(View_Game view_game, int numberofquestion, int groupofquestion) {
		try {
			Database_AiLaTrieuPhu connect = new Database_AiLaTrieuPhu();
			Connection conn = connect.getConnection();
			Statement stm_Getdata = conn.createStatement();

			ResultSet search = stm_Getdata
					.executeQuery("SELECT T_Answer_A FROM ta_110_question WHERE I_NumOfQuestion = " + numberofquestion
							+ " AND I_GroupQuestion = " + groupofquestion);

			if (search.next()) {
				view_game.getA().setText(search.getString("T_Answer_A"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// ANSWER B
	public void LB_Answer_B(View_Game view_game, int numberofquestion, int groupofquestion) {
		try {
			Database_AiLaTrieuPhu connect = new Database_AiLaTrieuPhu();
			Connection conn = connect.getConnection();
			Statement stm_Getdata = conn.createStatement();

			ResultSet search = stm_Getdata
					.executeQuery("SELECT T_Answer_B FROM ta_110_question WHERE I_NumOfQuestion = " + numberofquestion
							+ " AND I_GroupQuestion = " + groupofquestion);

			if (search.next()) {
				view_game.getB().setText(search.getString("T_Answer_B"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// ANSWER C
	public void LB_Answer_C(View_Game view_game, int numberofquestion, int groupofquestion) {
		try {
			Database_AiLaTrieuPhu connect = new Database_AiLaTrieuPhu();
			Connection conn = connect.getConnection();
			Statement stm_Getdata = conn.createStatement();

			ResultSet search = stm_Getdata
					.executeQuery("SELECT T_Answer_C FROM ta_110_question WHERE I_NumOfQuestion = " + numberofquestion
							+ " AND I_GroupQuestion = " + groupofquestion);

			if (search.next()) {
				view_game.getC().setText(search.getString("T_Answer_C"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// ANSWER D
	public void LB_Answer_D(View_Game view_game, int numberofquestion, int groupofquestion) {
		try {
			Database_AiLaTrieuPhu connect = new Database_AiLaTrieuPhu();
			Connection conn = connect.getConnection();
			Statement stm_Getdata = conn.createStatement();

			ResultSet search = stm_Getdata
					.executeQuery("SELECT T_Answer_D FROM ta_110_question WHERE I_NumOfQuestion = " + numberofquestion
							+ " AND I_GroupQuestion = " + groupofquestion);

			if (search.next()) {
				view_game.getD().setText(search.getString("T_Answer_D"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// ANSWER CORRECT AND RATIO
	public String Answer_Correct(int numberOfQuestion, int groupOfQuestion) {
		int id = 0;
		try {
			Database_AiLaTrieuPhu connect = new Database_AiLaTrieuPhu();
			Connection conn = connect.getConnection();
			Statement stm_Getdata = conn.createStatement();

			ResultSet search_ID = stm_Getdata.executeQuery("SELECT I_ID FROM ta_110_question WHERE I_NumOfQuestion = "
					+ numberOfQuestion + " AND I_GroupQuestion = " + groupOfQuestion);

			if (search_ID.next()) {
				id = search_ID.getInt("I_ID");
			}

			ResultSet search_Answer = stm_Getdata
					.executeQuery("SELECT * FROM ta_110_answer WHERE I_ID_ANS =" + id);

			if (search_Answer.next()) {
				this.setAnswer_Correct(search_Answer.getString("T_AnswerCorrect"));
				this.setRatio_A(search_Answer.getString("T_Ratio_A"));
				this.setRatio_B(search_Answer.getString("T_Ratio_B"));
				this.setRatio_C(search_Answer.getString("T_Ratio_C"));
				this.setRatio_D(search_Answer.getString("T_Ratio_D"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return this.getAnswer_Correct();
	}

	// CHECK ANSWER
	public boolean Check_Answer(JButton button) {
		if (button.getText().equals(this.getAnswer_Correct())) {
			return true;
		}
		return false;
	}

	// Reset Button
	public void Reset_Button(View_Game view_game) {
		view_game.getA().setForeground(new Color(255, 255, 255));
		view_game.getA().setBackground(new Color(102, 204, 255));
		view_game.getA().setFont(new Font("Tahoma", Font.BOLD, 14));
		view_game.getA().setContentAreaFilled(false);
		view_game.getA().setBorder(BorderFactory.createEmptyBorder());
		view_game.getA().setUI(new BasicButtonUI() {
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
		
		view_game.getB().setForeground(new Color(255, 255, 255));
		view_game.getB().setBackground(new Color(102, 204, 255));
		view_game.getB().setFont(new Font("Tahoma", Font.BOLD, 14));
		view_game.getB().setContentAreaFilled(false);
		view_game.getB().setBorder(BorderFactory.createEmptyBorder());
		view_game.getB().setUI(new BasicButtonUI() {
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
		
		view_game.getC().setForeground(new Color(255, 255, 255));
		view_game.getC().setBackground(new Color(102, 204, 255));
		view_game.getC().setFont(new Font("Tahoma", Font.BOLD, 14));
		view_game.getC().setContentAreaFilled(false);
		view_game.getC().setBorder(BorderFactory.createEmptyBorder());
		view_game.getC().setUI(new BasicButtonUI() {
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
		
		view_game.getD().setForeground(new Color(255, 255, 255));
		view_game.getD().setBackground(new Color(102, 204, 255));
		view_game.getD().setFont(new Font("Tahoma", Font.BOLD, 14));
		view_game.getD().setContentAreaFilled(false);
		view_game.getD().setBorder(BorderFactory.createEmptyBorder());
		view_game.getD().setUI(new BasicButtonUI() {
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
		
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getNumberOfQuestion() {
		return numberOfQuestion;
	}

	public void setNumberOfQuestion(int numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}

	public String getQuesTion() {
		return quesTion;
	}

	public void setQuesTion(String quesTion) {
		this.quesTion = quesTion;
	}

	public String getAnswer_A() {
		return answer_A;
	}

	public void setAnswer_A(String answer_A) {
		this.answer_A = answer_A;
	}

	public String getAnswer_B() {
		return answer_B;
	}

	public void setAnswer_B(String answer_B) {
		this.answer_B = answer_B;
	}

	public String getAnswer_C() {
		return answer_C;
	}

	public void setAnswer_C(String answer_C) {
		this.answer_C = answer_C;
	}

	public String getAnswer_D() {
		return answer_D;
	}

	public void setAnswer_D(String answer_D) {
		this.answer_D = answer_D;
	}

	public String getAnswer_Correct() {
		return answer_Correct;
	}

	public void setAnswer_Correct(String answer_Correct) {
		this.answer_Correct = answer_Correct;
	}

}
