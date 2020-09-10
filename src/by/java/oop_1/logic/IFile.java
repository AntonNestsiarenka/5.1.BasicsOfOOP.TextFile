package by.java.oop_1.logic;

import by.java.oop_1.bean.directory.Directory;
import by.java.oop_1.bean.file.File;

public interface IFile {

    // Интерфейс для работы с файлами.

    void renameFile(String fileName, Directory directory, DirectoryLogic directoryLogic, String newName);

    void deleteFile(String fileName, Directory directory, DirectoryLogic directoryLogic);

    void clearContentOfFile(String fileName, Directory directory, DirectoryLogic directoryLogic);

    void displayFileContent(String fileName, Directory directory, DirectoryLogic directoryLogic);

    String getFileInfo(File<?> file);
}