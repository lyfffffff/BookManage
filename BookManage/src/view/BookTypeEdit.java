package view;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.BookTypeDao;
import model.BookType;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookTypeEdit extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textArea;
	BookTypeDao typeDao = new BookTypeDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeEdit frame = new BookTypeEdit();
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
	public BookTypeEdit() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		setBounds(400, 10, 700, 642);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u641C\u7D22\uFF1A");
		label.setBounds(116, 72, 105, 18);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(223, 69, 177, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tname = textField.getText();
//				根据类型名查询
				init(tname);
			}
		});
		button.setBounds(436, 68, 113, 27);
		getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(116, 131, 450, 184);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				System.out.println(row);
				String id = table.getValueAt(row, 0).toString();
				String btname = table.getValueAt(row, 1).toString();
				String btdesc = table.getValueAt(row, 2).toString();
				textField_1.setText(id);
				textField_2.setText(btname);
				textArea.setText(btdesc);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\u7F16\u53F7", "\u540D\u79F0", "\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(121);
		table.getColumnModel().getColumn(1).setPreferredWidth(136);
		table.getColumnModel().getColumn(2).setPreferredWidth(177);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u7C7B\u522B\u7EF4\u62A4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(116, 351, 456, 242);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7");
		label_1.setBounds(14, 33, 72, 18);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(62, 30, 105, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u540D\u79F0\uFF1A");
		lblNewLabel.setBounds(14, 76, 72, 18);
		panel.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(62, 73, 216, 24);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("\u63CF\u8FF0\uFF1A");
		label_2.setBounds(14, 119, 72, 18);
		panel.add(label_2);
		
		textArea = new JTextArea();
		textArea.setBounds(62, 117, 291, 66);
		panel.add(textArea);
		
		JButton button_1 = new JButton("\u786E\u5B9A");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField_1.getText();
				String tname = textField_2.getText();
				String tdes = textArea.getText();
				typeDao.updateBookType(id, tname, tdes);
				JOptionPane.showMessageDialog(null, "图书类别修改成功！");
			}
		});
		button_1.setBounds(60, 202, 113, 27);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u91CD\u7F6E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField_1.getText();
				typeDao.deleteBookType(id);
				JOptionPane.showMessageDialog(null, "图书类别删除成功！");
			}
		});
		button_2.setBounds(258, 202, 113, 27);
		panel.add(button_2);
		//查询所有
		init(null);
	}
	
	public void init(String tname){
		
		List<BookType> queryBookType = typeDao.queryBookType(tname);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		for(BookType bt : queryBookType){
			model.addRow(new Object[]{bt.getId(),bt.getTname(),bt.getTdes()});
		}
	}
}
