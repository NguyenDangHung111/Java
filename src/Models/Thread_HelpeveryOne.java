package Models;

import javax.swing.JOptionPane;

import Views.View_Game;

public class Thread_HelpeveryOne implements Runnable{

	private View_Game view_game;	
	private Model_Game model_game;	
	
	public Thread_HelpeveryOne(View_Game view_game,Model_Game model_game) {
		this.view_game= view_game;
		this.model_game =  model_game;
	}	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// Tạo một mảng các lựa chọn cho Dialog
					Object[] options = { "CẢM ƠN" };
		// Hiển thị JOptionPane với nút chọn 
		int choice = JOptionPane.showOptionDialog(null, "A: "+model_game.getRatio_A()+"\nB: "+model_game.getRatio_B()+"\nC: "+model_game.getRatio_C()+"\nD: "+model_game.getRatio_D(), "TRỢ GIÚP TỪ MỌI NGƯỜI", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		// Xử lý kết quả từ người dùng
		if (choice == JOptionPane.YES_OPTION) {

		}
	}

}
