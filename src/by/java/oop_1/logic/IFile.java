package by.java.oop_1.logic;

import by.java.oop_1.bean.Directory;

public interface IFile {

    // Интерфейс для работы с файлами.

    void renameFile(String fileName, Directory directory, String newName);

    void deleteFile(String fileName, Directory directory);

    void clearContentOfFile(String fileName, Directory directory);

    void displayFileContent(String fileName, Directory directory);
}