package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import dao.UserDao;
import model.User;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	
	
	public static void setUIFont()
	{
		Font f = new Font("宋体",Font.PLAIN,20);
		String   names[]={ "Label", "CheckBox", "PopupMenu","MenuItem", "CheckBoxMenuItem",
				"JRadioButtonMenuItem","ComboBox", "Button", "Tree", "ScrollPane",
				"TabbedPane", "EditorPane", "TitledBorder", "Menu", "TextArea",
				"OptionPane", "MenuBar", "ToolBar", "ToggleButton", "ToolTip",
				"ProgressBar", "TableHeader", "Panel", "List", "ColorChooser",
				"PasswordField","TextField", "Table", "Label", "Viewport",
				"RadioButtonMenuItem","RadioButton", "DesktopPane", "InternalFrame"
		}; 
		for (String item : names) {
			 UIManager.put(item+ ".font",f); 
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//setUIFont();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 434);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logo = new JLabel("图书管理系统");
		logo.setFont(new Font("宋体", Font.BOLD, 30));
		logo.setIcon(new ImageIcon(LoginView.class.getResource("/imges/logo.png")));
		logo.setBounds(183, 54, 317, 61);
		contentPane.add(logo);
		
		JLabel label = new JLabel("用户名：");
		label.setBounds(190, 167, 72, 18);
		contentPane.add(label);
		
		username = new JTextField();
		username.setBounds(264, 164, 199, 24);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setBounds(190, 221, 72, 18);
		contentPane.add(label_1);
		
		password = new JPasswordField();
		password.setBounds(264, 218, 199, 24);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton login = new JButton("登录");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = username.getText();
				String word = password.getText();
				UserDao dao = new UserDao();
				User user = dao.login(name, word);
				if(user!=null){
					new MainView().setVisible(true);
					LoginView.this.setVisible(false);
				}
			}
		});
		login.setBounds(190, 290, 113, 27);
		contentPane.add(login);
		
		JButton reset = new JButton("重置");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		reset.setBounds(350, 290, 113, 27);
		contentPane.add(reset);
	}

}
