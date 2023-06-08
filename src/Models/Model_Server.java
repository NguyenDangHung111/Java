package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Configs.Database_AiLaTrieuPhu;
import Views.View_Server;

public class Model_Server {
	private String question;
	private String answer_A;
	private String answer_B;
	private String answer_C;
	private String answer_D;
	private String answer_Correct;
	private int numberOfQuestion;
	private int groupOfQuestion;
	private int number;
	private int group;

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Model_Server() {

	}

	// Data
	public Vector<Vector<String>> Data() {
		Vector<Vector<String>> data = new Vector<>();
		try {
			Database_AiLaTrieuPhu connect = new Database_AiLaTrieuPhu();
			Connection conn = connect.getConnection();
			java.sql.Statement stm_Getdata = conn.createStatement();
			ResultSet rs_Data = ((java.sql.Statement) stm_Getdata).executeQuery(
					"SELECT * FROM ta_110_question INNER JOIN ta_110_answer ON ta_110_question.I_ID = ta_110_answer.I_ID_ANS order by ta_110_question.i_numofquestion asc , ta_110_question.i_groupquestion asc;");

			while (rs_Data.next()) {
				Vector<String> data_in_database = new Vector<>();
				data_in_database.add(rs_Data.getString("T_Question"));
				data_in_database.add(rs_Data.getString("T_Answer_A"));
				data_in_database.add(rs_Data.getString("T_Answer_B"));
				data_in_database.add(rs_Data.getString("T_Answer_C"));
				data_in_database.add(rs_Data.getString("T_Answer_D"));
				data_in_database.add(rs_Data.getString("T_Ratio_A"));
				data_in_database.add(rs_Data.getString("T_Ratio_B"));
				data_in_database.add(rs_Data.getString("T_Ratio_C"));
				data_in_database.add(rs_Data.getString("T_Ratio_D"));
				data_in_database.add(rs_Data.getString("T_AnswerCorrect"));
				data_in_database.add(Integer.toString(rs_Data.getInt("I_NumOfQuestion")));
				data_in_database.add(Integer.toString(rs_Data.getInt("I_GroupQuestion")));

				data.addElement(data_in_database);
			}
			stm_Getdata.close();

		} catch (Exception e) {
			System.out.print(e);
		}

		return data;
	}

	// Update_Question
	public void updata_Question(View_Server view_server) {
		if(view_server.getTF_Question().getText().equals("") || view_server.getTF_Answer_A().equals("")
				|| view_server.getTF_Answer_B().equals("") || view_server.getTF_Answer_C().equals("")
				|| view_server.getTF_Answer_D().equals("")||view_server.getTF_Answer_Correct().getText().equals("")||
				view_server.getTF_Ratio_A().getText().equals("")|| view_server.getTF_Ratio_B().getText().equals("")||
				view_server.getTF_Ratio_C().getText().equals("")|| view_server.getTF_Ratio_D().getText().equals("")||Integer.valueOf(view_server.getTF_GroupOfQuestion().getText()) < 1 ||Integer.valueOf(view_server.getTF_NumberOfQuestion().getText())<1) {
			 JOptionPane.showInternalMessageDialog(null, " CHỌN MỤC CẦN CẬP NHẬT ", "THÔNG BÁO",
						JOptionPane.CANCEL_OPTION);
		}else {
			try {
			Database_AiLaTrieuPhu connect = new Database_AiLaTrieuPhu();
			Connection conn = connect.getConnection();
			java.sql.Statement stm_Getdata = conn.createStatement();

			String updateQuery = "UPDATE ta_110_question " + "SET T_Question = '" + view_server.getTF_Question().getText() + "', " + "T_Answer_A = '"
					+ view_server.getTF_Answer_A().getText()+ "', " + "T_Answer_B = '" +  view_server.getTF_Answer_B().getText() + "', " + "T_Answer_C = '" + view_server.getTF_Answer_C().getText() + "', "
					+ "T_Answer_D = '" + view_server.getTF_Answer_D().getText() + "', " + "I_NumOfQuestion = " + Integer.valueOf(view_server.getTF_NumberOfQuestion().getText()) + ", "
					+ "I_GroupQuestion = " + Integer.valueOf(view_server.getTF_GroupOfQuestion().getText()) + " WHERE I_GroupQuestion = " + this.getGroup()
					+ " AND I_NumOfQuestion = " + this.getNumber();

			stm_Getdata.executeUpdate(updateQuery);

			updata_Answer(view_server.getTF_Answer_Correct().getText(),
					view_server.getTF_Ratio_A().getText(), view_server.getTF_Ratio_B().getText(),
					view_server.getTF_Ratio_C().getText(), view_server.getTF_Ratio_D().getText());
		    view_server.setTB_Table(Data());
		    JOptionPane.showInternalMessageDialog(null, " CẬP NHẬT THÀNH CÔNG ", "THÔNG BÁO",
					JOptionPane.CANCEL_OPTION);
		} catch (Exception e) {
			System.out.print(e);
		}
		}
		

	}

	// Update_Answer
	public void updata_Answer(String answer_Correct, String ratio_A, String ratio_B, String ratio_C, String ratio_D) {
		try {
			Database_AiLaTrieuPhu connect = new Database_AiLaTrieuPhu();
			Connection conn = connect.getConnection();
			java.sql.Statement stm_Getdata = conn.createStatement();

			ResultSet search_id = stm_Getdata.executeQuery("SELECT I_ID FROM ta_110_question WHERE I_NumOfQuestion = "
					+ this.getNumber() + " AND I_GroupQuestion = " + this.getGroup());
			int i_id_ans = 0;
			if (search_id.next()) {
				i_id_ans = search_id.getInt("I_ID");
			}

			String updateQuery = "UPDATE ta_110_answer SET " + "T_AnswerCorrect = '" + answer_Correct + "' , "
					+ "T_Ratio_A = '" + ratio_A + "', " + "T_Ratio_B = '" + ratio_B + "', " + "T_Ratio_C = '" + ratio_C
					+ "', " + "T_Ratio_D = '" + ratio_D + "'" + " WHERE I_ID_ANS = " + i_id_ans;

			stm_Getdata.executeUpdate(updateQuery);

		} catch (Exception e) {
			System.out.print(e);
		}

	}

	// Add_Question
	public void Add_Question(View_Server view_server) {

		if (view_server.getTF_Question().getText().equals("") || view_server.getTF_Answer_A().equals("")
				|| view_server.getTF_Answer_B().equals("") || view_server.getTF_Answer_C().equals("")
				|| view_server.getTF_Answer_D().equals("")) {
			JOptionPane.showInternalMessageDialog(null, " NHẬP THÔNG TIN CÒN THIẾU ", "THÔNG BÁO",
					JOptionPane.INFORMATION_MESSAGE);
		} else if ((Integer.valueOf((String) view_server.getTF_NumberOfQuestion().getText())) < 1
				|| (Integer.valueOf((String) view_server.getTF_GroupOfQuestion().getText())) < 1) {
			JOptionPane.showInternalMessageDialog(null, " SỐ VÀ NHÓM CÂU HỎI PHẢI LÀ CHỮ SỐ ", "THÔNG BÁO",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			try {
				Database_AiLaTrieuPhu connect = new Database_AiLaTrieuPhu();
				Connection conn = connect.getConnection();

				PreparedStatement ps = conn.prepareStatement(
						"insert into ta_110_question(T_Question, T_Answer_A, T_Answer_B,  T_Answer_C, T_Answer_D, I_NumOfQuestion, I_GroupQuestion) values(?,?,?,?,?,?,?)");

				ps.setString(1, view_server.getTF_Question().getText());
				ps.setString(2, view_server.getTF_Answer_A().getText());
				ps.setString(3, view_server.getTF_Answer_B().getText());
				ps.setString(4, view_server.getTF_Answer_C().getText());
				ps.setString(5, view_server.getTF_Answer_D().getText());
				ps.setInt(6, Integer.parseInt(view_server.getTF_NumberOfQuestion().getText()));
				ps.setInt(7, Integer.parseInt(view_server.getTF_GroupOfQuestion().getText()));
				ps.executeUpdate();
				ps.close();
				
				this.Add_Answer(view_server);
				view_server.setTB_Table(Data());
			} catch (Exception e) {
				System.out.println();
			}
		}

	}

	// Add_Answer
	public void Add_Answer(View_Server view_server) {
				try {
				Database_AiLaTrieuPhu connect = new Database_AiLaTrieuPhu();
				Connection conn = connect.getConnection();

				PreparedStatement ps = conn.prepareStatement(
						"insert into ta_110_answer( I_ID_ANS, T_AnswerCorrect, T_Ratio_A ,  T_Ratio_B, T_Ratio_C, T_Ratio_D) values(?,?,?,?,?,?)");

				ps.setInt(1, getMaxId_Table());
				ps.setString(2, view_server.getTF_Answer_Correct().getText());
				ps.setString(3, view_server.getTF_Ratio_A().getText());
				ps.setString(4, view_server.getTF_Ratio_B().getText());
				ps.setString(5, view_server.getTF_Ratio_C().getText());
				ps.setString(6, view_server.getTF_Ratio_D().getText());
				ps.executeUpdate();
				ps.close();
				JOptionPane.showInternalMessageDialog(null, " THÊM THÀNH CÔNG ", "THÔNG BÁO",
						JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
			System.out.println(e);
		}
			}

	// Get_MaxId_Table
	public int getMaxId_Table() {
		int getmaxid_table = 0;
		try {
			Database_AiLaTrieuPhu connect = new Database_AiLaTrieuPhu();
			Connection conn = connect.getConnection();
			java.sql.Statement stm_Getdata = conn.createStatement();
			ResultSet rs_Data = ((java.sql.Statement) stm_Getdata)
					.executeQuery("SELECT * FROM ta_110_question ORDER BY I_ID DESC LIMIT 1");
			if (rs_Data.next()) {
				getmaxid_table = rs_Data.getInt("I_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return getmaxid_table;
	}

	// Delete
	public void Delete(View_Server view_server) {
		if(getNumber() >= 1 || getGroup() >= 1) {
			try {
			Database_AiLaTrieuPhu connect = new Database_AiLaTrieuPhu();
			Connection conn = connect.getConnection();
			java.sql.Statement stm_delete_data = conn.createStatement();

			ResultSet search_id = stm_delete_data
					.executeQuery("SELECT I_ID FROM ta_110_question WHERE I_NumOfQuestion = " + this.getNumber()
							+ " AND I_GroupQuestion = " + this.getGroup());
			int i_id_ans = 0;
			if (search_id.next()) {
				i_id_ans = search_id.getInt("I_ID");
			}

			stm_delete_data.executeUpdate("DELETE FROM ta_110_question WHERE I_ID = " + i_id_ans);
			stm_delete_data.executeUpdate("DELETE FROM ta_110_answer WHERE I_ID_ANS = " + i_id_ans);

			view_server.setTB_Table(Data());
				JOptionPane.showInternalMessageDialog(null, " XÓA THÀNH CÔNG ", "THÔNG BÁO",
						JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}else {
			JOptionPane.showInternalMessageDialog(null, " CHỌN MỤC CẦN XÓA ", "THÔNG BÁO",
					JOptionPane.INFORMATION_MESSAGE);
		}
			
		}
		
	}
