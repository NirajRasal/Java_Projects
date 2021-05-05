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


public class Billing_System extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    int i;
    private JFrame frame;
    private JTextField textField;
    private JTextField textField_3;
    private JCheckBox NewCheckBox;
    private JCheckBox NewCheckBox_1;
    private JCheckBox NewCheckBox_2;
    private JCheckBox NewCheckBox_3;
    private JCheckBox NewCheckBox_4;
    private JCheckBox NewCheckBox_5;
    private JTextArea textArea;
    int no=1;                       //order id

    public Billing_System() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 424, 570);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Name:");
        lblNewLabel.setBounds(10, 11, 46, 14);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(49, 8, 95, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

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

        JLabel lblNewLabel_6 = new JLabel("Total Bill:");
        lblNewLabel_6.setBounds(10, 313, 56, 14);
        frame.getContentPane().add(lblNewLabel_6);

        textArea = new JTextArea();
        textArea.setBounds(58, 329, 300, 185);
        frame.getContentPane().add(textArea);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.setBounds(80, 282, 89, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Clear");
        btnNewButton_1.setBounds(236, 282, 89, 23);
        frame.getContentPane().add(btnNewButton_1);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            //submit button

                String custname = textField.getText();

                Date date = new Date();

                int qty = Integer.parseInt(textField_3.getText());

                double rate = 0;
                String coffee = "";
                String coldC = "";
                String blackC = "";
                String mocha = "";
                String Tea = "";
                String BTea = "";

                if (NewCheckBox.isSelected()) {     //coffee
                    rate = rate+30;
                    coffee = "Coffee";
                }
                if (NewCheckBox_1.isSelected()) {   //cold coffee
                    rate = rate+40;
                    coldC = "Cold Coffee";
                }
                if (NewCheckBox_2.isSelected()) {   //black coffee
                    rate = rate+50;
                    blackC = "Black Coffee";
                }
                if (NewCheckBox_3.isSelected()) {   //Mocha
                    rate = rate+60;
                    mocha = "Mocha";
                }
                if (NewCheckBox_4.isSelected()) {   //Tea
                    rate = rate+20;
                    Tea = "Tea";
                }
                if (NewCheckBox_5.isSelected()) {   //Black Tea
                    rate = rate+30;
                    BTea = "Black Tea";
                }

                // Total amount is calculated
                int totalpayable = (int) (rate * qty);
                //   to get Order no and name

                String name=textField.getText();	//name
                toDatabase(no,name,totalpayable);

                // Displays order details
                // String item_order[coffee,blackC,coldC,mocha,Tea];
                textArea.setText("Hello, your Order Id is: " + no +
                        "\nDate: " + date.toString()
                        + "\nName: " + custname +
                        "\nIteams Ordered:\n");

                no++; //autoincrement Order no

                if(coffee == "Coffee") {
                    textArea.append(coffee+"\n");
                }
                if(blackC == "Black Coffee") {
                    textArea.append(blackC+"\n");
                }
                if(coldC == "Cold Coffee") {
                    textArea.append(coldC+"\n");
                }
                if(mocha == "Mocha") {
                    textArea.append(mocha+"\n");
                }
                if(Tea == "Tea") {
                    textArea.append(Tea+"\n");
                }
                if(BTea == "Black Tea") {
                    textArea.append(BTea+"\n");
                }
                textArea.append("\nAMOUNT PAYABLE IS: " + totalpayable);
            }

        });

        btnNewButton_1.addActionListener(new ActionListener() { // clear button
            public void actionPerformed(ActionEvent e) {

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
                    Billing_System window = new Billing_System();
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
            java.util.Date javaDate = new java.util.Date();
            java.sql.Date mySQLDate = new java.sql.Date(javaDate.getTime());

            String password="nik1995march";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system",password);
            stmt=con.createStatement();
            //String sql = "INSERT INTO BILL(NO,NAME,AMOUNT) VALUES(?,?,?)";
            String sql = "INSERT INTO BILL(NO,NAME,AMOUNT,Order_date) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,no);
            ps.setString(2,name);
            ps.setInt(3,amount);
            ps.setDate(4,mySQLDate);
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
