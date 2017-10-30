/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;

/**
 *
 * @author pauloolivares
 */
public class Ventana extends JFrame {

    JPanel loginPanel;
    JTextField userText;
    JPasswordField passwordText;

    public Ventana() {
        super("Basura IS");
        this.setSize(300, 170);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel login = new JPanel();
        login.setLayout(null);

        JLabel userLabel = new JLabel("Usuario");
        userLabel.setBounds(10, 10, 80, 25);
        login.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        login.add(userText);

        JLabel passwordLabel = new JLabel("Contraseña");
        passwordLabel.setBounds(10, 40, 80, 25);
        login.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        login.add(passwordText);

        BotonIngresar loginButton = new BotonIngresar(this);
        loginButton.setBounds(10, 100, 100, 25);
        login.add(loginButton);

        BotonRecuperar registerButton = new BotonRecuperar("Recuperar Contraseña");
        registerButton.setBounds(180, 100, 100, 25);
        login.add(registerButton);

        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        this.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);

        this.add(login);
        this.setVisible(true);
    }
}
