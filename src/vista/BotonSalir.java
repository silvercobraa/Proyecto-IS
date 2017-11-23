/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo
 */
public class BotonSalir extends JButton {

    MenuPrincipal _menu;

    BotonSalir(MenuPrincipal menu) {
        super("Desconectar");
        _menu = menu;
        this.addActionListener(new Listener());
    }

    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            _menu.setVisible(false);
            Login login = new Login();
        }
    }
}
