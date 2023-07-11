package Tess;

import Controllers.Controller_Game;
import Controllers.Controller_Login;
import Controllers.Controller_Server;
import Controllers.Controller_Start_Game;
import Models.Model_Game;
import Models.Model_Login;
import Models.Model_Start_Game;
import Views.View_Game;
import Views.View_Game_Over;
import Views.View_Login;
import Views.View_Server;
import Views.View_Start_Game;

public class Main_Tess {
public static void main(String args[]) {
	   View_Server sv = new View_Server();
	   Controller_Server ct = new Controller_Server(sv);

// View_Game_Over GV = new View_Game_Over();

//	View_Login lg = new View_Login();
//	Controller_Login lgg = new Controller_Login(lg);
//	Model_Login model_login = new Model_Login();
//	model_login.Star_Server();
	
//	View_Game game = new View_Game();
//	Model_Game mf = new Model_Game();
//	Controller_Game ctr = new Controller_Game(game, mf);

//	Model_Start_Game stt = new Model_Start_Game();
//	View_Start_Game st = new View_Start_Game();
//	Controller_Start_Game cst = new Controller_Start_Game(st,stt);
   }
}
