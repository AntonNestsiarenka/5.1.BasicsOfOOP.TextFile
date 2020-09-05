package by.java.oop_1;

import by.java.oop_1.bean.directory.Directory;
import by.java.oop_1.bean.file.file_children.TextFile;
import by.java.oop_1.logic.TextFileLogic;

public class TextFileMain {

    public static void main(String[] args) {
        Directory directory = new Directory("Documents");
        TextFileLogic textFileLogic = new TextFileLogic();

        TextFile textFile1 = textFileLogic.createTextFile("my_story", directory);
        TextFile textFile2 = textFileLogic.createTextFile("project_mystery", directory);
        TextFile textFile3 = textFileLogic.createTextFile("my_function", directory);
        TextFile textFile4 = textFileLogic.createTextFile("java_book", directory);
        TextFile textFile5 = textFileLogic.createTextFile("code_review", directory);
        TextFile textFile6 = textFileLogic.createTextFile("debug", "[0304/020702.264:ERROR:crash_report_database_win.cc(428)] unexpected header", directory);
        TextFile textFile7 = textFileLogic.createTextFile("java_doc", "Java it`s my life", directory);
        TextFile textFile8 = textFileLogic.createTextFile("manual_vp44", "Manual vp44", directory);

        System.out.println(directory.getDirectoryInfo());

        textFileLogic.displayFileContent("debug", directory);

        textFileLogic.addContent(textFile1, "I am studying Java now. I want to start my career in EPAM.");
        textFileLogic.displayFileContent("my_story", directory);

        textFileLogic.rewriteContent(textFile1, "I am happy =)");
        textFileLogic.displayFileContent("my_story", directory);

        textFileLogic.deleteFile("java_doc", directory);
        System.out.println(directory.getDirectoryInfo());

        textFileLogic.renameFile("my_function", directory, "debug");
        System.out.println(directory.getDirectoryInfo());
    }
}
