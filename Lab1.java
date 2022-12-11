package Day2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lab1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private static int nid=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab1 window = new Lab1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lab1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame("Hibernate CRUD Sample using SWT");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 435);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JFrame frame2 = new JFrame();
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.DARK_GRAY));
		panel.setBounds(10, 11, 418, 378);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 83, 29);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener((KeyListener) new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= 'A') && (c <= 'z') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SPACE))) {
		
		        e.consume();
		      }
		    }
		  });
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(115, 11, 293, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(10, 51, 83, 29);
		panel.add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener((KeyListener) new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= 'A') && (c <= 'z') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SPACE))) {
		
		        e.consume();
		      }
		    }
		  });

		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(115, 51, 293, 29);
		panel.add(textField_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(10, 91, 83, 29);
		panel.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(115, 91, 293, 29);
		panel.add(textField_2);
		
		JButton btnNewButton = new JButton("Save");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField_2.getText();
				String emailPatern = 
					    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			    if (!email.matches(emailPatern)) {
			    	String message = "<html><body><div width='120px' align='center'>Enter a valid Email!</div></body></html>";
			    	JOptionPane.showMessageDialog(frame2, message, "", JOptionPane.WARNING_MESSAGE);
			    }else {
			    	nid++;
			    	DefaultTableModel model = (DefaultTableModel) table.getModel();
			    	model.addRow(new Object[] {textField.getText(), textField_1.getText(), textField_2.getText(), nid});
			    	textField.setText("");
			    	textField_1.setText("");
			    	textField_2.setText("");
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(55, 142, 97, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField_2.getText();
				String emailPatern = 
					    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			    if (!email.matches(emailPatern)) {
			    	String message = "<html><body><div width='120px' align='center'>Enter a valid Email!</div></body></html>";
			    	JOptionPane.showMessageDialog(frame2, message, "", JOptionPane.WARNING_MESSAGE);
			    }else {
			    	int i = table.getSelectedRow();
			    	DefaultTableModel model = (DefaultTableModel) table.getModel();
			    	model.setValueAt(textField.getText(), i, 0);
			    	model.setValueAt(textField_1.getText(), i, 1);
			    	model.setValueAt(textField_2.getText(), i, 2);
			    	textField.setText("");
			    	textField_1.setText("");
			    	textField_2.setText("");
			    }
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(162, 142, 97, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int getSelectedRowForDeletion = table.getSelectedRow();
				model.removeRow(getSelectedRowForDeletion);
				textField.setText("");
		    	textField_1.setText("");
		    	textField_2.setText("");
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(269, 142, 97, 29);
		panel.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(27, 193, 369, 174);
		panel.add(scrollPane);
			
		table = new JTable();
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//DefaultTableModel modeltest = new DefaultTableModel(null, null)
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Email", "ID"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(69);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setPreferredWidth(25);
	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				String tableName = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
				String tableFamily = model.getValueAt(table.getSelectedRow(), 1).toString();
				String tableEmail = model.getValueAt(table.getSelectedRow(), 2).toString();
				textField.setText(tableName);
				textField_1.setText(tableFamily);
				textField_2.setText(tableEmail);
			}
		});
	
	}

}
