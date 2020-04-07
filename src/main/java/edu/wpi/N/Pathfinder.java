package edu.wpi.N;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class Pathfinder {
  private Graph graph;
  private Node start, end;

  public Pathfinder(Graph graph, Node start, Node end) {
    this.graph = graph;
    this.start = start;
    this.end = end;
  }

  /**
   * Function calculates Euclidean distance between the next Node and current Node (cost of given
   * node)
   *
   * @param currNode: current Node
   * @param nextNode: next Node
   * @return: Euclidean distance from the start
   */
  private static double cost(Node currNode, Node nextNode) {
    return Math.sqrt(
        Math.pow(nextNode.getX() - currNode.getX(), 2)
            + Math.pow(nextNode.getY() - currNode.getY(), 2));
  }

  /**
   * Function calculates Manhatten distance between goal and current Node
   *
   * @param currNode: current Node
   * @return: Manhattan distance to the goal Node
   */
  static double heuristic(Node currNode, Node end) {
    return Math.abs(end.getX() - currNode.getX()) + Math.abs(end.getY() - currNode.getY());
  }

  /**
   * Finds the shortest path from Start to Goal node
   *
   * @return the shortest path to the goal Node from Start Node
   */
  public LinkedList<Node> pathfinder() {
    PriorityQueue<Node> frontier = new PriorityQueue<Node>();
    frontier.add(start);
    Map<String, String> came_from = new HashMap<String, String>();
    Map<String, Double> cost_so_far = new HashMap<String, Double>();
    came_from.put(start.ID, "");
    cost_so_far.put(start.ID, 0.0);
    start.score = 0;

    while (!frontier.isEmpty()) {
      Node current = frontier.poll();

      if (current == end) {
        break;
      }

      for (String nextID : graph.getEdges(current.ID)) {
        Node next_node = graph.getNode(nextID);
        double new_cost = cost_so_far.get(current.ID) + cost(next_node, current);
        if (!cost_so_far.containsKey(nextID) || new_cost < cost_so_far.get(nextID)) {
          cost_so_far.put(nextID, new_cost);
          double priority = new_cost + heuristic(next_node, end);
          next_node = graph.getNode(nextID);
          next_node.score = priority;
          frontier.add(next_node);
          came_from.put(nextID, current.ID);
        }
      }
    }

    String currentID = end.ID;
    LinkedList<Node> path = new LinkedList<Node>();
    path.add(this.graph.getNode(currentID));

    while (!currentID.equals(start.ID)) {
      currentID = came_from.get(currentID);
      path.add(this.graph.getNode(currentID));
    }

    return path;
  }
}
