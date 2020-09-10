package by.java.oop_1.logic;

import by.java.oop_1.bean.directory.Directory;
import by.java.oop_1.bean.file.file_children.TextFile;

public final class TextFileLogic extends FileLogic {

    public TextFile createTextFile(String fileName, Directory directory, DirectoryLogic directoryLogic)
    {
        /* Создает текстовый файл в заданной директории. Если такое имя уже есть в директории, то дописывает в конец
           названия файла число, чтобы файл был уникальным. */
        String newFileName = fileName;
        if (isFileExist(fileName, directory, directoryLogic))
        {
            newFileName = generateNewName(fileName, directory, directoryLogic);
        }
        return new TextFile(newFileName, directory);
    }

    public TextFile createTextFile(String fileName, String content, Directory directory, DirectoryLogic directoryLogic)
    {
        /* Создает текстовый файл в заданной директории с заданным контентом. Если такое имя уже есть в директории, то
           дописывает в конец названия файла число, чтобы файл был уникальным. */
        String newFileName = fileName;
        if (isFileExist(fileName, directory, directoryLogic))
        {
            newFileName = generateNewName(fileName, directory, directoryLogic);
        }
        return new TextFile(newFileName, content, directory);
    }

    public void addContent(TextFile textFile, String contentToAdd) {
        // Добавляет некоторый текст в файл.
        if (textFile.getContent() == null) {
            textFile.setContent(contentToAdd);
        }
        else {
            textFile.setContent(textFile.getContent() + contentToAdd);
        }
    }

    public void rewriteContent(TextFile textFile, String content)
    {
        // Перезаписывает содержимое текстового файла новым содержимым.
        textFile.setContent(content);
    }
}