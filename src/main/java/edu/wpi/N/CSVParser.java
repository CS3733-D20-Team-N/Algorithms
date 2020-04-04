package edu.wpi.N;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class CSVParser {

    /**
     * Parse CSV file and create graph
     *
     * @param pathToFile: path to CSV file
     * @return Graph created from given CSV file
     */
    public Graph parseCSV(String pathToFile) {

        Graph graphFromCSV = new Graph();

        try {
            // Create an object of filereader
            FileReader fileReader = new FileReader(pathToFile);
            // create csvReader object passing
            CSVReader csvReader = new CSVReader(fileReader);

            String[] nextLine;

            // Read header
            csvReader.readNext();
            // Read data line by line except header
            while ((nextLine = csvReader.readNext()) != null) {

                // Read respective columns of the row
                String id = nextLine[0];
                double xcoord = Double.parseDouble(nextLine[1]);
                double ycoord = Double.parseDouble(nextLine[3]);

                // Create new node
                Node node = new Node(xcoord, ycoord, id);
                // Add to Graph
                graphFromCSV.addNode(node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return graphFromCSV;
    }
}
