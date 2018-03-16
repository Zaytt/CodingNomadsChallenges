package Refugees;

import java.util.Arrays;

public class RefugeesCountry {
    private int year;
    private double population, refugees;
    private String countryName;
    private double refugeesPerCapita;

    //,Year,Country,Population,Refugees,RefPerCap
    //0,2001,Afghanistan,20531160.0,6.0,2.92238723969e-07
    public RefugeesCountry(String line) {
        String[] data = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
        //System.out.println(Arrays.toString(data)); print the whole dataset
        int dataSize = data.length; //Used for switch to determine how much data per country we got.
        switch (dataSize) {
            case 6:
                this.year = Integer.valueOf(dataValidation(data[1]));
                this.countryName = dataValidation(data[2]);
                this.population = Double.valueOf(dataValidation(data[3]));
                this.refugees = Double.valueOf(dataValidation(data[4]));
                this.refugeesPerCapita = Double.valueOf(dataValidation(data[5]));
                break;
            case 4:
                this.year = Integer.valueOf(dataValidation(data[1]));
                this.countryName = dataValidation(data[2]);
                this.population = Double.valueOf(dataValidation(data[3]));
                this.refugees = -1;
                this.refugeesPerCapita = -1;
                break;
            case 5:
                this.year = Integer.valueOf(dataValidation(data[1]));
                this.countryName = dataValidation(data[2]);
                this.population = Double.valueOf(dataValidation(data[3]));
                this.refugees = Double.valueOf(dataValidation(data[4]));
                this.refugeesPerCapita = -1;
                break;
            default:
                this.year = Integer.valueOf(dataValidation(data[1]));
                this.countryName = dataValidation(data[2]);
                this.population = -1;
                this.refugees = -1;
                this.refugeesPerCapita = -1;
        }

    }
    @Override
    public String toString() {

        String refugees = ""+this.refugees;
        String refugeesPerCapita = ""+this.refugeesPerCapita;
        String population = ""+this.population;
        if(this.refugees == -1)
            refugees = "N/A";
        if(this.refugeesPerCapita == -1)
            refugeesPerCapita = "N/A";
        if(this.population == -1)
            population = "N/A";


        return this.year + " " + this.countryName + " " + population + " " + refugees + " " + refugeesPerCapita;
    }

    private void fillData(String[] data) {

    }

    private String dataValidation(String val){
        if(val.isEmpty())
            return "-1";
        return val;
    }

    public double getYear() {
        return year;
    }

    public double getPopulation() {
        if(this.population == -1)
            return 0;
        return population;
    }

    public double getRefugees() {
        if(this.refugees == -1)
            return 0;
        return refugees;
    }

    public String getCountryName() {
        return countryName;
    }

    public double getRefugeesPerCapita() {
        return refugeesPerCapita;
    }
}