/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import com.drew.imaging.ImageProcessingException;
import java.io.IOException;

/**
 *
 * @author Flori
 */
public class Main
{
    public static void main(String[] args) throws ImageProcessingException, IOException
    {
        MetaData metaData = new MetaData();
        metaData.getMetaData();
        
        AccesDB accesDB = new AccesDB();
        accesDB.getConnection();
        
        
    }
}
