package Models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import Controllers.Controller_Server;
import Views.View_Login;
import Views.View_Server;

public class Model_Client_Login {
	
	private Socket         socket;
    private BufferedReader in;
    private PrintWriter    out;

    public Model_Client_Login() {
        try {
            socket = new Socket("localhost", 8888);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
        	 System.out.println(e);
        }
    }

    //Login
    public void Login(View_Login view_login) {
        try {
            // Gửi tên đăng nhập và mật khẩu đến server
            out.println(view_login.getTF_Account().getText());
            out.println(view_login.getTF_Password().getText());

            // Đọc kết quả xác thực từ server
            String response = in.readLine();
           if(response.equals("successful")) {
        	   JOptionPane.showInternalMessageDialog(null, " ĐĂNG NHẬP THÀNH CÔNG ", "THÔNG BÁO",
						JOptionPane.CANCEL_OPTION);
        	   View_Server        view_server  = new View_Server();
        	   Controller_Server  model_server = new Controller_Server(view_server);
        	   view_login.dispose();
           }else if(response.equals("False")){
        	   JOptionPane.showInternalMessageDialog(null, " TÀI KHOẢN HOẶC MẬT KHẨU KHÔNG ĐÚNG ", "THÔNG BÁO",
						JOptionPane.CANCEL_OPTION);
           }

            // Đóng kết nối với server
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
