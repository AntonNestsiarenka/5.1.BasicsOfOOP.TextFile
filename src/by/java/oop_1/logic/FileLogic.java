package by.java.oop_1.logic;

import by.java.oop_1.bean.directory.Directory;
import by.java.oop_1.bean.file.File;
import by.java.oop_1.view.Viewer;

public class FileLogic implements IFile {

    @Override
    public void renameFile(String fileName, Directory directory, DirectoryLogic directoryLogic, String newName) {
        /* Переименовывает файл заданным именем. Если такое имя уже есть в директории, то генерирует новое уникальное
           имя на основе заданного. */
        File<?> fileFound = directoryLogic.getFileByName(fileName, directory);
        if (fileFound != null)
        {
            String newFileName = newName;
            if (isFileExist(newName, directory, directoryLogic)) {
                newFileName = generateNewName(newName, directory, directoryLogic);
            }
            fileFound.setFileName(newFileName);
        }
        else {
            Viewer.printMessage("File not found");
        }
    }

    @Override
    public void deleteFile(String fileName, Directory directory, DirectoryLogic directoryLogic) {
        // Удаляет файл с заданным именем из директории.
        File<?> fileFound = directoryLogic.getFileByName(fileName, directory);
        if (fileFound != null)
        {
            directory.deleteFileFromDirectory(fileFound);
        }
        else {
            Viewer.printMessage("File not found");
        }
    }

    @Override
    public void clearContentOfFile(String fileName, Directory directory, DirectoryLogic directoryLogic) {
        // Очищает содержимое файла.
        File<?> fileFound = directoryLogic.getFileByName(fileName, directory);
        if (fileFound != null)
        {
            fileFound.setContent(null);
        }
        else {
            Viewer.printMessage("File not found");
        }
    }

    @Override
    public void displayFileContent(String fileName, Directory directory, DirectoryLogic directoryLogic) {
        // Базовая реализация отображения содержимого файла.
        File<?> fileFound = directoryLogic.getFileByName(fileName, directory);
        if (fileFound != null)
        {
            Viewer.printMessage((fileFound.getContent() == null) ? "" : fileFound.getContent().toString());
        }
        else {
            Viewer.printMessage("File not found");
        }
    }

    @Override
    public String getFileInfo(File<?> file) {

        return "Name of file: " + file.getFileName() + ", type: " + file.getExtension() + ", location: " + file.getLocation().getDirectoryName() + ".";
    }

    protected boolean isFileExist(String fileName, Directory directory, DirectoryLogic directoryLogic)
    {
        // Проверяет существует ли файл с заданным именем в заданной директории.
        File<?> fileFound = directoryLogic.getFileByName(fileName, directory);
        return fileFound != null;
    }

    protected String generateNewName(String fileName, Directory directory, DirectoryLogic directoryLogic) {
        // Генерирует новое уникальное имя файла на основе заданного.
        String newFileName = fileName + 1;
        int i = 2;
        while (directoryLogic.getFileByName(newFileName, directory) != null)
        {
            newFileName = fileName + i;
            i++;
        }
        return newFileName;
    }
}