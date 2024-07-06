import javax.swing.filechooser.FileFilter;
import java.io.File;

class MyFileFilter extends FileFilter {
    private String extension;
    private String description;

    public MyFileFilter(String extension, String description) {
        this.extension = extension;
        this.description = description;
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        return file.getName().toLowerCase().endsWith(extension);
    }

    @Override
    public String getDescription() {
        return description;
    }
}
