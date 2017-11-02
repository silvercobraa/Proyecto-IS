/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author ByPal
 */
public class SimularBeneficio extends JFrame {

    ArrayList<String> medicamentos;
    ArrayList<String> medicos;
    ArrayList<String> examenes;

    public SimularBeneficio() {

        super("Simular Beneficio");
        this.setSize(640, 480);
        this.setResizable(true);
        this.setLayout(new GridLayout(4, 2));

        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        this.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);

        JPanel jp = new JPanel();
        initListaMedicamentos();
        jp.setLayout(new GridLayout(medicamentos.size(), 1));
        for (int i = 0; i < medicamentos.size(); i++) {
            jp.add(new JCheckBox(medicamentos.get(i)));
        }
        JScrollPane sp = new JScrollPane(jp);

        JPanel jp2 = new JPanel();
        initListaMedicos();
        jp2.setLayout(new GridLayout(medicos.size(), 1));
        for (int i = 0; i < medicos.size(); i++) {
            jp2.add(new JCheckBox(medicos.get(i)));
        }
        JScrollPane sp2 = new JScrollPane(jp2);

        JPanel jp3 = new JPanel();
        initListaExamenes();
        jp3.setLayout(new GridLayout(examenes.size(), 1));
        for (int i = 0; i < examenes.size(); i++) {
            jp3.add(new JCheckBox(examenes.get(i)));
        }
        JScrollPane sp3 = new JScrollPane(jp3);

        sp.getVerticalScrollBar().setUnitIncrement(16);
        sp2.getVerticalScrollBar().setUnitIncrement(16);
        sp3.getVerticalScrollBar().setUnitIncrement(16);
        jp.setBackground(Color.YELLOW);
        jp2.setBackground(Color.WHITE);
        jp3.setBackground(Color.WHITE);

        this.add(new JLabel("Lista de Medicamentos"));
        this.add(sp);
        this.add(new JLabel("Lista de Médicos"));
        this.add(sp2);
        this.add(new JLabel("Lista de Exámenes"));
        this.add(sp3);
        this.add(new JButton("Simular"));
        this.setVisible(true);
    }

    public void initListaMedicamentos() {
        medicamentos = new ArrayList();
        String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
        String contraseña = null;
        try {
            Connection unaConexion = DriverManager.getConnection(url, "bdi2017t", "bdi2017t");
            Statement instruccionSQL = unaConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("select nombre, dosis, presentacion from medicamento");
            while (resultadosConsulta.next()) {
                String a = resultadosConsulta.getString(1);
                String b = resultadosConsulta.getString(2);
                String c = resultadosConsulta.getString(3);
                String d = a + " - " + b + " - " + c;
                medicamentos.add(d);
            }
            unaConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(BotonRecuperarContraseña.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initListaMedicos() {
        medicos = new ArrayList();
        String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
        String contraseña = null;
        try {
            Connection unaConexion = DriverManager.getConnection(url, "bdi2017t", "bdi2017t");
            Statement instruccionSQL = unaConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("select rut,nombre,especialidad from medico");
            while (resultadosConsulta.next()) {
                String a = resultadosConsulta.getString(1);
                String b = resultadosConsulta.getString(2);
                String c = resultadosConsulta.getString(3);
                String d = a + " - " + b + " - " + c;
                medicos.add(d);
            }
            unaConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(BotonRecuperarContraseña.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initListaExamenes() {
        examenes = new ArrayList();
        String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
        String contraseña = null;
        try {
            Connection unaConexion = DriverManager.getConnection(url, "bdi2017t", "bdi2017t");
            Statement instruccionSQL = unaConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("select e.nombre, cm.nombre, c.costo from cexamen as c,examen as e, centrosmedicos as cm where c.examen=e.id and cm.id=c.centro");
            while (resultadosConsulta.next()) {
                String a = resultadosConsulta.getString(1);
                String b = resultadosConsulta.getString(2);
                String c = resultadosConsulta.getString(3);
                String d = a + " - " + b + " - " + c;
                examenes.add(d);
            }
            unaConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(BotonRecuperarContraseña.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
