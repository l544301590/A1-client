/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.gui.userinfo;

import fit5192.zz.repository.UserRepository;
import fit5192.zz.repository.entities.User_;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author 10759
 */
/*
1 need JTextField show the info of the user(How many)
2 need one button(button)
3 need two panel inputPanel buttonPanel
4 need container to add the panel
// create container  不太明白  整体的布局
        Container container = this.getContentPane();
        // set layout manager
        container.setLayout(new BorderLayout());
        this.buttonPanel.setLayout(new GridLayout(1, 4));
        this.inputPanel.setLayout(new GridLayout(5, 2));
 container.add(inputPanel, BorderLayout.NORTH);
 container.add(buttonPanel, BorderLayout.SOUTH);
*/
public class UserInfoGUI extends JFrame{
    private JLabel 
            idLabel,
            emailLabel,
            nicknameLabel,
            passwordLabel,
            levelLabel,
            lastNameLabel,
            FirstNameLabel,
            addressLabel,
            phoneLabel;

    private JTextField 
            idTextField,
            emailTextField,
            nicknameTextField,
            passwordTextField,
            levelTextField,
            lastNameTextField,
            FirstNameTextField,
            addressTextField,
            phoneTextField;
    private JButton updateButton;
    private JPanel buttonPanel,inputPanel;
    private UserRepository userRepository;
    
    public UserInfoGUI(String titleString, UserRepository userRepository,User_ user){
            
        this.idLabel = new JLabel("ID");
        this.emailLabel = new JLabel("Email");
        this.nicknameLabel = new JLabel("Nickname");
        this.passwordLabel = new JLabel("Password");
        this.levelLabel = new JLabel("Level");
        this.lastNameLabel = new JLabel("Lastname");
        this.FirstNameLabel = new JLabel("Firstname");
        this.addressLabel = new JLabel("Address");
        this.phoneLabel = new JLabel("Phone");

        this.idTextField = new JTextField(String.valueOf(user.getId()));
        this.emailTextField = new JTextField(user.getEmail());
        this.nicknameTextField = new JTextField(user.getNickname());
        this.passwordTextField = new JTextField(user.getPassword());
        this.levelTextField = new JTextField(user.getLevel());
        this.lastNameTextField = new JTextField(user.getLastName());
        this.FirstNameTextField = new JTextField(user.getFirstName());
        this.addressTextField = new JTextField(user.getAddress());
        this.phoneTextField = new JTextField(user.getPhone());
        
        this.userRepository=userRepository;
            
            // create panels
        this.inputPanel = new JPanel();
        this.buttonPanel = new JPanel();
        
        //create button
        this.updateButton = new JButton("Update");
        // create container
        Container container = this.getContentPane();
        // set layout manager
        container.setLayout(new BorderLayout());
        this.inputPanel.setLayout(new GridLayout(9,2));
        this.buttonPanel.setLayout(new GridLayout(1,1));
        
        this.inputPanel.add(idLabel);
        this.inputPanel.add(idTextField);
        
        this.inputPanel.add(emailLabel);
        this.inputPanel.add(emailTextField);
        
        this.inputPanel.add(nicknameLabel);
        this.inputPanel.add(nicknameTextField);
        
        this.inputPanel.add(passwordLabel);
        this.inputPanel.add(passwordTextField);
        
        this.inputPanel.add(levelLabel);
        this.inputPanel.add(levelTextField);
        
        this.inputPanel.add(lastNameLabel);
        this.inputPanel.add(lastNameTextField);
        
        this.inputPanel.add(FirstNameLabel);
        this.inputPanel.add(FirstNameTextField);
        
        this.inputPanel.add(addressLabel);
        this.inputPanel.add(addressTextField);
        
        this.inputPanel.add(phoneLabel);
        this.inputPanel.add(phoneTextField);
        
        this.buttonPanel.add(this.updateButton);

        container.add(inputPanel, BorderLayout.NORTH);
        container.add(buttonPanel, BorderLayout.SOUTH);
        
        //add event listener
        this.updateButton.addActionListener((event) -> {
            upadateUserInfo();
        });
        // change the default behaviour of the close button
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(650, 570);
        this.setVisible(true);
    }

    private void upadateUserInfo() {
        User_ user = createNewUser();
        try {
            userRepository.updateUser(user);
        } catch (Exception ex) {
            Logger.getLogger(UserInfoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 public User_ createNewUser() {
        String id = this.idTextField.getText();
        String email = this.emailTextField.getText();
        String nickname = this.nicknameTextField.getText();
        String password = this.passwordTextField.getText();
        String level = this.levelTextField.getText();
        String lastname = this.lastNameTextField.getText();
        String firstname = this.FirstNameTextField.getText();
        String address = this.addressTextField.getText();
        String phone = this.phoneTextField.getText();
        User_ user = new User_();
        if (id.length() > 0) {
            user.setId(Integer.parseInt(id));
        }
        if (email.length() > 0) {
            user.setEmail(email);
        }
        if (nickname.length() > 0) {
            user.setNickname(nickname);
        }
        if (password.length() > 0) {
            user.setPassword(password);
        }
        if (level.length() > 0) {
            user.setLevel(Integer.parseInt(level));
        }
        if (lastname.length() > 0) {
            user.setLastName(lastname);
        }
        if (firstname.length() > 0) {
            user.setFirstName(firstname);
        }
        if (address.length() > 0) {
            user.setAddress(address);
        }
        if (phone.length() > 0) {
            user.setPhone(phone);
        }
        return user;
    }
            
    
}
