/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tequilasunrisejavafx;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Flori
 */
public final class Picture extends JPanel
{
    private final String path = System.getProperty("user.dir")+File.separator+"src"+File.separator+"pic"+File.separator+"tequila-sunrise.jpg";
    private Image image = Toolkit.getDefaultToolkit().getImage(path);
    
    public Picture() 
    {
        super();
        this.setVisible(true);
        this.setLayout(new BorderLayout(2, 1));
        this.add(getPicture(), BorderLayout.CENTER);
        this.add(getPictureName(), BorderLayout.SOUTH);
    }
    
    public JPanel getPicture()
    {
        JPanel picturePanel = new JPanel();
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        g2d.draw((Shape) image);        
        return picturePanel;
    }
    
    public JLabel getPictureName()
    {
        File file = new File(path);
        return new JLabel(file.getName());
    }  
}
