package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Model_Game;
import Models.Model_Start_Game;
import Views.View_Start_Game;

public class Controller_Start_Game {

	public Controller_Start_Game(View_Start_Game view_start_game,Model_Start_Game  model_start_game) {
		
		view_start_game.getBT_Start().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view_start_game.dispose();
				 model_start_game.Stat_Game();
				 
			}
			
		});
		
		view_start_game.getBT_Exit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view_start_game.dispose();
			}
			
		});
	}
}
