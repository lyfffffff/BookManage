package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.BookDao;
import dao.BookTypeDao;
import model.Book;
import model.BookType;

public class BookAddView extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_2;
	private JTextField textField_3;
	BookTypeDao bookTypeDao = new BookTypeDao();
	BookDao bookDao = new BookDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddView frame = new BookAddView();
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
	public BookAddView() {
		
		setIconifiable(true);
		setClosable(true);
		setTitle("图书添加");
		setBounds(400, 100, 700, 504);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("图书名称：");
		label.setBounds(70, 43, 86, 18);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(156, 40, 209, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("作者：");
		label_1.setBounds(70, 88, 86, 18);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(156, 85, 209, 24);
		getContentPane().add(textField_1);
		
		label_2 = new JLabel("性别：");
		label_2.setBounds(70, 133, 72, 18);
		getContentPane().add(label_2);
		
		JRadioButton radioButton = new JRadioButton("男");
		radioButton.setSelected(true);
		buttonGroup.add(radioButton);
		radioButton.setBounds(154, 129, 72, 27);
		getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("女");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(229, 129, 86, 27);
		getContentPane().add(radioButton_1);
		
		JLabel label_3 = new JLabel("出版社：");
		label_3.setBounds(70, 179, 86, 18);
		getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(156, 176, 209, 24);
		getContentPane().add(textField_2);
		
		JLabel label_4 = new JLabel("价格：");
		label_4.setBounds(70, 226, 86, 18);
		getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(156, 223, 209, 24);
		getContentPane().add(textField_3);
		
		JLabel label_5 = new JLabel("类别：");
		label_5.setBounds(70, 273, 72, 18);
		getContentPane().add(label_5);
		
		JComboBox comboBox = new JComboBox();
		
		List<BookType> btlist = bookTypeDao.queryBookType(null);
		String[] ss = new String[btlist.size()];
		for(int i=0;i<btlist.size();i++){
			ss[i]=btlist.get(i).getTname();
		}
		comboBox.setModel(new DefaultComboBoxModel(ss));
		comboBox.setBounds(156, 270, 209, 21);
		getContentPane().add(comboBox);
		
		
		JLabel label_6 = new JLabel("描述：");
		label_6.setBounds(70, 315, 72, 18);
		getContentPane().add(label_6);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(156, 313, 317, 78);
		getContentPane().add(textArea);
		
		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bname = textField.getText();
				String author = textField_1.getText();
				boolean man = radioButton.isSelected();
				boolean women = radioButton_1.isSelected();
				String publish = textField_2.getText();
				String price = textField_3.getText();
				String type = comboBox.getSelectedItem().toString();
				String bid = String.valueOf(bookTypeDao.queryBookType(type).get(0).getId());
				String bdes = textArea.getText();
				
				Book book = new Book();
				book.setBname(bname);
				book.setAuthor(author);
				book.setSex(man?"男":"女");
				book.setPublish(publish);
				book.setPrice(Double.parseDouble(price));
				book.setType(Integer.parseInt(bid));
				book.setBdes(bdes);
				bookDao.insertBook(book);
				JOptionPane.showMessageDialog(null, "图书添加成功");
			}
		});
		button.setBounds(156, 410, 113, 27);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("重置");
		button_1.setBounds(355, 410, 113, 27);
		getContentPane().add(button_1);

	}
}
