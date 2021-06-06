package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class AboutView extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutView frame = new AboutView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AboutView() {
		setClosable(true);
		setIconifiable(true);
		setTitle("关于我们");
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(null);
		
		JLabel lblJavawang = new JLabel("这里是关于我们~");
		lblJavawang.setForeground(new Color(255, 0, 0));
		lblJavawang.setFont(new Font("宋体", Font.PLAIN, 40));
		lblJavawang.setBounds(148, 151, 480, 99);
		getContentPane().add(lblJavawang);

	}
}
