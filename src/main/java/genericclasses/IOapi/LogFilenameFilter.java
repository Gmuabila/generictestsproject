package genericclasses.IOapi;

import java.io.File;
import java.io.FilenameFilter;

public class LogFilenameFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String filename){
        return filename.endsWith(".log");
    }
}
