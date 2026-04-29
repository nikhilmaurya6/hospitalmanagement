import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
class Login extends JFrame implements ActionListener {
  JTextField textField;
  JPasswordField jPasswordField;
  JButton b1,b2;
    Login() {
        JLabel namelabel = new JLabel("Username:");
        namelabel.setBounds(40, 20, 100,30);
        namelabel.setFont(new Font("Arial", Font.BOLD,16));
        add(namelabel);

        textField=new JTextField();
        textField.setBounds(150, 20, 150, 30);
        add(textField);

        JLabel password = new JLabel("Password:");
        password.setBounds(40, 70, 100, 30);
        password.setFont(new Font("Arial", Font.BOLD,16));
        add(password);

        jPasswordField  = new JPasswordField();
        jPasswordField.setBounds(150, 70, 150, 30);
        add(jPasswordField);

        b1=new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        add(b1);
         
        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        add(b2);



        getContentPane().setBackground(new Color(173, 216, 230)); // Light blue background
        setSize(400, 250);
        setLocation(400, 270);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
     
     public void actionPerformed(ActionEvent e){
     if(e.getSource()==b1){
     try{
      Conn c=new Conn();
     String user=textField.getText();
     String pass = new String(jPasswordField.getPassword());
     
     String q="select*from login where ID='"+user+"'and PW='"+pass+"'";
     ResultSet resultSet=c.statement.executeQuery(q);
     
     if(resultSet.next()){
     new Test();
     setVisible(false);
     }
      else{
       JOptionPane.showMessageDialog(null,"invalid");
      }
      }
      catch(Exception E){
      E.printStackTrace();
      }
       }
      else{
         System.exit(10);
    }
     }
    public static void main(String[] args) {
        new Login();
    }
}
