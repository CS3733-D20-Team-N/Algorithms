package edu.wpi.N;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {

  LinkedList<Node> nodes;
  Map<String, LinkedList<String>> edges;

  public Graph() {
    this.nodes = new LinkedList<Node>();
    this.edges = new HashMap<String, LinkedList<String>>();
  }

  /**
   * Search for the node
   *
   * @param id: id of the node
   * @return: node with the given id
   */
  public Node getNode(String id) {
    for (int i = 0; i < nodes.size(); i++) {
      if (this.nodes.get(i).ID.equals(id)) return this.nodes.get(i);
    }
    return null;
  }

  /**
   * Add new node to the graph
   *
   * @param node
   */
  public void addNode(Node node) {
    this.nodes.add(node);
  }

  /**
   * Get all the edges a node is connected with
   *
   * @param id: id of the Node
   * @return: List of IDs of nodes, the given node is connected to
   */
  public LinkedList<String> getEdges(String id) {
    return this.edges.get(id);
  }

  /**
   * Add an Edge between 2 nodes
   *
   * @param id1: Id of the first node
   * @param id2: Id of the second node
   */
  public void addEdge(String id1, String id2) {}
}
