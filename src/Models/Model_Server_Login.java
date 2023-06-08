package Models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Configs.Database_AiLaTrieuPhu;

public class Model_Server_Login {
    private ServerSocket serverSocket;
    private Object lock;

    public Model_Server_Login() {
        try {
            this.serverSocket = new ServerSocket(8888);
            this.lock = new Object();
        } catch (Exception e) {
        	 System.out.println(e);
        }
    }

    public void start() {
        try {
            while (true) {
                Socket clientSocket = this.serverSocket.accept();
                System.out.println("okk");
                // Tạo một luồng riêng để xử lý yêu cầu từ client
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (Exception e) {
        	 System.out.println(e);
        }
    }

    private boolean authenticateUser(String username, String password) {
        synchronized (lock) {
            try {
            	
            	Database_AiLaTrieuPhu connection = new Database_AiLaTrieuPhu();
            	Connection conn = connection.getConnection();
                // Truy vấn cơ sở dữ liệu để kiểm tra tên đăng nhập và mật khẩu
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM ta_110_account WHERE T_ACCOUNT = ? AND T_PASSWORD = ?");
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();

                return resultSet.next(); // true nếu tìm thấy người dùng, ngược lại false

            } catch (Exception e) {
            	 System.out.println(e);
            }
            return false;
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Tạo luồng đọc và ghi dữ liệu cho client
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Đọc tên đăng nhập và mật khẩu từ client
                String username = in.readLine();
                String password = in.readLine();

                // Kiểm tra tên đăng nhập và mật khẩu trong cơ sở dữ liệu
                boolean isAuthenticated = authenticateUser(username, password);

                // Gửi kết quả xác thực về cho client
                if (isAuthenticated) {
                    out.println("successful");
                } else {
                    out.println("False");
                }

                // Đóng kết nối với client
                in.close();
                out.close();
                clientSocket.close();
            } catch (Exception e) {
            	 System.out.println(e);
            }
        }
    }
}
