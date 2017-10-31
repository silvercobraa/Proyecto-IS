/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        super("Servicio Médico");
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

        //Listener l = new Listener();
        //passwordText.addKeyListener(l);
        //userText.addKeyListener(l);
        this.add(login);

        this.setVisible(true);
    }

    private class Listener implements KeyListener{

        Ventana _v;

        public void Listener(Ventana v) {
            _v = v;

        }

        private void ingresar() {
            String usuario = _v.userText.getText();
            String contraseña = _v.passwordText.getText();
            System.out.println("Usuario: " + usuario + "\nContraseña: " + contraseña);
            if (usuario.equals("chilote") && contraseña.equals("culiao")) {
                Principal p = new Principal();
                //System.exit(0);
                _v.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            System.out.println("WEA");
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                ingresar(); 
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }
    }
}
