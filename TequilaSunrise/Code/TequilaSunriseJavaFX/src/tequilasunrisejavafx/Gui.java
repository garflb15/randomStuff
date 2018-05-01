/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tequilasunrisejavafx;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author Flori
 */
public class Gui extends JFrame
{
    Picture picture = new Picture();
    public static void main(String[] args)
    {
        Gui gui = new Gui();
    }

    public Gui()
    {
        super();
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLayout(new GridLayout());
        this.setVisible(true);
        this.add(picture);
    }
    
}
