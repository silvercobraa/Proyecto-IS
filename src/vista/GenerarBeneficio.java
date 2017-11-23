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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ByPal
 */
public class GenerarBeneficio extends JFrame {

    ArrayList<String> cargas;
    ArrayList<String> medicamentos;
    ArrayList<String> medicos;
    ArrayList<String> examenes;
    String _user;

    public GenerarBeneficio(String user) {
        super("Generar Beneficio");
        this.setSize(900, 480);
        this.setResizable(true);
        this.setMinimumSize(new Dimension(900, 480));
        this.setLayout(new GridLayout(1, 2));

        _user = user;
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        this.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);

        JTable table = new JTable(new DefaultTableModel());
        DefaultTableModel tablaMedicamentos = (DefaultTableModel) table.getModel();
        tablaMedicamentos.addColumn("Medicamentos");
        tablaMedicamentos.addColumn("Cantidad");
        JScrollPane tablePane = new JScrollPane(table);

        JTable table2 = new JTable(new DefaultTableModel());
        DefaultTableModel tablaMedicos = (DefaultTableModel) table2.getModel();
        tablaMedicos.addColumn("Nombre");
        tablaMedicos.addColumn("Rut");
        tablaMedicos.addColumn("Especialidad");
        JScrollPane tablePane2 = new JScrollPane(table2);

        JTable table3 = new JTable(new DefaultTableModel());
        DefaultTableModel tablaExamenes = (DefaultTableModel) table3.getModel();
        tablaExamenes.addColumn("Exámenes");
        tablaExamenes.addColumn("Precio");
        tablaExamenes.addColumn("Cantidad");
        JScrollPane tablePane3 = new JScrollPane(table3);

        ActionListener actionListener = new ActionHandler(tablaMedicamentos, tablaMedicos, tablaExamenes);
        JPanel jp = new JPanel();
        initListaMedicamentos();
        jp.setLayout(new GridLayout(medicamentos.size(), 1));
        for (int i = 0; i < medicamentos.size(); i++) {
            JCheckBox cb = new JCheckBox(medicamentos.get(i));
            cb.addActionListener(actionListener);
            jp.add(cb);
        }
        JScrollPane sp = new JScrollPane(jp);

        JPanel jp2 = new JPanel();
        initListaMedicos();
        jp2.setLayout(new GridLayout(medicos.size(), 1));
        for (int i = 0; i < medicos.size(); i++) {
            JCheckBox cb = new JCheckBox(medicos.get(i));
            cb.addActionListener(actionListener);
            jp2.add(cb);
        }
        JScrollPane sp2 = new JScrollPane(jp2);

        JPanel jp3 = new JPanel();
        initListaExamenes();
        jp3.setLayout(new GridLayout(examenes.size(), 1));
        for (int i = 0; i < examenes.size(); i++) {
            JCheckBox cb = new JCheckBox(examenes.get(i));
            cb.addActionListener(actionListener);
            jp3.add(cb);
        }
        JScrollPane sp3 = new JScrollPane(jp3);

        JPanel jp4 = new JPanel();
        ButtonGroup group = new ButtonGroup();
        initListaCargas();
        jp4.setLayout(new GridLayout(cargas.size() + 1, 1));
        JRadioButton ax = new JRadioButton(this.datosUsuario());
        group.add(ax);
        jp4.add(ax);
        for (int i = 0; i < cargas.size(); i++) {
            JRadioButton cb = new JRadioButton(cargas.get(i));
            group.add(cb);
            jp4.add(cb);
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
        izq.setLayout(new GridLayout(4, 1));
        der.setLayout(new GridLayout(4, 1));

        izq.add(new JLabel("Lista de beneficiarios"));
        der.add(sp4);
        izq.add(new JLabel("Lista de medicamentos"));
        der.add(sp);
        izq.add(new JLabel("Lista de médicos"));
        der.add(sp2);
        izq.add(new JLabel("Lista de exámenes"));
        der.add(sp3);
        panel.add(izq, BorderLayout.WEST);
        panel.add(der, BorderLayout.CENTER);
        panel.setOpaque(false);

        JPanel weaita = new JPanel();
        weaita.setLayout(new BorderLayout());
        JPanel panelAux = new JPanel();
        panelAux.setLayout(new GridLayout(3, 1));

        JPanel aux1 = new JPanel(new BorderLayout());
        aux1.add(new JLabel("Listado de medicamentos"), BorderLayout.NORTH);
        aux1.add(tablePane, BorderLayout.CENTER);
        panelAux.add(aux1);

        JPanel aux2 = new JPanel(new BorderLayout());
        aux2.add(new JLabel("Listado de médicos"), BorderLayout.NORTH);
        aux2.add(tablePane2, BorderLayout.CENTER);
        panelAux.add(aux2);

        JPanel aux3 = new JPanel(new BorderLayout());
        aux3.add(new JLabel("Listado de exámenes"), BorderLayout.NORTH);
        aux3.add(tablePane3, BorderLayout.CENTER);
        panelAux.add(aux3);

        weaita.add(panelAux, BorderLayout.CENTER);
        JPanel pn = new JPanel();
        pn.setOpaque(false);
        pn.add(new JButton("Simular"));
        pn.add(new JButton("Generar Beneficio"));
        weaita.add(pn, BorderLayout.SOUTH);

        this.add(panel, BorderLayout.CENTER);
        this.add(weaita, BorderLayout.EAST);
        this.setVisible(true);

    }

    private void initListaMedicamentos() {
        medicamentos = new ArrayList();
        String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
        String contraseña = null;
        try {
            Connection con = DriverManager.getConnection(url, "bdi2017t", "bdi2017t");
            Statement instruccionSQL = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("select nombre, dosis, presentacion from medicamento");
            while (resultadosConsulta.next()) {
                String a = resultadosConsulta.getString(1);
                String b = resultadosConsulta.getString(2);
                String c = resultadosConsulta.getString(3);
                String d = a + " - " + b + " - " + c;
                medicamentos.add(d);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BotonRecuperarContraseña.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initListaMedicos() {
        medicos = new ArrayList();
        String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
        String contraseña = null;
        try {
            Connection con = DriverManager.getConnection(url, "bdi2017t", "bdi2017t");
            Statement instruccionSQL = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("select rut,nombre,especialidad from medico");
            while (resultadosConsulta.next()) {
                String a = resultadosConsulta.getString(1);
                String b = resultadosConsulta.getString(2);
                String c = resultadosConsulta.getString(3);
                String d = a + " - " + b + " - " + c;
                medicos.add(d);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BotonRecuperarContraseña.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initListaExamenes() {
        examenes = new ArrayList();
        String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
        String contraseña = null;
        try {
            Connection con = DriverManager.getConnection(url, "bdi2017t", "bdi2017t");
            Statement instruccionSQL = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("select e.nombre, cm.nombre, c.costo from cexamen as c,examen as e, centrosmedicos as cm where c.examen=e.id and cm.id=c.centro");
            while (resultadosConsulta.next()) {
                String a = resultadosConsulta.getString(1);
                String b = resultadosConsulta.getString(2);
                String c = resultadosConsulta.getString(3);
                String d = a + " - " + b + "-" + c;
                examenes.add(d);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BotonRecuperarContraseña.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initListaCargas() {
        cargas = new ArrayList();
        String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
        String contraseña = null;
        try {
            Connection con = DriverManager.getConnection(url, "bdi2017t", "bdi2017t");
            Statement instruccionSQL = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("select c.rut,c.nombre from trabajador as t, carga as c where  t.rut=c.RUTP and t.correo='" + _user + "'");
            while (resultadosConsulta.next()) {
                String a = resultadosConsulta.getString(2);
                String b = resultadosConsulta.getString(1);
                String d = a + " - \nRut: " + b;
                cargas.add(d);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BotonRecuperarContraseña.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String datosUsuario() {
        String str = null;
        String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
        String contraseña = null;
        try {
            Connection con = DriverManager.getConnection(url, "bdi2017t", "bdi2017t");
            Statement instruccionSQL = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("select t.rut,t.nombre from trabajador as t where  t.correo='" + _user + "'");
            while (resultadosConsulta.next()) {
                String a = resultadosConsulta.getString(2);
                String b = resultadosConsulta.getString(1);
                str = a + " - \nRut: " + b;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BotonRecuperarContraseña.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }

    private int obtenerCosto(String str) {
        String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
        String aux = null;
        try {
            Connection con = DriverManager.getConnection(url, "bdi2017t", "bdi2017t");
            Statement instruccionSQL = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("select c.costo from medicamentos as c where c.nombre = '" + str + "'");
            while (resultadosConsulta.next()) {
                aux = resultadosConsulta.getString(1);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BotonRecuperarContraseña.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.getInteger(str);
    }

    private static class ActionHandler implements ActionListener {

        DefaultTableModel _medicamentos;
        DefaultTableModel _medicos;
        DefaultTableModel _examenes;

        public ActionHandler(DefaultTableModel medicamentos, DefaultTableModel medicos, DefaultTableModel examenes) {
            _medicamentos = medicamentos;
            _medicos = medicos;
            _examenes = examenes;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            JCheckBox checkbox = (JCheckBox) event.getSource();
            String tk1 = null, tk2 = null, tk3 = null, tk4 = null;
            String rut = null;
            if (checkbox.isSelected()) {
                StringTokenizer string = new StringTokenizer(checkbox.getText(), "-");
                tk1 = string.nextToken();
                tk2 = string.nextToken();
                tk3 = string.nextToken();
                if (Character.getNumericValue(checkbox.getText().charAt(0)) <= 9) {
                    _medicos.addRow(new Object[]{tk3, rut = tk1 + "-" + tk2, tk4 = string.nextToken()});
                } else if (Character.getNumericValue(checkbox.getText().charAt(checkbox.getText().length() - 1)) <= 9) {
                    _examenes.addRow(new Object[]{tk1 + "-" + tk2, tk3, "1"});
                } else {
                    _medicamentos.addRow(new Object[]{checkbox.getText(), "1"});
                }
            } else {
                for (int i = 0; i < _medicos.getRowCount(); i++) {
                    String aux1 = _medicos.getValueAt(i, 1).toString();
                    String aux2 = _medicos.getValueAt(i, 0).toString();
                    String aux3 = _medicos.getValueAt(i, 2).toString();

                    if (checkbox.getText().equals(aux1 + "-" + aux2 + "-" + aux3)) {
                        _medicos.removeRow(i);
                        break;
                    }
                }
                for (int i = 0; i < _medicamentos.getRowCount(); i++) {
                    if (checkbox.getText().equals(_medicamentos.getValueAt(i, 0).toString())) {
                        _medicamentos.removeRow(i);
                        break;
                    }
                }
                for (int i = 0; i < _examenes.getRowCount(); i++) {
                    String aux1 = _examenes.getValueAt(i, 1).toString();
                    String aux2 = _examenes.getValueAt(i, 0).toString();

                    if (checkbox.getText().equals(aux2 + "-" + aux1)) {
                        _examenes.removeRow(i);
                        break;
                    }
                }
            }
        }
    }
}
