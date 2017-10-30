/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois;

import java.awt.event.*;
import javax.swing.JButton;

/**
 *
 * @author pauloolivares
 */
public class BotonRecuperar extends JButton {

    public BotonRecuperar(String text) {
        this.setText(text);
        this.addActionListener(new Listener());
    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
