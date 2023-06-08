package Controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Model_Game;
import Models.Thread_Game;
import Views.View_Game;
import Views.View_Start_Game;

public class Controller_Game {
	
	public Controller_Game(View_Game view_game,Model_Game model_game) {

		// OUT_GAME
		view_game.getBT_Exit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view_game.dispose();
				model_game.Out_Game();
			}

		});

		// HELP 50/50
		view_game.getBT_50_50().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view_game.getBT_50_50().setVisible(false);
			}

		});

		// HELP NEXT
		view_game.getBT_Next().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view_game.getBT_Next().setVisible(false);
			}

		});

		// HELP DELETE ANSWER INCORRECT
		view_game.getBT_Ratio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view_game.getBT_Ratio().setVisible(false);
			}

		});

		// ANSWER A
		view_game.getA().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(model_game.Button_A(view_game)) {
					 Thread clientThread = new Thread(new Thread_Game( view_game,model_game));
			         clientThread.start();
				}else {
					model_game.Game_Over();
				}
						
			}

		});

		// ANSWER B
		view_game.getB().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(model_game.Button_B(view_game)) {
					 Thread clientThread = new Thread(new Thread_Game( view_game,model_game));
			         clientThread.start();
				}else {
					model_game.Game_Over();
				}
			}

		});

		// ANSWER C
		view_game.getC().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(model_game.Button_C(view_game)) {
					 Thread clientThread = new Thread(new Thread_Game( view_game,model_game));
			         clientThread.start();
				}else {
					model_game.Game_Over();
				}
			}

		});

		// ANSWER D
		view_game.getD().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(model_game.Button_D(view_game)) {
					 Thread clientThread = new Thread(new Thread_Game( view_game,model_game));
			         clientThread.start();
				}else {
					model_game.Game_Over();
				}
			}

		});

	}

}
