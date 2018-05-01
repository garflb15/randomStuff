/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picturepanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Flori
 */

public class PicturePanel extends JPanel
{
    private final BufferedImage image;
    
    public PicturePanel(BufferedImage image)
    {
       this.image = image;
    }
    
    public double scaleX()
    {
        return this.getWidth()/100;
    }
    
    public double scaleY()
    {
        return this.getHeight()/100;
    }
      
    public void draw(Graphics g)
    {
        g.drawImage(image, 0, 0, (int) scaleX(), (int) scaleY(), this);
        g.dispose();
    }
}
