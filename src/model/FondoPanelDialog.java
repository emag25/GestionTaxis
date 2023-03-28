/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Marquez Jean
 */
public class FondoPanelDialog extends JPanel{
private Image imagen;
    private JDialog  ventana;
    
    public FondoPanelDialog(JDialog ventana){
        this.ventana = ventana;
    }

    @Override
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource("/imagen/t1.png")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(),getHeight(),ventana);
        setOpaque(false);
        super.paint(g);
    }   
}
