/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;

/**
 *
 * @author ByPal
 */
public class MenuPrincipal extends JFrame {

    JPanel loginPanel;
    JTextField userText;
    JPasswordField passwordText;
    String _user;

    public MenuPrincipal(String user) throws SQLException {
        super("Servicio Médico");
        this.setSize(800, 600);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        _user = user;

        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        this.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);

        PanelFondo pf = new PanelFondo();
        JPanel wea = new JPanel();

        BotonSimulacionBeneficio jb = new BotonSimulacionBeneficio(user);
        BotonSolicitudDevolucion jb2 = new BotonSolicitudDevolucion(user);
        BotonHistorialDevoluciones jb3 = new BotonHistorialDevoluciones(user);
        JButton jb4 = new JButton("Salir");

        String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
        String str;
        try (Connection unaConexion = DriverManager.getConnection(url, "bdi2017t", "bdi2017t")) {
            Statement instruccionSQL = unaConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT nombre FROM trabajador WHERE correo='" + _user + "'");
            resultadosConsulta.next();
            str = "Usuario: " + resultadosConsulta.getString(1);
        }
        JLabel weaita = new JLabel(str);

        wea.add(jb);
        wea.add(jb2);
        wea.add(jb3);
        wea.add(jb4);

        this.add(weaita, BorderLayout.SOUTH);
        this.add(wea, BorderLayout.NORTH);
        this.add(pf);
        this.setVisible(true);
    }
}
