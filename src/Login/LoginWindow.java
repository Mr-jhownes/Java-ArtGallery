

package Login;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jonathan Santos
 */
public class LoginWindow extends JFrame {
    
    private JLabel label;
    private JLabel label2;
    private JTextField txtfield;
    private JTextField txtfield2;
    private LoginController controllerInternalRef;
    
    
    
    public LoginWindow(LoginController controller) {
        
        this.controllerInternalRef = controller;
        
        attributesSetter();
        components();
        validation();
        
    }
    
    private void attributesSetter(){
        
        this.setVisible(true);
        this.setSize(250,300);
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }
    
    private void components(){
        
      JPanel p = new JPanel();
      this.add(p);
     
      label = new JLabel();
      label.setText("Username");
      txtfield = new JTextField(20);
      
      label2= new JLabel();
      label2.setText("Password");
       txtfield2 = new JTextField(20);
        
       label.setBounds(80, 100, 200, 30);
       
        
        label2.setBounds(80, 140, 200, 30);
        txtfield.setBounds(200, 100, 200, 30);
        txtfield2.setBounds(200, 140, 200, 30); 
        
       JButton btn = new JButton("Login");
        btn.addActionListener((ActionListener) controllerInternalRef);
        btn.setActionCommand("b");
        
        JButton btn2 = new JButton("Register");
        btn2.addActionListener((ActionListener) controllerInternalRef);
        btn2.setActionCommand("b2");
        
        
        
        
        p.add(label);
        p.add(txtfield);
        p.add(label2);
        p.add(txtfield2);
        
        p.add(btn);
        p.add(btn2);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
       

        
        
    }
    
    private void validation(){
    this.validate();
    this.repaint();
    
    }
     public String getUsername(){
        return txtfield.getText();
    }
    public String getPassword(){
        return txtfield2.getText();
    }

}
    
    
    
    



