/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author ByPal
 */
public class BotonRecuperarContraseña extends JButton {

    public static String correoEnvia = "serviciomedicofalso@gmail.com";
    public static String claveCorreo = "empresafalsa";

    Login _v;

    public BotonRecuperarContraseña(Login v) {
        super("Recuperar Contraseña");
        _v = v;
        this.addActionListener(new Listener());

    }

    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String usuario = _v.userText.getText();

            if (validarCorreo(usuario)) {

                String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
                String contraseña = null;
                try {
                    Connection unaConexion = DriverManager.getConnection(url, "bdi2017t", "bdi2017t");
                    Statement instruccionSQL = unaConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT contrasena FROM trabajador WHERE correo='" + usuario + "'");
                    resultadosConsulta.next();
                    contraseña = resultadosConsulta.getString(1);
                    unaConexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BotonRecuperarContraseña.class.getName()).log(Level.SEVERE, null, ex);
                }
                enviarContraseña(usuario, contraseña);
            } else {
                JOptionPane.showMessageDialog(null, "Correo no válido, intente nuevamente", "Error", JOptionPane.WARNING_MESSAGE);
            }

        }

        boolean validarCorreo(String correo) {
            try {
                String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
                Connection unaConexion = DriverManager.getConnection(url, "bdi2017t", "bdi2017t");
                Statement instruccionSQL = unaConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT correo FROM trabajador WHERE correo='" + correo + "'");
                unaConexion.close();
                return resultadosConsulta.first();
            } catch (SQLException e) {
                return false;
            }
        }

        void enviarContraseña(String user, String pass) {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.transport.protocol", "smtp");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.user", correoEnvia);
            properties.put("mail.password", claveCorreo);

            Session session = Session.getInstance(properties, null);

            try {
                // Crear el cuerpo del mensaje
                MimeMessage mimeMessage = new MimeMessage(session);

                // Agregar quien envía el correo
                mimeMessage.setFrom(new InternetAddress(correoEnvia, "Servicio Médico"));

                // Los destinatarios
                InternetAddress[] internetAddresses = {new InternetAddress(user)};

                // Agregar los destinatarios al mensaje
                mimeMessage.setRecipients(Message.RecipientType.TO, internetAddresses);

                // Agregar el asunto al correo
                mimeMessage.setSubject("Recuperación de Contraseña");

                // Creo la parte del mensaje
                MimeBodyPart mimeBodyPart = new MimeBodyPart();

                mimeBodyPart.setText("Su contraseña es: " + pass + "\nPara cambiar su contraseña contacte a un administrador.");

                // Crear el multipart para agregar la parte del mensaje anterior
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(mimeBodyPart);

                // Agregar el multipart al cuerpo del mensaje
                mimeMessage.setContent(multipart);

                // Enviar el mensaje
                Transport transport = session.getTransport("smtp");
                transport.connect(correoEnvia, claveCorreo);
                transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
                transport.close();
                JOptionPane.showMessageDialog(null, "Su contraseña ha sido enviada a su correo", "Contraseña reenviada", JOptionPane.INFORMATION_MESSAGE);
            } catch (UnsupportedEncodingException | MessagingException ex) {
                JOptionPane.showMessageDialog(null, "No se ha podido recuperar su contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
