package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Michael Tinnacher
 */
public class Main extends JFrame {

    private DefaultMutableTreeNode root;
    private DefaultTreeModel treeModel;
    private JTree tree;
    private JPanel picPanel = new JPanel();
    private PicturePanel picturePanel;
    
    private final Inventory inv = new Inventory();

    public Main() {
        initLayout();
        initComponents();
    }

    private void initLayout() {
        this.setTitle("SunrisePhoto");

        ImageIcon icon = new ImageIcon(getClass().getResource("/res/img/sunrise.png"));
        this.setIconImage(icon.getImage());

        this.setMinimumSize(new Dimension(1800, 900));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setJMenuBar(setMenuBar());
    }

    private void initComponents() {
        Container c = new Container();
        c.setLayout(new BorderLayout());

        c.add(setMainPanel(), BorderLayout.CENTER);
        c.add(sidePanel(), BorderLayout.EAST);

        this.add(c);
    }

    // <editor-fold defaultstate="collapsed" desc=" private JMenuBar setMenuBar() !fin">
    private JMenuBar setMenuBar() {

        JMenuBar mbBar;
        JMenu mnStart;
        JMenu mnEdit;
        JMenu mnHelp;
        JMenuItem miImport;
        JMenuItem miExport;
        JMenuItem miOpen;
        JMenuItem miExit;
        JMenuItem miRedo;
        JMenuItem miRepeat;
        JMenuItem miSearch;
        JMenuItem miAssess;
        JMenuItem miWelcome;
        JMenuItem miAbout;
        JMenuItem miSettings;
        mbBar = new JMenuBar();
        mbBar.setBackground(Color.WHITE);

        mnStart = new JMenu("Start");
        mnStart.setFont(new Font("Arial", Font.PLAIN, 16));

        miImport = new JMenuItem("Importieren");
        miImport.setFont(new Font("Arial", Font.PLAIN, 14));
        miImport.setBackground(Color.WHITE);
        miImport.setIcon(new ImageIcon(getClass().getResource("/res/img/import.png")));
        miImport.addActionListener(al -> {
            onImport();
        });
        mnStart.add(miImport);

        miExport = new JMenuItem("Exportieren");
        miExport.setFont(new Font("Arial", Font.PLAIN, 14));
        miExport.setBackground(Color.WHITE);
        miExport.setIcon(new ImageIcon(getClass().getResource("/res/img/export.png")));
        miExport.addActionListener(al -> {
            onExport();
        });
        mnStart.add(miExport);

        mnStart.add(new JSeparator());

        miOpen = new JMenuItem("Öffnen");
        miOpen.setFont(new Font("Arial", Font.PLAIN, 14));
        miOpen.setBackground(Color.WHITE);
        miOpen.setIcon(new ImageIcon(getClass().getResource("/res/img/open.png")));
        miOpen.addActionListener(al -> {
            onOpen();
        });
        mnStart.add(miOpen);

        mnStart.add(new JSeparator());

        miExit = new JMenuItem("Beenden");
        miExit.setFont(new Font("Arial", Font.PLAIN, 14));
        miExit.setBackground(Color.WHITE);
        miExit.setIcon(new ImageIcon(getClass().getResource("/res/img/exit.png")));
        miExit.addActionListener(al -> {
            onExit();
        });
        mnStart.add(miExit);

        mnEdit = new JMenu("Bearbeiten");
        mnEdit.setFont(new Font("Arial", Font.PLAIN, 16));

        miRedo = new JMenuItem("Rückgängig");
        miRedo.setFont(new Font("Arial", Font.PLAIN, 14));
        miRedo.setBackground(Color.WHITE);
        miRedo.setIcon(new ImageIcon(getClass().getResource("/res/img/refresh.png")));
        miRedo.addActionListener(al -> {
            onRedo();
        });
        mnEdit.add(miRedo);

        miRepeat = new JMenuItem("Wiederholen");
        miRepeat.setFont(new Font("Arial", Font.PLAIN, 14));
        miRepeat.setBackground(Color.WHITE);
        miRepeat.setIcon(new ImageIcon(getClass().getResource("/res/img/redo.png")));
        miRepeat.addActionListener(al -> {
            onRepeat();
        });
        mnEdit.add(miRepeat);

        mnEdit.add(new JSeparator());

        miSearch = new JMenuItem("Suchen");
        miSearch.setFont(new Font("Arial", Font.PLAIN, 14));
        miSearch.setBackground(Color.WHITE);
        miSearch.setIcon(new ImageIcon(getClass().getResource("/res/img/search.png")));
        miSearch.addActionListener(al -> {
            onSearch();
        });
        mnEdit.add(miSearch);

        mnEdit.add(new JSeparator());

        miAssess = new JMenuItem("Bewerten");
        miAssess.setFont(new Font("Arial", Font.PLAIN, 14));
        miAssess.setBackground(Color.WHITE);
        miAssess.setIcon(new ImageIcon(getClass().getResource("/res/img/star.png")));
        miAssess.addActionListener(al -> {
            onAssess();
        });
        mnEdit.add(miAssess);

        mnHelp = new JMenu("Hilfe");
        mnHelp.setFont(new Font("Arial", Font.PLAIN, 16));

        miWelcome = new JMenuItem("Willkommen");
        miWelcome.setFont(new Font("Arial", Font.PLAIN, 14));
        miWelcome.setBackground(Color.WHITE);
        miWelcome.setIcon(new ImageIcon(getClass().getResource("/res/img/like.png")));
        miWelcome.addActionListener(al -> {
            onWelcome();
        });
        mnHelp.add(miWelcome);

        mnHelp.add(new JSeparator());

        miAbout = new JMenuItem("Über SunrisePhoto");
        miAbout.setFont(new Font("Arial", Font.PLAIN, 14));
        miAbout.setBackground(Color.WHITE);
        miAbout.addActionListener(al -> {
            onAbout();
        });
        mnHelp.add(miAbout);

        mnHelp.add(new JSeparator());

        miSettings = new JMenuItem("Einstellungen");
        miSettings.setFont(new Font("Arial", Font.PLAIN, 14));
        miSettings.setBackground(Color.WHITE);
        miSettings.addActionListener(al -> {
            onSettings();
        });
        mnHelp.add(miSettings);

        mbBar.add(mnStart);
        mbBar.add(mnEdit);
        mbBar.add(mnHelp);

        return mbBar;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" private void onImport() ">
    private void onImport()
    {
        try {
            inv.onImportData();
            refreshMainPanel();//Aufruf dieser Methode dient dem hinzufuegen der Bilder
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" private void onExport()">
    private void onExport() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" private void onOpen() ">
    private void onOpen() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" private void onExit() ">
    private void onExit() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" private void onRedo() ">
    private void onRedo() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" private void onRepeat() ">
    private void onRepeat() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" private void onSearch() ">
    private void onSearch() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" private void onAssess() ">
    private void onAssess() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" private void onSettings() ">
    private void onSettings() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" private void onWelcome() !fin">
    private void onWelcome() {
        try {
            Desktop.getDesktop().browse(getClass().getResource("/res/html/welcome.html").toURI());
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" private void onAbout() !fin">
    private void onAbout() {
        try {
            Desktop.getDesktop().browse(getClass().getResource("/res/html/about.html").toURI());
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" private Component setMainPanel() ">
    private Component setMainPanel() {
        picPanel.setOpaque(true);
        picPanel.setBackground(Color.WHITE);
        picPanel.setLayout(new GridLayout(1, 1));
        /*JScrollPane js = new JScrollPane();
        js.add(picPanel);*/
        return picPanel;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" private Component sidePanel() ">
    private Component sidePanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 10));
        panel.setLayout(new GridLayout(2, 1));
        panel.setOpaque(true);
        panel.setBackground(Color.WHITE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.PLAIN, 16));
        tabbedPane.setBackground(Color.WHITE);

        JPanel panelMeta = new JPanel();
        panelMeta.setBackground(Color.WHITE);

        JPanel panelAssess = new JPanel();
        panelAssess.setBackground(Color.WHITE);

        tabbedPane.addTab("Metainformation", panelMeta);
        tabbedPane.addTab("Bewertung", panelAssess);

        panel.add(tabbedPane);
        panel.add(initTree());

        return panel;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" private JScrollPane initTree() !fin">
    private JScrollPane initTree() {
        File fileRoot = new File("C://tequilaPhoto");
        root = new DefaultMutableTreeNode(new FileNode(fileRoot));
        treeModel = new DefaultTreeModel(root);

        tree = new JTree(treeModel);
        tree.setShowsRootHandles(true);
        JScrollPane scrollPane = new JScrollPane(tree);
        scrollPane.setBorder(BorderFactory.createTitledBorder("FOTOVERZEICHNIS"));

        CreateChildNodes ccn = new CreateChildNodes(fileRoot, root);
        new Thread(ccn).start();

        return scrollPane;
    }
    // </editor-fold>

    private void refreshMainPanel() throws IOException //In dieser Methode werden die Bilder hinzugefügt und somit auch das MainPanel aktualisiert
    {
        picturePanel = new PicturePanel(inv.getSourceFolder(), picPanel.getWidth(), picPanel.getHeight());
        picPanel.add(picturePanel); //hinzufuegen des BilderPanels auf das MainPanel (PicPanel)
        picPanel.validate(); //aktualisieren des JPanel nachdem die Bilder hinzugefügt worden sind
    }
    
    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
