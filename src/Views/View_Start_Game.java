package Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_Start_Game extends JFrame{

	private JButton BT_Start;
	private JButton BT_Exit;
	
	public View_Start_Game () {
		setTitle("Start Game");
		setSize(1032,562);
		getContentPane().setLayout(null);
		
	    BT_Start = new JButton("BẮT ĐẦU");		
	    BT_Start.setBounds(390, 205, 216, 65);
		getContentPane().add(BT_Start);
		
		BT_Exit = new JButton("THOÁT");
		BT_Exit.setBounds(403, 328, 203, 56);
		getContentPane().add(BT_Exit);
		setVisible(true);
		
		
	}

	public JButton getBT_Start() {
		return BT_Start;
	}

	public void setBT_Start(JButton bT_Start) {
		BT_Start = bT_Start;
	}

	public JButton getBT_Exit() {
		return BT_Exit;
	}

	public void setBT_Exit(JButton bT_Exit) {
		BT_Exit = bT_Exit;
	}
}
