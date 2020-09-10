package by.java.oop_1.bean.directory;

import by.java.oop_1.bean.file.File;

import java.util.ArrayList;
import java.util.Objects;

public final class Directory {

    /* Класс описывает папку с файлами. */

    private String directoryName;
    private ArrayList<File<?>> files;

    public Directory()
    {
        directoryName = "src";
        files = new ArrayList<>();
    }

    public Directory(String directoryName, File<?>...files) {
        this.directoryName = directoryName;
        this.files = new ArrayList<>();
        for (File<?> file : files)
        {
            addFileToDirectory(file);
        }
    }

    public Directory(String directoryName)
    {
        this.directoryName = directoryName;
        this.files = new ArrayList<>();
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directory) {
        this.directoryName = directory;
    }

    public ArrayList<File<?>> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File<?>> files) {
        this.files = files;
    }

    public void addFileToDirectory(File<?> file)
    {
        files.add(file);
    }

    public void addFilesToDirectory(File<?>...file)
    {
        for (File<?> file1 : file)
        {
            addFileToDirectory(file1);
        }
    }

    public void deleteFileFromDirectory(File<?> file)
    {
        files.remove(file);
    }

    public void deleteAllFilesFromDirectory()
    {
        files.clear();
    }

    @Override
    public String toString() {
        StringBuilder filesInfo = new StringBuilder();
        for (File<?> file : files)
        {
            filesInfo.append(file.toString() + "\n");
        }
        return "Directory{" +
                "name='" + directoryName + '\'' +
                ", files=" + filesInfo.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directory directory = (Directory) o;
        return Objects.equals(directoryName, directory.directoryName) &&
                Objects.equals(files, directory.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directoryName, files);
    }
}