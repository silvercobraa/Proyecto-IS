/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Paulo
 */
public class JdbcSQL {

    Pool pool = new Pool();

    public boolean validarUsuario(String elUsr, String elPw) {
        try {
            String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
            Connection unaConexion = pool.dataSource.getConnection();
            Statement instruccionSQL = unaConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT correo,contrasena FROM trabajador WHERE correo='" + elUsr + "' AND contrasena='" + elPw + "'");
            return resultadosConsulta.first();
        } catch (SQLException e) {
            return false;
        }
    }
}
