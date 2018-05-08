package src;

import java.io.File;

/**
 *
 * @author Michael Tinnacher
 */
public class FileNode {

    private final File file;

    public FileNode(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        String name = file.getName();
        if (name.equals("")) {
            return file.getAbsolutePath();
        } else {
            return name;
        }
    }
}
