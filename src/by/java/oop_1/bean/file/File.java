package by.java.oop_1.bean.file;

import by.java.oop_1.bean.directory.Directory;

import java.util.Objects;

public abstract class File<T> {

    /* Класс описывает файл. */

    private String fileName;
    private String extension;
    private T content = null;
    private Directory location;

    public File(String fileName, String extension, T content, Directory location)
    {
        this.fileName = fileName;
        this.extension = extension;
        this.content = content;
        this.location = location;
    }

    public File(String fileName, String extension, Directory location) {
        this.fileName = fileName;
        this.extension = extension;
        this.location = location;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Directory getLocation() {
        return location;
    }

    public String getFileInfo() {
        return "Name of file: " + fileName + ", type: " + extension + ", location: " + location.getDirectoryName() + ".";
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", extension='" + extension + '\'' +
                ", content=" + ((content != null) ? content : "") +
                ", location=" + location.getDirectoryName() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File<?> file = (File<?>) o;
        return Objects.equals(fileName, file.fileName) &&
                Objects.equals(extension, file.extension) &&
                Objects.equals(content, file.content) &&
                Objects.equals(location, file.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, extension, content, location);
    }
}