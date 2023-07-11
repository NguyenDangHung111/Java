package Models;

import Controllers.Controller_Start_Game;
import Views.View_Start_Game;

public class Model_Game_Over {

	public Model_Game_Over() {
		
	}
	
	public void Exit() {
		Model_Start_Game model_start_game = new Model_Start_Game();
		View_Start_Game       view_start_game = new View_Start_Game();
		Controller_Start_Game controller_start_game = new Controller_Start_Game(view_start_game,model_start_game);
	}
}
