package Models;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.Timer;

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
	public void Out_Game() {
		Model_Start_Game model_start = new Model_Start_Game();
		View_Start_Game view_start_game = new View_Start_Game();
		Controller_Start_Game controller_start_game = new Controller_Start_Game(view_start_game,model_start);
	}

	// FALSE
	public void Game_Over() {
		View_Game_Over view_game_over = new View_Game_Over();
		Controller_Game_Over controller_game_over = new Controller_Game_Over(view_game_over);
	}

	// TIME
	public void LB_CountDown_Time(View_Game view_game) {
		seconds = 60;
		Timer timer = new Timer(1000, e -> {
			seconds--;
			view_game.getLB_Time().setText(Integer.toString(seconds));

			if (seconds == 0 ) {
				((Timer) e.getSource()).stop();
				// Thực hiện các hành động sau khi kết thúc đếm ngược
				view_game.dispose();
				Game_Over();
			}
			if (seconds <= 30) {
				view_game.getLB_Time().setForeground(Color.red);
			}
		});
		timer.start();
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
	public void LB_Money(View_Game view_game) {
		view_game.getLB_Money().setText(String.valueOf(Money(NumberOfQuestion())) + "$");
	}

//	 CHANGE LABEL NUMBER QUESTION
	public void LB_Number_Question(View_Game view_game) {
		view_game.getLB_NumberOfQuestion().setText(String.valueOf(NumberOfQuestion()-2) + "/10");
	}

	// NUMBER OF QUESTION
	int nmb =numberOfQuestion;
	public int NumberOfQuestion() {
		
		
		this.setNumberOfQuestion(numberOfQuestion);
		this.numberOfQuestion ++;
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

	// ANSWER CORRECT
	public String Answer_Correct(int numberOfQuestion, int groupOfQuestion) {
		int id= 0;
		try {
			Database_AiLaTrieuPhu connect = new Database_AiLaTrieuPhu();
			Connection conn = connect.getConnection();
			Statement stm_Getdata = conn.createStatement();

			ResultSet search_ID = stm_Getdata
					.executeQuery("SELECT I_ID FROM ta_110_question WHERE I_NumOfQuestion = " + numberOfQuestion
							+ " AND I_GroupQuestion = " + groupOfQuestion);
			
			if (search_ID.next()) {
				id =search_ID.getInt("I_ID");
			}
			
			ResultSet search_Answer = stm_Getdata
					.executeQuery("SELECT T_AnswerCorrect FROM ta_110_answer WHERE I_ID_ANS =" + id);

			if (search_Answer.next()) {
				this.setAnswer_Correct(search_Answer.getString("T_AnswerCorrect"));
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

	// BUTTON A
	public boolean Button_A(View_Game view_game) {
		if (Check_Answer(view_game.getA())) {
			view_game.getA().setBackground(Color.green);
			view_game.getA().setForeground(Color.white);
			return true;
		} else {
			view_game.getA().setBackground(Color.red);
			view_game.getA().setForeground(Color.white);
			return false;
		}
	}

	// BUTTON B
	public boolean Button_B(View_Game view_game) {
		if (Check_Answer(view_game.getB())) {
			view_game.getB().setBackground(Color.green);
			view_game.getB().setForeground(Color.white);
			return true;
		} else {
			view_game.getB().setBackground(Color.red);
			view_game.getB().setForeground(Color.white);
			return false;
		}
	}

	// BUTTON C
	public boolean Button_C(View_Game view_game) {
		if (Check_Answer(view_game.getC())) {
			view_game.getC().setBackground(Color.green);
			view_game.getC().setForeground(Color.white);
			return true;
		} else {
			view_game.getC().setBackground(Color.red);
			view_game.getC().setForeground(Color.white);
			return false;
		}
	}

	//BUTTON D
		public boolean Button_D(View_Game view_game) {
			if(Check_Answer(view_game.getD())) {
				view_game.getD().setBackground(Color.green);
				view_game.getD().setForeground(Color.white);
				return true;
			}else {
				view_game.getD().setBackground(Color.red);
				view_game.getD().setForeground(Color.white);
				return false;
			}			
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
