package by.java.oop_1.logic;

import by.java.oop_1.bean.Directory;
import by.java.oop_1.bean.File;
import by.java.oop_1.view.Viewer;

public class FileLogic implements IFile {

    @Override
    public void renameFile(String fileName, Directory directory, String newName) {
        /* Переименовывает файл заданным именем. Если такое имя уже есть в директории, то генерирует новое уникальное
           имя на основе заданного. */
        File<?> fileFound = directory.getFileByName(fileName);
        if (fileFound != null)
        {
            String newFileName = newName;
            if (isFileExist(newName, directory)) {
                newFileName = generateNewName(newName, directory);
            }
            fileFound.setFileName(newFileName);
        }
        else {
            Viewer.printMessage("File not found");
        }
    }

    @Override
    public void deleteFile(String fileName, Directory directory) {
        // Удаляет файл с заданным именем из директории.
        File<?> fileFound = directory.getFileByName(fileName);
        if (fileFound != null)
        {
            directory.deleteFileFromDirectory(fileFound);
        }
        else {
            Viewer.printMessage("File not found");
        }
    }

    @Override
    public void clearContentOfFile(String fileName, Directory directory) {
        // Очищает содержимое файла.
        File<?> fileFound = directory.getFileByName(fileName);
        if (fileFound != null)
        {
            fileFound.setContent(null);
        }
        else {
            Viewer.printMessage("File not found");
        }
    }

    @Override
    public void displayFileContent(String fileName, Directory directory) {
        // Базовая реализация отображения содержимого файла.
        File<?> fileFound = directory.getFileByName(fileName);
        if (fileFound != null)
        {
            Viewer.printMessage((fileFound.getContent() == null) ? "" : fileFound.getContent().toString());
        }
        else {
            Viewer.printMessage("File not found");
        }
    }

    protected boolean isFileExist(String fileName, Directory directory)
    {
        // Проверяет существует ли файл с заданным именем в заданной директории.
        File<?> fileFound = directory.getFileByName(fileName);
        return fileFound != null;
    }

    protected String generateNewName(String fileName, Directory directory) {
        // Генерирует новое уникальное имя файла на основе заданного.
        String newFileName = fileName + 1;
        int i = 2;
        while (directory.getFileByName(newFileName) != null)
        {
            newFileName = fileName + i;
            i++;
        }
        return newFileName;
    }
}