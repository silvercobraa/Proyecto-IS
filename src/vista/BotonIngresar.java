/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author pauloolivares
 */
public class BotonIngresar extends JButton {

    Login _v;

    public BotonIngresar(Login v) {
        super("Ingresar");
        _v = v;
        this.addActionListener(new Listener());
    }

    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String usuario = _v.userText.getText();
            //String contraseña = _v.passwordText.getText();
            String contraseña = new String(_v.passwordText.getPassword());
            System.out.println(contraseña);
            if (validarUsuario(usuario, contraseña)) {
                try {
                    MenuPrincipal p = new MenuPrincipal(usuario);
                } catch (SQLException ex) {
                    Logger.getLogger(BotonIngresar.class.getName()).log(Level.SEVERE, null, ex);
                }
                _v.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        boolean validarUsuario(String elUsr, String elPw) {
            try {
                String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
                Connection unaConexion = DriverManager.getConnection(url, "bdi2017t", "bdi2017t");
                Statement instruccionSQL = unaConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT correo,contrasena FROM trabajador WHERE correo='" + elUsr + "' AND contrasena='" + elPw + "'");
                return resultadosConsulta.first();
            } catch (SQLException e) {
                return false;
            }
        }
    }
}
