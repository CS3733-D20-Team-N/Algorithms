package edu.wpi.N;

import java.io.InputStream;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) {

    // relative path to .csv file
    InputStream input = Main.class.getResourceAsStream("csv/MapCoordinates.csv");

    CSVParser parser = new CSVParser();
    Graph nodeGraph = parser.parseCSV(input);
    Node startNode = nodeGraph.getNode("MOHSClinic");
    Node endNode = nodeGraph.getNode("HVMANeurology");
    Pathfinder newPath = new Pathfinder(nodeGraph, startNode, endNode);
    LinkedList<Node> myPath = newPath.pathfinder();

    System.out.println("check");
    // App.launch(App.class, args);
  }
}
