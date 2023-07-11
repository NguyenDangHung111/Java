package Models;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Controllers.Controller_Game;
import Controllers.Controller_Start_Game;
import Views.View_Game;
import Views.View_Start_Game;

public class Model_Start_Game {

	public Model_Start_Game() {

	}

	public void Stat_Game() {
		try {
			Thread.sleep(5000);			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Model_Game model_game = new Model_Game();
		View_Game view_game = new View_Game();
		model_game.Sound_Game();
		Controller_Game controller_game = new Controller_Game(view_game, model_game);		
		Thread clientThread = new Thread(new Thread_Game(view_game, model_game));
		clientThread.start();
			
	}

	public void Sound_Star() {
		try {
			File soundFile = new File("D://Eclipse/AiLaTrieuPhu/src/Sound/amthanhbatdautrochoi.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
