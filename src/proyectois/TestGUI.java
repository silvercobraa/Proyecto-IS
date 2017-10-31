/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pauloolivares
 */
public class TestGUI {

    public static void main(String[] args) {

        if (TestGUI.connect()) {
            Ventana v = new Ventana();
        }
    }

    public static boolean connect() {
        try {
            System.out.println(" Buscando el driver de la base de datos PostgreSQL");
            Class.forName("org.postgresql.Driver");
            
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro el nombre del driver de la base de datos PostgreSQL " + e.getMessage());
            return false;
        }
        System.out.println(" Estableciendo la url de conexión");
        String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";

        //hay que cambiar por el numero de ip o la ubicacion de la maquina
        try {
            System.out.println(" Estableciendo la conexión");
            Connection coneccion = DriverManager.getConnection(url, "bd2017t", "bd2017t");
            
            System.out.println(" Obteniendo los metadatos de la base de datos");
            DatabaseMetaData dbmd = coneccion.getMetaData();
            System.out.println(" Conexión exitosa. Nombre del producto: "
                    + dbmd.getDatabaseProductName() + " Versión: "
                    + dbmd.getDatabaseProductVersion());
        } catch (SQLException e) {
            System.out.println(" Excepción al establecer la conexión "
                    + e.getMessage());
        }
        return false;
    }
}
