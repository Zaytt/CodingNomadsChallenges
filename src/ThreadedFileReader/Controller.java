package ThreadedFileReader;

import java.io.*;

public class Controller {

    public static void main(String[] args) {

        resetFile();


        FileReaderThread frt1 = new FileReaderThread("File1", "src/files/LoremIpsum1.txt",
                "src/files/CompleteLoremIpsum.txt", 1);
        FileReaderThread frt2 = new FileReaderThread("File2", "src/files/LoremIpsum2.txt",
                "src/files/CompleteLoremIpsum.txt", 2);
        FileReaderThread frt3 = new FileReaderThread("File3", "src/files/LoremIpsum3.txt",
                "src/files/CompleteLoremIpsum.txt", 3);
        FileReaderThread frt4 = new FileReaderThread("File4", "src/files/LoremIpsum4.txt",
                "src/files/CompleteLoremIpsum.txt", 4);

    }

    public static void resetFile(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("src/files/CompleteLoremIpsum.txt");
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
