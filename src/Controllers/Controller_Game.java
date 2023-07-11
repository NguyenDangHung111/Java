package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.Model_Game;
import Models.Thread_50_50;
import Models.Thread_Game;
import Models.Thread_HelpeveryOne;
import Views.View_Game;

public class Controller_Game {

	public Controller_Game(View_Game view_game, Model_Game model_game) {

		// OUT_GAME
		view_game.getBT_Exit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model_game.Sound_Buttton();
				model_game.Out_Game(view_game);
			}

		});

		// HELP 50/50
		view_game.getBT_50_50().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model_game.Sound_50_50();
				view_game.getBT_50_50().setVisible(false);
				Thread help  = new Thread(new Thread_50_50(view_game, model_game));
				try {
					help.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				help.run();
				model_game.getClip().stop();
			}
		});

		// HELP NEXT
		view_game.getBT_Next().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model_game.Sound_Buttton();
				view_game.getLblNewLabel_2().setVisible(false);
				view_game.getBT_Next().setVisible(false);
				model_game.Next(view_game);
				model_game.getTimer().stop();
				model_game.getClip().stop();
				Thread clientThread = new Thread(new Thread_Game(view_game, model_game));
				clientThread.start();
			}
		});

		// HELP OF EVERY ONE
		view_game.getBT_Ratio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model_game.Sound_Every_One();
				view_game.getLblIcon().setVisible(false);
				view_game.getBT_Ratio().setVisible(false);
				Thread help = new Thread(new Thread_HelpeveryOne(view_game,model_game));
				try {
					Thread.sleep(5000);
					help.run();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model_game.getTimer().stop();
			}
		});

		// ANSWER A
		view_game.getA().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model_game.Select_A();
				model_game.getClip().stop();

				try {
					Thread clientThread = new Thread(new Thread_Game(view_game, model_game));
					if (model_game.Check_Answer(view_game.getA())) {
						model_game.getTimer().stop();
						Thread.sleep(5000);
						view_game.Color_Correct(view_game.getA());
						model_game.Correct_A();
						Thread.sleep(3000);
						clientThread.start();
					} else {
						Thread.sleep(5000);
						view_game.Color_Incorrect(view_game.getA());
						model_game.Sound_Incorrect();
						model_game.getTimer().stop();
						Thread.sleep(3000);
						view_game.dispose();
						model_game.Game_Over(view_game);
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
		
		view_game.getB().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        model_game.Select_B();
		        model_game.getClip().stop();

		        try {
		            Thread clientThread = new Thread(new Thread_Game(view_game, model_game));
		            if (model_game.Check_Answer(view_game.getB())) {
		                model_game.getTimer().stop();
		                Thread.sleep(5000);
		                view_game.Color_Correct(view_game.getB());
		                model_game.Correct_B();
		                clientThread.interrupt();
		                Thread.sleep(3000);
		                clientThread.start();
		            } else {
		                view_game.Color_Incorrect(view_game.getB());
		                Thread.sleep(5000);
		                model_game.Sound_Incorrect();
		                model_game.getTimer().stop();
		                Thread.sleep(3000);
		                view_game.dispose();
		                model_game.Game_Over(view_game);
		            }
		        } catch (Exception ex) {
		            System.out.println(ex);
		        }
		    }
		});


		// ANSWER C
		view_game.getC().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model_game.Select_C();
				model_game.getClip().stop();
				try {
					Thread clientThread = new Thread(new Thread_Game(view_game, model_game));
					if (model_game.Check_Answer(view_game.getC())) {
						model_game.getTimer().stop();
						clientThread.sleep(5000);
						view_game.Color_Correct(view_game.getC());
						model_game.Correct_C();
						clientThread.sleep(3000);
						clientThread.start();
					} else {
						view_game.Color_Incorrect(view_game.getC());
						Thread.sleep(5000);
						model_game.Sound_Incorrect();
						model_game.getTimer().stop();
						Thread.sleep(3000);
						view_game.dispose();
						model_game.Game_Over(view_game);
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

		// ANSWER D
		view_game.getD().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Phát âm thanh
				model_game.Select_D();
				model_game.getClip().stop();

				try {
					Thread clientThread = new Thread(new Thread_Game(view_game, model_game));

					if (model_game.Check_Answer(view_game.getD())) {
						model_game.getTimer().stop();
						view_game.Color_Correct(view_game.getD());
						Thread.sleep(5000);
						model_game.Correct_D();
						Thread.sleep(3000);
						clientThread.start();
					} else {
						Thread.sleep(5000);
						model_game.getTimer().stop();
						view_game.Color_Incorrect(view_game.getD());
						model_game.Sound_Incorrect();
						Thread.sleep(3000);
						view_game.dispose();
						model_game.Game_Over(view_game);
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

	}

}
