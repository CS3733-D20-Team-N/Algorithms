package edu.wpi.N;

import java.util.LinkedList;

public class Pathfinder {
  Graph graph;
  Node start, end;

  public Pathfinder(Graph graph, Node start, Node end) {
    this.graph = graph;
    this.start = start;
    this.end = end;
  }

  /**
   * Calculate the cost value of the given node
   *
   * @param currNode: The current node
   * @return: The cost of the given node
   */
  public double cost(Node currNode) {
    return Math.sqrt(
        Math.pow(start.xcoord - currNode.xcoord, 2) + Math.pow(start.ycoord - currNode.ycoord, 2));
  }

  // heuristic function
  public double heuristic(Node currNode) {
    return Math.abs(end.xcoord - currNode.xcoord) + Math.abs(end.ycoord - currNode.ycoord);
  }

  // path finder
  public LinkedList<Node> pathfinder() {
    return null;
  }
}
