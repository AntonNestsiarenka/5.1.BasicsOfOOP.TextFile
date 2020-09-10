package by.java.oop_1;

import by.java.oop_1.bean.directory.Directory;
import by.java.oop_1.bean.file.file_children.TextFile;
import by.java.oop_1.logic.DirectoryLogic;
import by.java.oop_1.logic.TextFileLogic;

public class TextFileMain {

    public static void main(String[] args) {
        Directory directory = new Directory("Documents");
        TextFileLogic textFileLogic = new TextFileLogic();
        DirectoryLogic directoryLogic = new DirectoryLogic();

        TextFile textFile1 = textFileLogic.createTextFile("my_story", directory, directoryLogic);
        TextFile textFile2 = textFileLogic.createTextFile("project_mystery", directory, directoryLogic);
        TextFile textFile3 = textFileLogic.createTextFile("my_function", directory, directoryLogic);
        TextFile textFile4 = textFileLogic.createTextFile("java_book", directory, directoryLogic);
        TextFile textFile5 = textFileLogic.createTextFile("code_review", directory, directoryLogic);
        TextFile textFile6 = textFileLogic.createTextFile("debug", "[0304/020702.264:ERROR:crash_report_database_win.cc(428)] unexpected header", directory, directoryLogic);
        TextFile textFile7 = textFileLogic.createTextFile("java_doc", "Java it`s my life", directory, directoryLogic);
        TextFile textFile8 = textFileLogic.createTextFile("manual_vp44", "Manual vp44", directory, directoryLogic);

        System.out.println(directoryLogic.getDirectoryInfo(directory, textFileLogic));

        textFileLogic.displayFileContent("debug", directory, directoryLogic);

        textFileLogic.addContent(textFile1, "I am studying Java now. I want to start my career in EPAM.");
        textFileLogic.displayFileContent("my_story", directory, directoryLogic);

        textFileLogic.rewriteContent(textFile1, "I am happy =)");
        textFileLogic.displayFileContent("my_story", directory, directoryLogic);

        textFileLogic.deleteFile("java_doc", directory, directoryLogic);
        System.out.println(directoryLogic.getDirectoryInfo(directory, textFileLogic));

        textFileLogic.renameFile("my_function", directory, directoryLogic, "debug");
        System.out.println(directoryLogic.getDirectoryInfo(directory, textFileLogic));
    }
}
