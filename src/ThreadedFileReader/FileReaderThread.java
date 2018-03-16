package ThreadedFileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileReaderThread implements Runnable {
    private Thread thread;
    private String filePath, newFilePath;
    private int threadTurn;
    public static int currentTurn = 0;


    public FileReaderThread(String name, String filePath, String newFilePath, int threadTurn) {
        this.thread = new Thread(this, name);
        this.filePath = filePath;
        this.newFilePath = newFilePath;
        this.threadTurn = threadTurn;
        currentTurn = (currentTurn == 0) ? 1 : currentTurn;
        this.thread.run();
    }

    @Override
    public void run() {
        String fileContent = readFile();
        synchronized(this) {
            try {
                if(currentTurn != this.threadTurn)
                        this.wait();
                writeFile(fileContent);
                currentTurn++;
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String readFile(){
        String fileContent = "";
        String line;
        try(java.io.FileReader fr = new java.io.FileReader(filePath);
            BufferedReader br = new BufferedReader(fr)){
            while((line = br.readLine()) != null){
                if(line != null)
                    fileContent += line;
                //System.out.println(this.thread.getName() + " reads " + line);
            }

        }catch (IOException e){
            System.out.println("IO Exception!");
            e.printStackTrace();
        }
        return fileContent;
    }

    public String readFile(String filePath){
        String fileContent = "";
        String line;
        try(java.io.FileReader fr = new java.io.FileReader(filePath);
            BufferedReader br = new BufferedReader(fr)){
            while((line = br.readLine()) != null){
                if(line != null)
                    fileContent += line + "\n";
            }

        }catch (IOException e){
            System.out.println("IO Exception!");
            e.printStackTrace();
        }

        return fileContent;
    }

    public void writeFile(String content){
        try(java.io.FileWriter fw = new java.io.FileWriter(newFilePath, true);
            BufferedWriter br = new BufferedWriter(fw)){
            br.write(content);
            br.newLine();
            System.out.println(this.thread.getName() + " writes " + content);
        }catch (IOException e){
            System.out.println("IO Exception!");
            e.printStackTrace();
        }
    }
}
