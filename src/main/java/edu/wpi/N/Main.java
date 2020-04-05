package edu.wpi.N;

import java.util.LinkedList;

public class Main {

  public static void main(String[] args) {

    // specify path to .csv file
    String pathToFile = Main.class.getResource("csv/MapCoordinates.csv").getPath();

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
