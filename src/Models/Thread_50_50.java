package Models;

import Views.View_Game;

public class Thread_50_50 implements Runnable {

	private View_Game view_game;	
	private Model_Game model_game;	

	
	public Thread_50_50(View_Game view_game,Model_Game model_game) {
		this.view_game= view_game;
		this.model_game =  model_game;
	}	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		model_game.Help_50_50(view_game);
	}

}
