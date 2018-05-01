/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picturepanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Flori
 */
public class Frame extends JFrame
{
    private final File path = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "pic" + File.separator + "tequila-sunrise.jpg");
    private PicturePanel picturePanel;
    private BufferedImage image;
    
    public Frame()
    {
        super("PicturePanel");
        this.setSize(500, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        addText();
        addImage();
    }

    private void addImage()
    {
        try
        {
            image = ImageIO.read(path);
            picturePanel = new PicturePanel(image);
            this.add(picturePanel, BorderLayout.CENTER);
            this.repaint();
        }
        catch (IOException ex)
        {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addText()
    {
        Font font = new Font("Arial", Font.BOLD, 50);
        JLabel nameLabel = new JLabel(path.getName());
        nameLabel.setOpaque(true);
        nameLabel.setFont(font);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        nameLabel.setVerticalAlignment((int) CENTER_ALIGNMENT);
        this.add(nameLabel, BorderLayout.SOUTH);
    }

    @Override
    public void paint(Graphics g)
    {
        picturePanel.draw(g);
        picturePanel.setVisible(true);
    }
    
    public static void main(String[] args){Frame frame = new Frame();}
}
