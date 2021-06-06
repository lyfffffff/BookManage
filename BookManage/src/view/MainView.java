package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


public class MainView<Login> extends JFrame {

	private JPanel contentPane;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		setLocationRelativeTo(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.BLACK);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("图书数据维护");
		mnNewMenu.setForeground(Color.BLUE);
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("图书类别管理");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem menuItem = new JMenuItem("类别增加");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAdd btadd = new BookTypeAdd();
				desktopPane.add(btadd);
				btadd.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("类别维护");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeEdit typeEdit = new BookTypeEdit();
				
				desktopPane.add(typeEdit);
				typeEdit.setVisible(true);
			}
		});
		mnNewMenu_1.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("图书管理");
		mnNewMenu.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("图书新增");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddView bookAddView = new BookAddView();
				
				desktopPane.add(bookAddView);
				bookAddView.setVisible(true);
			}
		});
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("图书维护");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookEditView bookEditView = new BookEditView();
				
				desktopPane.add(bookEditView);
				bookEditView.setVisible(true);
			}
		});
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_5 = new JMenuItem("安全退出");
		mnNewMenu.add(menuItem_5);
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView loginview=new LoginView();
				loginview.setVisible(true);
				//不加this会报错
				MainView.this.setVisible(false);
			}
		});
		JMenu menu = new JMenu("关于我们");
		menu.setForeground(Color.BLUE);
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(menu);
		
		JMenuItem menuItem_4 = new JMenuItem("关于我们");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutView aboutView = new AboutView();
				aboutView.setLocation(400, 100);
				desktopPane.add(aboutView);
				aboutView.setVisible(true);
			}
		});
		menu.add(menuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setIcon(new ImageIcon(MainView.class.getResource("/imges/bg.jpg")));
		lblNewLabel.setBounds(162, 29, 992, 575);
		desktopPane.add(lblNewLabel);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
