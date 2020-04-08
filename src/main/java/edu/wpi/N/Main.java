package edu.wpi.N;

import java.io.InputStream;

public class Main {

  public static void main(String[] args) {

    // relative path to .csv file
    InputStream input = Main.class.getResourceAsStream("csv/MapCoordinates.csv");

    CSVParser parser = new CSVParser();
    Graph nodeGraph = parser.parseCSV(input);
    Node startNode = nodeGraph.getNode("MOHSClinic");
    Node endNode = nodeGraph.getNode("HVMANeurology");
    Pathfinder newPath = new Pathfinder(nodeGraph, startNode, endNode);
    Path myPath = newPath.findPath();

    System.out.println("Set a break point here to see the path in debugger");

    // App.launch(App.class, args);
  }
}
