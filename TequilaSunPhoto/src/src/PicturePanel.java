/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Flori
 */
public final class PicturePanel extends JPanel
{
    private final File sourceFile;
    private DrawPanel drawPanel;

    private final LinkedList<File> fileList = new LinkedList<>();

    private int xScale = 1;
    private int yScale = 1;
    
    private int counter = 0;
    
    public PicturePanel(File sourceFile, int witdh, int height) throws IOException
    {
        this.sourceFile = sourceFile;        
        this.setVisible(true);
        this.setBackground(Color.WHITE);
        this.setLayout(new GridLayout(3, 6));
        getEachPicture();
        designPanel(witdh, height);
    }
    
    public void getEachPicture()
    {
        System.out.println("Get-EachPicture");
        File[] allFiles = sourceFile.listFiles();
        
        for (File file : allFiles)
        {
            if(file.isFile() && (file.getAbsolutePath().endsWith(".jpg") || file.getAbsolutePath().endsWith(".png")))
            {      
                System.out.println(file.getName()+" added");
                fileList.add(file);
            }
        }
    }
    
    public void designPanel(int witdh, int height)
    {
        System.out.println("Design-Panel");
        BufferedImage image;
        
        for (File file : fileList)
        {
            try {
                JPanel picturePanel = new JPanel();
                picturePanel.setLayout(new BorderLayout());
                System.out.println("pic");
                image = ImageIO.read(file);
                
                this.drawPanel = new DrawPanel(image);
                calculateScale(witdh, height);
                JLabel nameLabel = new JLabel(file.getName());
                nameLabel.setOpaque(true);
                nameLabel.setBackground(Color.BLACK);
                nameLabel.setForeground(Color.WHITE);
                
                picturePanel.add(nameLabel, BorderLayout.SOUTH);
                picturePanel.add(drawPanel, BorderLayout.NORTH);
                this.add(picturePanel);
            } catch (IOException ex) {
                Logger.getLogger(PicturePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < (18 - fileList.size()) ; i++)
        {
            this.add(new JPanel().add(new JLabel("Muster")));
        }
    }
    
    private void calculateScale(int witdh, int height)
    {
        xScale = witdh/6;
        yScale = height/4;
        drawPanel.setxScale(xScale);
        drawPanel.setyScale(yScale);
        this.repaint();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        System.out.println("paint");
        drawPanel.draw(g);
    }
    
}
