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
   * Function calculates Euclidean distance between start and current Node (cost of given node)
   *
   * @param currNode: current Node
   * @return: Euclidean distance from the start
   */
  public double cost(Node currNode) {
    return Math.sqrt(
        Math.pow(start.xcoord - currNode.xcoord, 2) + Math.pow(start.ycoord - currNode.ycoord, 2));
  }

  /**
   * Function calculates Manhatten distance between goal and current Node
   *
   * @param currNode: current Node
   * @return: Manhatten distance to the goal Node
   */
  public double heuristic(Node currNode) {
    return Math.abs(end.xcoord - currNode.xcoord) + Math.abs(end.ycoord - currNode.ycoord);
  }

  /**
   * Finds the shortest path from Start to Goal node
   *
   * @return the shortest path to the goal Node from Start Node
   */
  public LinkedList<Node> pathfinder() {
    return null;
  }
}
