package src;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Michael Tinnacher
 */
public class Inventory {

    public void onImportData()
    {
        String dirName = null;

        Object[] options = {"OK", "Abbrechen"};

        JPanel panel = new JPanel();
        panel.add(new JLabel("NAME DES NEUEN FOTOVERZEICHNISSES: "));
        JTextField tfDirName = new JTextField(20);
        panel.add(tfDirName);

        do {
            int result = JOptionPane.showOptionDialog(null, panel, "NUTZEREINGABE",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

            if (result == JOptionPane.YES_OPTION && !"".equals(tfDirName.getText())) {
                dirName = tfDirName.getText();
            }
        } while (dirName == null || "".equals(dirName));

        try {
            JFileChooser fc = new JFileChooser("C://Users");
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fc.showOpenDialog(null);

            try {
                String file = fc.getSelectedFile().getAbsolutePath();

                File sourceFolder = new File(file);
                File destFolder = new File("C://tequilaPhoto/" + dirName);

                Thread thread = new Thread(new loopShow());
                thread.start();

                new DACL().copyFolder(sourceFolder, destFolder);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Fehler beim kopieren!", "NUTZERINFORMATION", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Fehler beim Importieren!", "NUTZERINFORMATION", JOptionPane.ERROR_MESSAGE);
        }

    }
}
