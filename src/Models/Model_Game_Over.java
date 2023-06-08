package Models;

import Controllers.Controller_Start_Game;
import Views.View_Start_Game;

public class Model_Game_Over {

	public Model_Game_Over() {
		
	}
	
	public void Exit() {
		View_Start_Game       view_start_game = new View_Start_Game();
		Controller_Start_Game controller_start_game = new Controller_Start_Game(view_start_game);
	}
}
