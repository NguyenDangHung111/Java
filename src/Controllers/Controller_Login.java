package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Model_Login;
import Views.View_Login;

public class Controller_Login implements ActionListener {
	
private Model_Login model_login;
	
	public Controller_Login(View_Login view_login) {
		model_login = new Model_Login();
		model_login.Star_Server();
		
		view_login.getBT_Login().addActionListener(new ActionListener() {
         
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				   model_login.Login(view_login);
			}
			
		});
		
		view_login.getBT_Logout().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view_login.dispose();
			}
			
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}


