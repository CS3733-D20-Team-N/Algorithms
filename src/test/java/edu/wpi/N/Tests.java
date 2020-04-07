package edu.wpi.N;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

public class Tests {

  InputStream input = Main.class.getResourceAsStream("csv/MapCoordinates.csv");
  CSVParser parser = new CSVParser();
  Graph testGraph = parser.parseCSV(input);
  Node startNode = testGraph.getNode("MOHSClinic");
  Node endNode = testGraph.getNode("HVMANeurology");
  Pathfinder newPath = new Pathfinder(testGraph, startNode, endNode);
  Path myPath = newPath.findPath();

  /** Tests that getEdges(nodeID) returns the correct list of edges for a given node */
  @Test
  public void getEdgesTester() {
    LinkedList<String> hall1Edges = new LinkedList<String>();
    hall1Edges.add("MOHSClinic");
    hall1Edges.add("HALL2");
    assertEquals(testGraph.getEdges("HALL1"), hall1Edges);

    LinkedList<String> hall3Edges = new LinkedList<String>();
    hall3Edges.add("HALL2");
    hall3Edges.add("HALL4");
    assertEquals(testGraph.getEdges("HALL3"), hall3Edges);

    LinkedList<String> neurologyEdges = new LinkedList<String>();
    neurologyEdges.add("HALL6");
    assertEquals(testGraph.getEdges("Neurology"), neurologyEdges);
  }

  /**
   * Tests that getEdges(nodeID) will return null if the node is not in the graph and if the node
   * does not have any edges
   */
  @Test
  public void getEdgesNullTester() {
    Node testNode = new Node(2.345, 5.5657, "TESTNODE");
    assertNull(testGraph.getEdges("TESTNODE"));

    testGraph.addNode(testNode);
    assertNull(testGraph.getEdges("TESTNODE"));
  }

  /**
   * Tests that addEdges(nodeID1,nodeID2) will add the given edge to the list of nodes for both
   * given nodes
   */
  @Test
  public void addEdgesTester() {
    LinkedList<String> hall1Edges = new LinkedList<String>();
    hall1Edges.add("MOHSClinic");
    hall1Edges.add("HALL2");
    hall1Edges.add("HALL3");
    testGraph.addEdge("HALL1", "HALL3");
    assertEquals(testGraph.getEdges("HALL1"), hall1Edges);

    LinkedList<String> hall3Edges = new LinkedList<String>();
    hall3Edges.add("HALL2");
    hall3Edges.add("HALL4");
    hall3Edges.add("HALL1");
    assertEquals(testGraph.getEdges("HALL3"), hall3Edges);
  }

  /**
   * Tests that addEdges(nodeID1,nodeID2) will create a list of edges for a node that currently has
   * no edges
   */
  @Test
  public void addEdgesEmptyNodeTester() {
    testGraph.addEdge("TESTNODE", "Elevator");
    LinkedList<String> testNodeEdges = new LinkedList<String>();
    testNodeEdges.add("Elevator");
    assertEquals(testGraph.getEdges("TESTNODE"), testNodeEdges);
  }

  /**
   * Tests that a duplicate edge will not be added if you run addEdge(nodeID1,nodeID2) on an edge
   * that already exists
   */
  @Test
  public void addEdgeAlreadyThereTester() {
    LinkedList<String> neurologyEdges = new LinkedList<String>();
    neurologyEdges.add("HALL6");
    LinkedList<String> hall6Edges = new LinkedList<String>();
    hall6Edges.add("HALL5");
    hall6Edges.add("HALL7");
    hall6Edges.add("Neurology");
    testGraph.addEdge("HALL6", "Neurology");
    assertEquals(testGraph.getEdges("Neurology"), neurologyEdges);
    assertEquals(testGraph.getEdges("HALL6"), hall6Edges);
  }

  /** Tests that heuristic(currNode, endNode) returns the correct calculated value */
  @Test
  public void heuristicTester() {
    assertEquals(
        newPath.heuristic(testGraph.getNode("MOHSClinic"), testGraph.getNode("HALL1")),
        0.77,
        0.0001);
  }

  /**
   * Tests that heuristic(currNode, endNode) returns the correct calculated value for a node that is
   * not in the graph
   */
  @Test
  public void heuristicNotInGraphTester() {
    Node testNode1 = new Node(1, 0, "TESTNODE1");
    Node testNode2 = new Node(0, 1, "TESTNODE2");
    assertEquals(newPath.heuristic(testNode1, testNode2), 2, 0.0001);
  }
}
