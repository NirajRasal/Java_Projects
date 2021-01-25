import java.awt.EventQueue;
import java.io.Serial;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.*;
import java.util.Date;

public class Billing_system extends javax.swing.JFrame {

	/**
	 *
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	int i;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JCheckBox NewCheckBox;
	private JCheckBox NewCheckBox_1;
	private JCheckBox NewCheckBox_2;
	private JCheckBox NewCheckBox_3;
	private JCheckBox NewCheckBox_4;
	private JCheckBox NewCheckBox_5;
	private JTextArea textArea;
	int no;
	public Billing_system() {
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

		JLabel lblNewLabel_3 = new JLabel("Menu:");
		lblNewLabel_3.setBounds(10, 67, 37, 14);
		frame.getContentPane().add(lblNewLabel_3);

		NewCheckBox = new JCheckBox("Coffee");
		NewCheckBox.setBounds(31, 97, 97, 23);
		frame.getContentPane().add(NewCheckBox);

		NewCheckBox_1 = new JCheckBox("Cold Coffee");
		NewCheckBox_1.setBounds(31, 123, 97, 23);
		frame.getContentPane().add(NewCheckBox_1);

		NewCheckBox_2 = new JCheckBox("Black Coffee");
		NewCheckBox_2.setBounds(31, 149, 97, 23);
		frame.getContentPane().add(NewCheckBox_2);

		NewCheckBox_3 = new JCheckBox("Mocha");
		NewCheckBox_3.setBounds(31, 175, 97, 23);
		frame.getContentPane().add(NewCheckBox_3);

		NewCheckBox_4 = new JCheckBox("Tea");
		NewCheckBox_4.setBounds(168, 97, 97, 23);
		frame.getContentPane().add(NewCheckBox_4);

		NewCheckBox_5 = new JCheckBox("Black Tea");
		NewCheckBox_5.setBounds(168, 123, 97, 23);
		frame.getContentPane().add(NewCheckBox_5);

		JLabel lblNewLabel_5 = new JLabel("Quantity:");
		lblNewLabel_5.setBounds(10, 243, 56, 14);
		frame.getContentPane().add(lblNewLabel_5);

		textField_3 = new JTextField();
		textField_3.setBounds(66, 240, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		//////////////////////////////////////////////////////////

		/*JLabel lblNewLabel_9 = new JLabel("Order:"); // order id database
		lblNewLabel_9.setBounds(217, 243, 56, 14);
		frame.getContentPane().add(lblNewLabel_9);

		JTextField textField_4 = new JTextField();
		textField_4.setBounds(256, 240, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);*/

		///////////////////////////////////////////////////////////
		JLabel lblNewLabel_6 = new JLabel("Total Bill:");
		lblNewLabel_6.setBounds(10, 313, 56, 14);
		frame.getContentPane().add(lblNewLabel_6);

		textArea = new JTextArea();
		textArea.setBounds(58, 329, 298, 91);
		frame.getContentPane().add(textArea);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(80, 282, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBounds(236, 282, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {            //submit button
                i= Integer.parseInt(textField_1.getText());         //minnor bug
                i++;
                textField_1.setText(""+i);

				String custname = textField.getText();

				Date date = new Date();

				int qty = Integer.parseInt(textField_3.getText());

				double rate = 0;

				if (NewCheckBox.isSelected()) {     //coffee
					rate = rate+30;
				}
				if (NewCheckBox_1.isSelected()) {   //cold coffee
					rate = rate+40;
				}
				if (NewCheckBox_2.isSelected()) {   //black coffee
					rate = rate+50;
				}
				if (NewCheckBox_3.isSelected()) {   //Mocha
					rate = rate+60;
				}
				if (NewCheckBox_4.isSelected()) {   //Tea
					rate = rate+20;
				}
				if (NewCheckBox_5.isSelected()) {   //Black Tea
					rate = rate+30;
				}

				// Total amount is calculated
				int totalpayable = (int) (rate * qty);
//////////////////////////////////////////////////////////////////////////////   to get Order no and name
                String noo=textField_1.getText(); //order id
                String name=textField.getText();	//name

                try{
                    no=Integer.parseInt(noo);
                }
                catch(NumberFormatException ex)
                {
                    ex.printStackTrace();
                }
                toDatabase(no,name,totalpayable);
//////////////////////////////////////////////////////////////////////////////
                                                                                        // Displays order details
				textArea.setText("Hello, your Order Id is: " + textField_1.getText() +
                        "\nDate: " + date.toString()
						+ "\nName: " + custname +
                        "\nAMOUNT PAYABLE IS: " + totalpayable);
			}

		});

		btnNewButton_1.addActionListener(new ActionListener() { // clear button
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");

				textField.setText("");

				textField_3.setText("");

				NewCheckBox.setSelected(false);
				NewCheckBox_1.setSelected(false);
				NewCheckBox_2.setSelected(false);
				NewCheckBox_3.setSelected(false);
				NewCheckBox_4.setSelected(false);
				NewCheckBox_5.setSelected(false);

				// Displays order details
				textArea.setText("");
			}
		});

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Billing_system window = new Billing_system();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void toDatabase(int no, String name,int amount)
	{
		Connection con;
		Statement stmt;
		try
		{
		    //set Databasepassword below and then execute the program
		    //String password=Databasepassword;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system",password);
			stmt=con.createStatement();
			String sql = "INSERT INTO BILL(NO,NAME,AMOUNT) VALUES(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,no);
            ps.setString(2,name);
            ps.setInt(3,amount);
            ps.executeUpdate();
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

}