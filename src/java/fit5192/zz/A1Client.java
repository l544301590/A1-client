/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz;

import fit5192.zz.gui.login.LoginGUI;
import fit5192.zz.gui.register.RegisterGUI;
import fit5192.zz.repository.UserRepository;
import fit5192.zz.repository.entities.User_;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.ejb.EJB;
import javax.swing.SwingUtilities;

/**
 *
 * @author dylanz
 */
public class A1Client {
    // abc
    /**
     * @param args the command line arguments
     */
    @EJB
    private static UserRepository userRepository;
    
    public A1Client() {
        
    }

    public void initView() {
        new RegisterGUI("register", userRepository);
    }

    public static void main(String[] args) {
        try {
            final A1Client client = new A1Client();

            SwingUtilities.invokeLater(() -> {
                client.initView();
            });          
        } catch (Exception ex) {
            System.out.println("Failed to run application: " + ex.getMessage());
        }
    }

}
