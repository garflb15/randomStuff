/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Flori
 */
public class MetaData
{
    private final String path = System.getProperty("user.dir")+File.separator+"src"+File.separator+"photo"+File.separator+"tequila-sunrise.jpg";
    
    public void getMetaData() throws ImageProcessingException, IOException
    {
        Metadata medData = ImageMetadataReader.readMetadata(new File(path));
        
        for (Directory directory : medData.getDirectories())
        {            
            directory.getTags().forEach((item) -> {
                System.out.println(item.getDescription() +" --<>-- "+ item.getTagName());
            });
        }
    }
}
