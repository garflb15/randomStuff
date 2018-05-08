/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Flori
 */
public class DrawPanel extends JPanel
{
    BufferedImage image;
    private int yScale;
    private int xScale;
    
    public DrawPanel(BufferedImage image)
    {
        this.image = image;
    }
    
    public void draw(Graphics g)
    {
        super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
        System.out.println("paint");
        g.drawImage(image, 0, 0, xScale, yScale, this);
    }

    public void setyScale(int yScale) {
        this.yScale = yScale;
    }

    public void setxScale(int xScale) {
        this.xScale = xScale;
    }
    
}
