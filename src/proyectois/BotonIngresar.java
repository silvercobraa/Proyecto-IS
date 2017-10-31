/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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

    private class Listener implements ActionListener{

        private void ingresar(){
            String usuario = _v.userText.getText();
            String contraseña = _v.passwordText.getText();
            System.out.println("Usuario: " + usuario + "\nContraseña: " + contraseña);
            if(usuario.equals("chilote") && contraseña.equals("culiao")){
                Principal p = new Principal();
                //System.exit(0);
                _v.setVisible(false);
                
            }
            else JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos","Error",JOptionPane.WARNING_MESSAGE);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            ingresar();
        }

      
    }
}
