/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz;

import fit5192.zz.gui.register.RegisterGUI;
import fit5192.zz.repository.entities.User_;
import fit5192.zz.services.UserService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.ejb.EJB;
import javax.swing.SwingUtilities;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author dylanz
 */
public class A1Client implements ActionListener {

    /**
     * @param args the command line arguments
     */
    private RegisterGUI gui;

    @EJB
    private static UserService userService;

    public A1Client() {
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == gui.getRegisterButton()) {
            this.register();
        } else if (event.getSource() == gui.getGoLoginButton()) {
            System.out.println("Go to Login");
            System.exit(0);
        }
    }

    private void register() {
        User_ user = new User_("a@qq.com", "dylan", "12345678qwe%");
        String res = userService.register(user);
        System.out.println(res);
    }

    public void initView() {
        this.gui = new RegisterGUI("test", this);
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
