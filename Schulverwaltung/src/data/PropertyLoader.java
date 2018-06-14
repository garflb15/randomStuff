/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class PropertyLoader
{
    private static final String data = System.getProperty("user.dir")+File.separator+"src"+File.separator+"data"+File.separator+"login_data.txt";
    private static Properties properties = new Properties();
    private static FileInputStream fis;
    
    static
    {
        try {
            fis = new FileInputStream(new File(data));
            properties.load(fis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertyLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertyLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private PropertyLoader() {}

    public static String getProperties(String prop)
    {
        return properties.getProperty(prop);
    }
}
