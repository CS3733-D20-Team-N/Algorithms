package edu.wpi.N;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class Pathfinder {
  Graph graph;
  Node start, end;

  public Pathfinder(Graph graph, Node start, Node end) {
    this.graph = graph;
    this.start = start;
    this.end = end;
  }

  /**
   * Function calculates Euclidean distance between the next Node and current Node (cost of given node)
   *
   * @param currNode: current Node
   * @param nextNode: next Node
   * @return: Euclidean distance from the start
   */
  public double cost(Node currNode, Node nextNode) {
    return Math.sqrt(
        Math.pow(nextNode.xcoord - currNode.xcoord, 2) + Math.pow(nextNode.ycoord - currNode.ycoord, 2));
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
    PriorityQueue<Node> frontier = new PriorityQueue<Node>();
    frontier.add(start);
    Map<String, String> came_from = new HashMap<String, String>();
    Map<String, Double> cost_so_far = new HashMap<String, Double>();
    came_from.put(start.ID, "");
    cost_so_far.put(start.ID, 0.0);
    start.score = 0;

    while(!frontier.isEmpty()) {
      Node current = frontier.poll();

      if(current == end) {
        break;
      }

      for(String next : graph.getEdges(current.ID)) {
        double new_cost = cost_so_far.get(next) + this.cost(graph.getNode(next), current);
        if(cost_so_far.get(next) != null || new_cost < cost_so_far.get(next)) {
          cost_so_far.put(next, new_cost);
          double priority = new_cost + heuristic(graph.getNode(next));



        }


      }

    }


    return null;
  }
}
