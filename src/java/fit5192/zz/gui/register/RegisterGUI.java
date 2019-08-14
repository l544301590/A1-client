/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.gui.register;

import fit5192.zz.gui.login.LoginGUI;
import fit5192.zz.repository.ProductRepository;
import fit5192.zz.repository.RatingRepository;
import fit5192.zz.repository.TransactionRepository;
import fit5192.zz.repository.UserRepository;
import fit5192.zz.repository.entities.Product;
import fit5192.zz.repository.entities.Rating;
import fit5192.zz.repository.entities.Transaction_;
import fit5192.zz.repository.entities.User_;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private JLabel emailLabel,
            passwordLabel,
            password2Label;
    private JTextField emailTextField,
            passwordTextField,
            password2TextField;
    private JButton registerButton,
            goLoginButton;

    private UserRepository userRepository;
    private TransactionRepository transactionRepository;
    private  ProductRepository productRepository;
    private  RatingRepository ratingRepository;

    public RegisterGUI(String titleString, UserRepository userRepository,TransactionRepository transactionRepository,ProductRepository productRepository,RatingRepository ratingRepository) {
        super(titleString);
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
        this.ratingRepository = ratingRepository;
        
        // new JLabel
        this.emailLabel = new JLabel("Email");
        this.passwordLabel = new JLabel("Password");
        this.password2Label = new JLabel("Password2");

        // new JTextField
        this.emailTextField = new JTextField();
        this.passwordTextField = new JTextField();
        this.password2TextField = new JTextField();

        // new JButton
        this.registerButton = new JButton("Register");
        this.goLoginButton = new JButton("Go Login");

        // add Listener for buttons
        this.registerButton.addActionListener((event) -> {
            register();
        });
        this.goLoginButton.addActionListener((event) -> {
            goLogin();
        });

        // layouts
        JPanel mainPanel = new JPanel(new GridLayout(4, 2));

        mainPanel.add(this.emailLabel);
        mainPanel.add(this.emailTextField);
        mainPanel.add(this.passwordLabel);
        mainPanel.add(this.passwordTextField);
        mainPanel.add(this.password2Label);
        mainPanel.add(this.password2TextField);
        mainPanel.add(this.goLoginButton);
        mainPanel.add(this.registerButton);

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

    private void register() {
        String email = this.emailTextField.getText();
        String password = this.passwordTextField.getText();
        String password2 = this.password2TextField.getText();

        if (password.equals(password2)) {
            User_ user = new User_(email, password);
            try {
                userRepository.addUser(user);
                System.out.println("YYYYYYYYY");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // TODO show popup window
            System.err.println("Passwords don't match!");
        }
    }

    private void goLogin() {
        //new LoginGUI("login", userRepository);
        //this.dispose();
        //Date now =new Date();
       // Product pro=new Product("strawberry",2,"berry",10,21);
        //List<Product> proList=new ArrayList<Product>();
        //proList.add(pro);
        //User_ user=new User_("aaa@qq.com","12345678f.123");
        //Rating rating=new Rating(5,pro,user);
        Product pro=new Product();
        pro.setCategory(1);
        pro.setPrice(4);
       

        try {
            //userRepository.addUser(user);
            //productRepository.addProduct(pro);
            //Product pro1=productRepository.searchProductById(113);
            //proList.add(pro1);
            //Transaction_ tran = new Transaction_(now,proList,user);
            //transactionRepository.addTransaction(tran);
            //ratingRepository.addRating(rating);
            productRepository.searchProductByAnyAttribute(pro);
        } catch (Exception ex) {
            Logger.getLogger(RegisterGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }
}
