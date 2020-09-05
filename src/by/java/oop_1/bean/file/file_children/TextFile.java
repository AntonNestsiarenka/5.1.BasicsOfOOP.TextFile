package by.java.oop_1.bean.file.file_children;

import by.java.oop_1.bean.directory.Directory;
import by.java.oop_1.bean.file.File;

public final class TextFile extends File<String> {

    /* Класс описывает текстовый файл. */

    public TextFile(String fileName, Directory directory)
    {
        super(fileName, "txt", directory);
        directory.addFileToDirectory(this);
    }

    public TextFile(String fileName, String content, Directory directory)
    {
        super(fileName, "txt", content, directory);
        directory.addFileToDirectory(this);
    }
}