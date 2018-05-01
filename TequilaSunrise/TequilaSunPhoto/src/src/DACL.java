package src;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Michael Tinnacher
 */
public class DACL {

    public void copyFolder(File sourceFolder, File destFolder) throws IOException {

        if (sourceFolder.isDirectory()) {

            if (!destFolder.exists()) {
                destFolder.mkdir();
            }

            String files[] = sourceFolder.list();

            for (String file : files) {
                File srcFile = new File(sourceFolder, file);
                File destFile = new File(destFolder, file);

                copyFolder(srcFile, destFile);
            }
        } else {
            Files.copy(sourceFolder.toPath(), destFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }

}
