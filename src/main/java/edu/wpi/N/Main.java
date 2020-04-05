package edu.wpi.N;

public class Main {

  public static void main(String[] args) {

    // specify path to .csv file
    String pathToFile = Main.class.getResource("csv/MapCoordinates.csv").getPath();

    CSVParser parser = new CSVParser();
    Graph nodeGraph = parser.parseCSV(pathToFile);
    System.out.println("check");
    // App.launch(App.class, args);

  }
}
