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
public class BotonSolicitudDevolucion extends JButton {

    public BotonSolicitudDevolucion() {
        super("Solicitud de Devolución");
        this.addActionListener(new Listener());

    }

    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SolicitudDevolucion sd = new SolicitudDevolucion();
        }
    }

}
