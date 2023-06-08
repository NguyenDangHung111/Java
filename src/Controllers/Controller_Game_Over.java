package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Model_Game_Over;
import Views.View_Game_Over;
import Views.View_Start_Game;

public class Controller_Game_Over {

	public Controller_Game_Over(View_Game_Over view_game_over) {
		
		view_game_over.getBT_GiaiThuong().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view_game_over.dispose();
				Model_Game_Over model_game_over = new Model_Game_Over();
				model_game_over.Exit();
			}
			
		});
	}
}
