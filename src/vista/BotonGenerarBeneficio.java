/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ByPal
 */
public class BotonGenerarBeneficio extends JButton {

    String _user;

    public BotonGenerarBeneficio(String user) {
        super("Generar Beneficio");
        this.addActionListener(new Listener());
        _user = user;
    }

    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GenerarBeneficio sb = new GenerarBeneficio(_user);
        }
    }
}
