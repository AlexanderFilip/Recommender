package org.crypto;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import static org.crypto.MinMax.getMin;
public class ReadValues {



    public static void showCrypto(){

        //Crearea unei liste de cripto-monede, la care se poate adauga oricand o noua criptomoneda
        List CRYPTO_NAME = new ArrayList<String>();
        CRYPTO_NAME.add("BTC");
        CRYPTO_NAME.add("DOGE");
        CRYPTO_NAME.add("ETH");
        CRYPTO_NAME.add("LTC");
        CRYPTO_NAME.add("XRP"); //   CRYPTO_NAME.size()

        for (int i = 0; i < 1; i++) {
            System.out.println("Crypto Currency with the name "+ CRYPTO_NAME.get(i)+" has the following values:");
            citireFisiere("prices/"+ CRYPTO_NAME.get(i).toString()+"_values.csv");//```````````````````````````````````````````````````````````````````````
        }

        System.out.println("MIN function is:" + getMin(1,2));
        gasireVechi("prices/BTC_values.csv");//```````````````````````````````````````````````````````````````````````
        gasesteMinimul("prices/BTC_values.csv");

    }
//££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££
    //££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££
    public static void citireFisiere(String file) {

        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);
            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                    if(cell.equals("BTC"))
                        break;
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void gasireVechi(String file) {

        try{
            FileReader filereader = new FileReader(file);
            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();
        //    int celMaiVechi = oldestOfCoins(allData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void gasesteMinimul(String file) {

        int min = 0, max = 0;
        boolean ok = false;
        try {
            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                for (String cell : row) {
                    if(cell!="symbol") {
                        int number = Integer.parseInt(cell);
                        if (!ok) {
                            min = number;
                            max = number;
                        }
                        if (number < min) min = number;
                        if (number > max) max = number;
                    }
                    else break;
                }
            }
            System.out.println("minimul este: "+min);
            System.out.println("maximul este: " +max);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int oldestOfCoins( List<String[]> allData) {
        int min = 0;
        int nr;
        List<String[]> copyList = allData;
        for (String[] row : allData) {
            for (String cell : row) {
                int foo = Integer.parseInt(cell);
                if (min > foo)
                    min = foo;
            }
        }
        return min;
    }
}
