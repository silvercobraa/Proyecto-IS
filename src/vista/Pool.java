/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author Paulo
 */
public class Pool {

    public DataSource dataSource;

    public Pool() {
        inicializaDataSource();
    }

    private void inicializaDataSource() {
        String url = "jdbc:postgresql://plop.inf.udec.cl:5432/bdi2017t";
        String user = "bdi2017";
        String pass = "bdi2017";
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.postgresql.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);
        basicDataSource.setMaxActive(10);
        dataSource = basicDataSource;
    }
}
