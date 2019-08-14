/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.gui.login;

import fit5192.zz.gui.products.ProductsGUI;
import fit5192.zz.gui.register.RegisterGUI;
import fit5192.zz.repository.ProductRepository;
import fit5192.zz.repository.RatingRepository;
import fit5192.zz.repository.TransactionRepository;
import fit5192.zz.repository.UserRepository;
import fit5192.zz.repository.entities.User_;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.ejb.EJB;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dylanz
 */
public class LoginGUI extends JFrame {
    private JLabel 
            emailLabel, 
            passwordLabel;
    private JTextField 
            emailTextField,
            passwordTextField;
    private JButton 
            goRegisterButton, 
            loginButton;

    private UserRepository userRepository;
    private TransactionRepository transactionRepository;
    private  ProductRepository productRepository;
    private  RatingRepository ratingRepository;
    
    public LoginGUI(String titleString, UserRepository userRepository) {
        super(titleString);
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
        this.ratingRepository = ratingRepository;
        // new JLabel
        this.emailLabel = new JLabel("Email");
        this.passwordLabel = new JLabel("Password");
        
        // new JTextField
        this.emailTextField = new JTextField("Please enter your email address");
        this.passwordTextField = new JTextField("Please set your password");
        
        // new JButton
        this.goRegisterButton = new JButton("Go Register");
        this.loginButton = new JButton("Login");
        
        // add Listener for buttons
        this.goRegisterButton.addActionListener((event) -> {
            goRegister();
        });
        this.loginButton.addActionListener((event) -> {
            login();
        });
        
        // layouts
        JPanel mainPanel = new JPanel(new GridLayout(3, 2));
        
        mainPanel.add(this.emailLabel);
        mainPanel.add(this.emailTextField);
        mainPanel.add(this.passwordLabel);
        mainPanel.add(this.passwordTextField);
        mainPanel.add(this.goRegisterButton);
        mainPanel.add(this.loginButton);
        
        this.getContentPane().add(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setVisible(true);
    }

    public JButton getGoRegisterButton() {
        return goRegisterButton;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
    
    private void login() {
        String email = this.emailTextField.getText();
        String password = this.passwordTextField.getText();
//        try {
//            List<User_> users = userRepository.searchUserByEmail(email);
//            if (users.size() == 1) {
//                new ProductsGUI("products", productRepository)
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    
    private void goRegister() {
        new RegisterGUI("register", userRepository,transactionRepository,productRepository,ratingRepository);
        this.dispose();
    }
}
