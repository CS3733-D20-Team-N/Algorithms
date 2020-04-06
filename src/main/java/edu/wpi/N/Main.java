package edu.wpi.N;

import java.io.File;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) {

    // relative path to .csv file
    File file = new File("src/main/resources/edu/wpi/N/csv/MapCoordinates.csv");
    String pathToFile = file.getAbsolutePath();

    CSVParser parser = new CSVParser();
    Graph nodeGraph = parser.parseCSV(pathToFile);
    Node startNode = nodeGraph.getNode("MOHSClinic");
    Node endNode = nodeGraph.getNode("HVMANeurology");
    Pathfinder newPath = new Pathfinder(nodeGraph, startNode, endNode);
    LinkedList<Node> myPath = newPath.pathfinder();

    System.out.println("check");
    // App.launch(App.class, args);

  }
}
