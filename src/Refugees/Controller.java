package Refugees;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Controller {

    public static void main(String[] args) {
        Controller controller = new Controller();
        CSVReader csvr = new CSVReader();
        ArrayList<RefugeesCountry> refugeeList = csvr.readCSVFile("src/files/refugees_per_capita.csv");
        System.out.println("Total Registries: " + refugeeList.size());
        controller.print(refugeeList);
        for(int i = 2001; i < 2016; i++)
            controller.print(refugeeList, i);
        controller.print(refugeeList, 2015, "Mexico");
        controller.print(refugeeList, "Montenegro");
    }

    public void print(ArrayList<RefugeesCountry> refugeeList){
        long sumPopulation = 0;
        long sumRefugees = 0;
        for (RefugeesCountry rc: refugeeList) {
            //System.out.println(rc.toString());
            sumPopulation += rc.getPopulation();
            sumRefugees += rc.getRefugees();
        }
        String lastYear, firstYear;
        firstYear = ""+(int)refugeeList.get(0).getYear();
        lastYear = ""+(int)refugeeList.get(refugeeList.size()-1).getYear();
        System.out.println("-----------------------");
        System.out.println("World Population " + firstYear + "-" + lastYear + ": " +
                 NumberFormat.getNumberInstance(Locale.US).format(sumPopulation));
        System.out.println("World Refugees " + firstYear + "-" + lastYear + ": "
                + NumberFormat.getNumberInstance(Locale.US).format(sumRefugees));
        System.out.println("-----------------------");
    }

    public void print(ArrayList<RefugeesCountry> refugeeList, int year){
        long sumPopulation = 0;
        long sumRefugees = 0;
        for (RefugeesCountry rc: refugeeList) {
            if(rc.getYear() < year) continue;
            if(rc.getYear() > year) break;
            //System.out.println(rc.toString());
            sumPopulation += rc.getPopulation();
            sumRefugees += rc.getRefugees();
        }
        System.out.println("-----------------------");
        System.out.println(year + " World population          = " + NumberFormat.getNumberInstance(Locale.US).format(sumPopulation));
        System.out.println(year + " Refugees in the world     = " + NumberFormat.getNumberInstance(Locale.US).format(sumRefugees));
        System.out.println("-----------------------");
    }

    public void print(ArrayList<RefugeesCountry> refugeeList, int year, String country){
        long sumPopulation = 0;
        long sumRefugees = 0;
        for (RefugeesCountry rc: refugeeList) {
            if(rc.getYear() < year) continue;
            if(rc.getYear() > year) break;
            if(country.equals(rc.getCountryName())){
                sumPopulation += rc.getPopulation();
                sumRefugees += rc.getRefugees();
            }
        }
        System.out.println("-----------------------");
        System.out.println(year + " " + country + " Population    = " + NumberFormat.getNumberInstance(Locale.US).format(sumPopulation));
        System.out.println(year + " Refugees in " + country + "   = " + NumberFormat.getNumberInstance(Locale.US).format(sumRefugees));
        System.out.println("-----------------------");
    }

    public void print(ArrayList<RefugeesCountry> refugeeList, String country){
        long sumPopulation = 0;
        long sumRefugees = 0;
        for (RefugeesCountry rc: refugeeList) {
            if(country.equals(rc.getCountryName())){
                sumPopulation += rc.getPopulation();
                sumRefugees += rc.getRefugees();
            }
        }
        String firstYear = ""+(int)refugeeList.get(0).getYear();
        String lastYear = ""+(int)refugeeList.get(refugeeList.size()-1).getYear();
        System.out.println("-----------------------");
        System.out.println(firstYear + "-" + lastYear + " " + country + " Population  = " + NumberFormat.getNumberInstance(Locale.US).format(sumPopulation));
        System.out.println(firstYear + "-" + lastYear + " Refugees in " + country  + " = " + NumberFormat.getNumberInstance(Locale.US).format(sumRefugees));
        System.out.println("-----------------------");
    }

}
