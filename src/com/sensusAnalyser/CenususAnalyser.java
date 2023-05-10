
package com.sensusAnalyser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CensusAnalyser {
    File file = new File("path");
    StateCensus census;
    List<StateCensus> censuses = new ArrayList<>();

    public List<StateCensus> readCSV() throws IOException, CsvException {
        try {
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                int sNo = Integer.parseInt(row[0]);
                String state = row[1];
                long population = Long.parseLong(row[2]);
                double increase = Double.parseDouble(row[3]);
                long area = Long.parseLong(row[4]);
                int density = Integer.parseInt(row[5]);
                int sexRatio = Integer.parseInt(row[6]);
                double literacy = Double.parseDouble(row[7]);
                census = new StateCensus(sNo, state, population, increase, area, density, sexRatio, literacy);
                censuses.add(census);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return censuses;
    }
}
