import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.*;

public class billing extends javax.swing.JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private JCheckBox chckbxNewCheckBox_3;
	private JCheckBox chckbxNewCheckBox_4;
	private JCheckBox chckbxNewCheckBox_5;
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billing window = new billing();
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
	public billing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 444, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(49, 8, 95, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Order ID:");
		lblNewLabel_1.setBounds(222, 11, 56, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(280, 8, 99, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Date:");
		lblNewLabel_2.setBounds(10, 58, 37, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(42, 55, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Menu:");
		lblNewLabel_3.setBounds(10, 102, 37, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		chckbxNewCheckBox = new JCheckBox("Coffee");
		chckbxNewCheckBox.setBounds(31, 123, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		chckbxNewCheckBox_1 = new JCheckBox("Cold Coffee");
		chckbxNewCheckBox_1.setBounds(31, 149, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("Black Coffee");
		chckbxNewCheckBox_2.setBounds(31, 175, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		
		chckbxNewCheckBox_3 = new JCheckBox("Mocha");
		chckbxNewCheckBox_3.setBounds(31, 201, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox_3);
		
		chckbxNewCheckBox_4 = new JCheckBox("Tea");
		chckbxNewCheckBox_4.setBounds(168, 123, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox_4);
		
	    chckbxNewCheckBox_5 = new JCheckBox("Black Tea");
		chckbxNewCheckBox_5.setBounds(168, 149, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox_5);
		
		JLabel lblNewLabel_5 = new JLabel("Quantity:");
		lblNewLabel_5.setBounds(10, 243, 56, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 240, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Total Bill:");
		lblNewLabel_6.setBounds(10, 313, 56, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textArea = new JTextArea();
		textArea.setBounds(58, 329, 298, 91);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(80, 282, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(236, 282, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e)
			{
				int orderno = Integer.parseInt(textField_1.getText()); 
				
				String custname = textField.getText(); 
				
				int qty = Integer.parseInt(textField_3.getText()); 
				
				double rate = 0;  
				  
				if (chckbxNewCheckBox.isSelected()) { 
				    rate = 30; 
				} 
				if (chckbxNewCheckBox_1.isSelected()) { 
					rate = 40;  
				} 
				if (chckbxNewCheckBox_2.isSelected()) { 
					rate = 50;  
				} 
				if (chckbxNewCheckBox_3.isSelected()) { 
					rate = 60;  
				}
				if (chckbxNewCheckBox_4.isSelected()) { 
					rate = 20;  
				} 
				if (chckbxNewCheckBox_5.isSelected()) { 
					rate = 30;  
				} 

				
				// Total amount is calculated 
				double totalpayable  = (rate * qty); 
				 
				  
				// Displays order details 
				textArea .setText( 
				        "Hello, your Order Id is: " + orderno 
				        + "\nName: " + custname 
				        + "\nAMOUNT PAYABLE IS: " + totalpayable);
			}  
			});
	           
	}


}
