package Models;

import Views.View_Game;
import Views.View_Game_Over;

public class Thread_Game implements Runnable{

	private View_Game view_game;	
	private Model_Game model_game;	

	
	public Thread_Game(View_Game view_game,Model_Game model_game) {
		this.view_game= view_game;
		this.model_game =  model_game;
	}	
	
	@Override
	public void run() {
		int groupOfQuestion = model_game.GroupOfQuestion();
		int numberOfQuestion = model_game.NumberOfQuestion();
		// TODO Auto-generated method stub
	    if(numberOfQuestion > 10) {
	    	view_game.dispose();
	    	model_game.Game_Over(view_game);
	    }else {
	    	this.model_game.Select_Sound(numberOfQuestion);
		this.model_game.Reset_Button(view_game);
		this.model_game.LB_CountDown_Time(this.view_game);
		this.model_game.LB_Money(this.view_game,numberOfQuestion);
		this.model_game.LB_Number_Question(this.view_game,numberOfQuestion);
		this.model_game.LB_Question(view_game, numberOfQuestion, groupOfQuestion);
		this.model_game.LB_Answer_A(view_game, numberOfQuestion, groupOfQuestion);
		this.model_game.LB_Answer_B(view_game, numberOfQuestion, groupOfQuestion);
		this.model_game.LB_Answer_C(view_game, numberOfQuestion, groupOfQuestion);
		this.model_game.LB_Answer_D(view_game, numberOfQuestion, groupOfQuestion);
		this.model_game.Answer_Correct(numberOfQuestion, groupOfQuestion);
	    }
		
		
	}

}
