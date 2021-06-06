package view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.BookDao;
import dao.BookTypeDao;
import model.Book;
import model.BookType;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class BookEditView extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private BookDao bookDao = new BookDao();
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_5;
	private JTextField textField_6;
	BookTypeDao bookTypeDao = new BookTypeDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookEditView frame = new BookEditView();
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
	public BookEditView() {
		setIconifiable(true);
		setClosable(true);
		setBounds(400, 10, 800, 650);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("图书名称：");
		label.setBounds(54, 39, 86, 18);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(129, 36, 175, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("作者：");
		label_1.setBounds(333, 39, 72, 18);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(385, 36, 175, 24);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bname = textField.getText();
				String author = textField_1.getText();
				init(bname,author);
			}
		});
		button.setBounds(599, 35, 113, 27);
		getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 87, 670, 167);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u6027\u522B", "\u51FA\u7248\u793E", "\u4EF7\u683C", "\u7C7B\u522B", "\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		table.getColumnModel().getColumn(5).setPreferredWidth(105);
		scrollPane.setViewportView(table);
		
		JLabel label_2 = new JLabel("编号：");
		label_2.setBounds(52, 297, 72, 18);
		getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(92, 294, 140, 24);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("图书名称：");
		label_3.setBounds(342, 294, 86, 18);
		getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(415, 291, 195, 24);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("作者：");
		label_4.setBounds(52, 345, 72, 18);
		getContentPane().add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(92, 342, 142, 24);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_5 = new JLabel("性别：");
		label_5.setBounds(369, 345, 45, 18);
		getContentPane().add(label_5);
		
		JRadioButton radioButton = new JRadioButton("男");
		buttonGroup.add(radioButton);
		radioButton.setBounds(415, 341, 52, 27);
		getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("女");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(473, 341, 157, 27);
		getContentPane().add(radioButton_1);
		
		JLabel label_6 = new JLabel("出版社：");
		label_6.setBounds(37, 391, 72, 18);
		getContentPane().add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(92, 388, 140, 24);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_7 = new JLabel("价格：");
		label_7.setBounds(369, 391, 45, 18);
		getContentPane().add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(415, 388, 195, 24);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_8 = new JLabel("类别：");
		label_8.setBounds(51, 439, 45, 18);
		getContentPane().add(label_8);
		
		JComboBox comboBox = new JComboBox();
		List<BookType> btlist = bookTypeDao.queryBookType(null);
		String[] ss = new String[btlist.size()];
		for(int i=0;i<btlist.size();i++){
			ss[i]=btlist.get(i).getTname();
		}
		comboBox.setModel(new DefaultComboBoxModel(ss));
		comboBox.setBounds(92, 436, 140, 24);
		getContentPane().add(comboBox);
		
		JLabel label_9 = new JLabel("描述：");
		label_9.setBounds(50, 487, 59, 18);
		getContentPane().add(label_9);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(92, 470, 396, 61);
		getContentPane().add(textArea);
		
		JButton button_1 = new JButton("修改");
		button_1.setBounds(92, 558, 113, 27);
		getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid = textField_2.getText();
				String bname = textField_3.getText();
				String author = textField_4.getText();
				boolean man = radioButton.isSelected();
				boolean women = radioButton_1.isSelected();
				String publish = textField_5.getText();
				String price = textField_6.getText();
				String type = comboBox.getSelectedItem().toString();
				String id = String.valueOf(bookTypeDao.queryBookType(type).get(0).getId());
				String bdes = textArea.getText();
				Book book = new Book();
				book.setBid(Integer.parseInt(bid));
				book.setBname(bname);
				book.setAuthor(author);
				book.setSex(man?"男":"女");
				book.setPublish(publish);
				book.setPrice(Double.parseDouble(price));
				book.setType(Integer.parseInt(id));
				book.setBdes(bdes);
				bookDao.updateBook(book);
				JOptionPane.showMessageDialog(null, "图书修改成功！");
			}
		});
		JButton button_2 = new JButton("删除");
		button_2.setBounds(328, 558, 113, 27);
		getContentPane().add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid = textField_2.getText();
				bookDao.deleteBook(bid);
				JOptionPane.showMessageDialog(null, "图书删除成功！");
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String id = table.getValueAt(row, 0).toString();
				String bname = table.getValueAt(row, 1).toString();
				String author = table.getValueAt(row, 2).toString();
				String  sex = table.getValueAt(row, 3).toString();
				String publish = table.getValueAt(row, 4).toString();
				String price = table.getValueAt(row, 5).toString();
				String btname = table.getValueAt(row, 6).toString();
				String desc = table.getValueAt(row, 7).toString();
				textField_2.setText(id);
				textField_3.setText(bname);
				textField_4.setText(author);
				if(sex.equals("男")){
					radioButton.setSelected(true);
				}else{
					radioButton_1.setSelected(true);
				}
				textField_5.setText(publish);
				textField_6.setText(price);
				comboBox.setSelectedItem(btname);
				textArea.setText(desc);
			}
		});
		init(null,null);
	}
	
	public void init(String bname,String author){
		List<Book> queryBook = bookDao.queryBook(bname, author);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		for(Book book : queryBook){
			model.addRow(new Object[]{book.getBid(),book.getBname(),book.getAuthor(),book.getSex(),book.getPublish(),
					book.getPrice(),book.getTname(),book.getBdes()});
		}
	}
}
