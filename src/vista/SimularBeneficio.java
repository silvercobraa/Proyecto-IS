/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ByPal
 */
public class SimularBeneficio extends JFrame {

    ArrayList<String> cargas;
    ArrayList<String> medicamentos;
    ArrayList<String> medicos;
    ArrayList<String> examenes;
    String _user;

    public SimularBeneficio(String user) {
        super("Simular Beneficio");
        this.setSize(900, 480);
        this.setResizable(true);
        this.setMinimumSize(new Dimension(900,480));
        this.setLayout(new GridLayout(1,2));
        _user = user;

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

        JPanel jp4 = new JPanel();
        initListaCargas();
        jp4.setLayout(new GridLayout(cargas.size(), 1));
        for (int i = 0; i < cargas.size(); i++) {
            jp4.add(new JCheckBox(cargas.get(i)));
        }
        JScrollPane sp4 = new JScrollPane(jp4);

        sp.getVerticalScrollBar().setUnitIncrement(15);
        sp2.getVerticalScrollBar().setUnitIncrement(15);
        sp3.getVerticalScrollBar().setUnitIncrement(15);
        sp4.getVerticalScrollBar().setUnitIncrement(15);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel izq = new JPanel();
        JPanel der = new JPanel();
        izq.setLayout(new GridLayout(4,1));
        der.setLayout(new GridLayout(4,1));
        
        izq.add(new JLabel("Lista de cargas"));
        der.add(sp4);
        izq.add(new JLabel("Lista de Medicamentos"));
        der.add(sp);
        izq.add(new JLabel("Lista de Médicos"));
        der.add(sp2);
        izq.add(new JLabel("Lista de Exámenes"));
        der.add(sp3);
        panel.add(izq,BorderLayout.WEST);
        panel.add(der,BorderLayout.CENTER);
        this.add(panel, BorderLayout.CENTER);

        JPanel weaita = new JPanel();
        weaita.setLayout(new BorderLayout());

        weaita.setBackground(Color.yellow);
        JTable table = new JTable(new DefaultTableModel());
        table.setBackground(Color.yellow);
        
        table.addColumn(new TableColumn());
        JScrollPane pane = new JScrollPane(table);
        table.setGridColor(Color.red);
        pane.setBackground(Color.yellow);
        table.setForeground(Color.blue);
        
        weaita.add(new JLabel("Weás"), BorderLayout.NORTH);        
        weaita.add(pane, BorderLayout.CENTER);
        weaita.add(new JButton("Simular"), BorderLayout.SOUTH);
        
        
        this.add(weaita, BorderLayout.EAST);
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

    public void initListaCargas() {
        cargas = new ArrayList();
        String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
        String contraseña = null;
        try {
            Connection unaConexion = DriverManager.getConnection(url, "bdi2017t", "bdi2017t");
            Statement instruccionSQL = unaConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("select c.rut,c.nombre from trabajador as t, carga as c where  t.rut=c.RUTP and t.correo='" + _user + "'");
            System.out.println("select c.nombre,c.rut from trabajador as t, carga as c where  t.rut=c.RUTP and t.correo='" + _user + "'");
            while (resultadosConsulta.next()) {
                String a = resultadosConsulta.getString(2);
                String b = resultadosConsulta.getString(1);
                String d = a + " - \nRut: " + b;
                System.out.println(d);
                cargas.add(d);
            }
            unaConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(BotonRecuperarContraseña.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
