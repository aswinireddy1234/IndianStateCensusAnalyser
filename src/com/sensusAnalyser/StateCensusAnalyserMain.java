package com.sensusAnalyser;
import com.opencsv.exceptions.CsvException;
import com.sun.tools.javac.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StateCensusAnalyserMain {
    StateCensus stateCensusAnalyser = new StateCensus();
    Scanner scanner = new Scanner(System.in);
    StateCensus census;
    List<StateCensus> censuses = new ArrayList<>();
    public void menu() throws CsvException, IOException {
        System.out.println("Menu 1. Read from CSV file and print 2. Print data from csv file 3. Exit");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                censuses = stateCensusAnalyser.readCSV();
                menu();
                break;
            case 2:
                for(StateCensus values : censuses) {
                    System.out.println(values);
                }
                menu();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid option");
                menu();
                break;
        }
    }
    public static void main(String[] args) throws CsvException, IOException {
        System.out.println("Welcome to Indian state census analyser program");
        Main main = new Main();
        main.menu();
    }
}
