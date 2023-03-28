
package model;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FondoPanel extends JPanel{
    private Image imagen;
    private JFrame ventana;
    
    public FondoPanel(JFrame ventana){
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
