package by.java.oop_1.logic;

import by.java.oop_1.bean.directory.Directory;
import by.java.oop_1.bean.file.File;

public class DirectoryLogic {

    public File<?> getFileByName(String fileName, Directory directory)
    {
        // Возвращает файл если файл с заданным именем присутствует в директории либо null если нет.
        File<?> fileFound = null;
        for (File<?> file : directory.getFiles())
        {
            if (file.getFileName().equals(fileName))
            {
                fileFound = file;
                break;
            }
        }
        return fileFound;
    }

    public String getDirectoryInfo(Directory directory, FileLogic fileLogic)
    {
        // Возвращает всю информацию о директории с файлами.
        StringBuilder filesInfo = new StringBuilder();
        for (File<?> file : directory.getFiles())
        {
            filesInfo.append(fileLogic.getFileInfo(file) + "\n");
        }
        return "Directory name: " + directory.getDirectoryName() + "\n" + filesInfo.toString();
    }
}
