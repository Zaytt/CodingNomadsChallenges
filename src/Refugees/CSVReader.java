package Refugees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    ArrayList<RefugeesCountry> refCountryList;
    public CSVReader() {
        this.refCountryList = new ArrayList<>();
    }


    public ArrayList<RefugeesCountry> readCSVFile(String filePath){
        int lineNo = 0;
        String line = null;
        RefugeesCountry rc = null;
        try(FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr)){
            while((line = br.readLine()) != null ){
                //String[] data = line.split(",");
                if(lineNo++ > 0 ) {
                    rc = new RefugeesCountry(line);
                    refCountryList.add(rc);
                }

            }
        }catch(IOException E){
            System.out.println("End of file");
        }

        return this.refCountryList;
    }






}
