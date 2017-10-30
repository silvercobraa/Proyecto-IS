/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;

/**
 *
 * @author pauloolivares
 */
public class BotonIngresar extends JButton {

    Ventana _v;

    public BotonIngresar(Ventana v) {
        super("Ingresar");
        _v = v;
        this.addActionListener(new Listener());
    }

    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String usuario = _v.userText.getText();
            String contraseña = _v.passwordText.getText();
            System.out.println("Usuario: " + usuario + "\nContraseña: " + contraseña);
            System.exit(0);
        }
    }
}
