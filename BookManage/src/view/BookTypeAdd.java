package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.BookTypeDao;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookTypeAdd extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAdd frame = new BookTypeAdd();
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
	public BookTypeAdd() {
		setIconifiable(true);
		setClosable(true);
		setTitle("ͼ���������");
		setBounds(400, 100, 700, 500);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("������ƣ�");
		label.setBounds(161, 72, 119, 18);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(265, 69, 196, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("�������");
		label_1.setBounds(161, 132, 105, 18);
		getContentPane().add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(265, 130, 265, 116);
		getContentPane().add(textArea);
		
		JButton commit = new JButton("�ύ");
		commit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeDao bookTypeDao = new BookTypeDao(); 
				String tname = textField.getText();
				String tdes = textArea.getText();
//				bookTypeDao.insertBooktype(tname, tdes);
				try {
					bookTypeDao.insertBooktype(tname, tdes);
					JOptionPane.showMessageDialog(BookTypeAdd.this,"ͼ����������ɹ�����");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(BookTypeAdd.this,"ͼ���������ʧ�ܣ���");
				}
			}
		});
		commit.setBounds(161, 322, 113, 27);
		getContentPane().add(commit);
		
		JButton reset = new JButton("����");
		reset.setBounds(386, 322, 113, 27);
		getContentPane().add(reset);
		
	}
}
