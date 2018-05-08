package src;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Michael Tinnacher
 */
public class loopShow extends JDialog implements Runnable {

    public loopShow() {
        this.setSize(512, 512);
        this.setFocusableWindowState(false);
        this.setFocusable(false);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(new GridLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout());
        try {
            BufferedImage myPicture = ImageIO.read(new File(System.getProperty("user.dir").concat("/src/res/img/hourglass.png")));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            
            panel.add(picLabel);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        this.add(panel);

    }

    @Override
    public void run() {
        try {
            this.setVisible(true);
            Thread.sleep(10000);
//            Thread.interrupted();
        } catch (InterruptedException ex) {
            Logger.getLogger(loopShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }

}
