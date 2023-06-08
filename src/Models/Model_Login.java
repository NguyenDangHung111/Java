package Models;

import javax.swing.JOptionPane;
import Views.View_Login;
public class Model_Login {

	public Model_Login() {
		
	}

	public void Star_Server() {
		// Server
		Model_Server_Login model_server = new Model_Server_Login();
		model_server.start();
	}

	public void Login(View_Login view_login) {
		if (view_login.getTF_Account().getText().isEmpty() || view_login.getTF_Password().getText().isEmpty()) {
			JOptionPane.showInternalMessageDialog(null, " NHẬP THÔNG TIN CÒN THIẾU ", "THÔNG BÁO",
					JOptionPane.CANCEL_OPTION);
		} else {
			// Client
			Model_Client_Login client = new Model_Client_Login();
			client.Login(view_login);
		}

	}
}

