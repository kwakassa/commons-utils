package br.com.utils.classes;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilterImpl implements FilenameFilter {

    String extension;

    public FileNameFilterImpl(final String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(final File dir, final String name) {
        return (name.endsWith(this.extension));
    }

}
