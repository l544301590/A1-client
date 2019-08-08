/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.gui.register;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javafx.scene.control.TitledPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dylanz
 */
public class RegisterGUI extends JFrame {
    private JLabel 
            emailLabel, 
            passwordLabel, 
            password2Label;
    private JTextField 
            emailTextField,
            passwordTextField,
            password2TextField;
    private JButton 
            registerButton, 
            goLoginButton;
    
    public RegisterGUI(String titleString, ActionListener actionListener) {
        super(titleString);
        
        // new JLabel
        this.emailLabel = new JLabel();
        this.passwordLabel = new JLabel();
        this.password2Label = new JLabel();
        
        // new JTextField
        this.emailTextField = new JTextField("Please enter your email address");
        this.passwordTextField = new JTextField("Please set your password");
        this.password2TextField = new JTextField("Please repeat your password");
        
        // new JButton
        this.registerButton = new JButton("Register");
        this.goLoginButton = new JButton("Go Login");
        
        // add Listener for buttons
        this.registerButton.addActionListener(actionListener);
        this.goLoginButton.addActionListener(actionListener);
        
        // layouts
        JPanel mainPanel = new JPanel(new GridLayout(4, 2));
        
        mainPanel.add(this.emailLabel);
        mainPanel.add(this.emailTextField);
        mainPanel.add(this.passwordLabel);
        mainPanel.add(this.passwordTextField);
        mainPanel.add(this.password2Label);
        mainPanel.add(this.password2TextField);
        mainPanel.add(this.registerButton);
        mainPanel.add(this.goLoginButton);
        
        this.getContentPane().add(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setVisible(true);
    }

    public JButton getRegisterButton() {
        return this.registerButton;
    }

    public JButton getGoLoginButton() {
        return this.goLoginButton;
    }
    

}
