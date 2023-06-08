package Models;

import Controllers.Controller_Game;
import Controllers.Controller_Start_Game;
import Views.View_Game;
import Views.View_Start_Game;

public class Model_Start_Game {

	public Model_Start_Game() {

	}

	public void Stat_Game() {
		Model_Game model_game = new Model_Game();
		View_Game view_game = new View_Game();
		Controller_Game controller_game = new Controller_Game(view_game,model_game);
		 Thread clientThread = new Thread(new Thread_Game( view_game,model_game));
         clientThread.start();
	}
	
}
