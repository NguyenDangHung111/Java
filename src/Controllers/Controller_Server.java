package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import Models.Model_Server;
import Views.View_Server;

public class Controller_Server implements ActionListener, MouseListener {
	private View_Server view_server;
	private Model_Server model_server;

	public Controller_Server(View_Server view_server) {
		this.view_server = view_server;

		// Even_Mouse
		this.view_server.getTB_Table().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = view_server.getTB_Table().getSelectedRow();

				view_server.setTF_Question((String) view_server.getTB_Table().getValueAt(row, 0));
				view_server.setTF_Answer_A((String) view_server.getTB_Table().getValueAt(row, 1));
				view_server.setTF_Answer_B((String) view_server.getTB_Table().getValueAt(row, 2));
				view_server.setTF_Answer_C((String) view_server.getTB_Table().getValueAt(row, 3));
				view_server.setTF_Answer_D((String) view_server.getTB_Table().getValueAt(row, 4));
				view_server.setTF_Ratio_A((String) view_server.getTB_Table().getValueAt(row, 5));
				view_server.setTF_Ratio_B((String) view_server.getTB_Table().getValueAt(row, 6));
				view_server.setTF_Ratio_C((String) view_server.getTB_Table().getValueAt(row, 7));
				view_server.setTF_Ratio_D((String) view_server.getTB_Table().getValueAt(row, 8));
				view_server.setTF_Answer_Correct((String) view_server.getTB_Table().getValueAt(row, 9));
				view_server.setTF_NumberOfQuestion((String) view_server.getTB_Table().getValueAt(row, 10));
				view_server.setTF_GroupOfQuestion((String) view_server.getTB_Table().getValueAt(row, 11));

				model_server = new Model_Server();
				model_server.setGroup(Integer.parseInt((String) view_server.getTB_Table().getValueAt(row, 11)));
				model_server.setNumber(Integer.parseInt((String) view_server.getTB_Table().getValueAt(row, 10)));
			}

		});

		// Update
		this.view_server.getBT_Edit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model_server = new Model_Server();
				model_server.updata_Question(view_server);

			}
		});
		// Refresh
		this.view_server.getBT_Refresh().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view_server.setTF_Question("");
				view_server.setTF_Answer_A("");
				view_server.setTF_Answer_B("");
				view_server.setTF_Answer_C("");
				view_server.setTF_Answer_D("");
				view_server.setTF_Answer_Correct("");
				view_server.setTF_NumberOfQuestion("");
				view_server.setTF_GroupOfQuestion("");
				view_server.setTF_Ratio_A("");
				view_server.setTF_Ratio_B("");
				view_server.setTF_Ratio_C("");
				view_server.setTF_Ratio_D("");
				model_server.setGroup(0);
				model_server.setNumber(0);
			}

		});

		// Add
		this.view_server.getBT_Add().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model_server = new Model_Server();
				model_server.Add_Question(view_server);

			}

		});

		// Delete
		this.view_server.getBT_Delete().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				model_server = new Model_Server();
				model_server.Delete(view_server);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
