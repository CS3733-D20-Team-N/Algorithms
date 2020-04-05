package edu.wpi.N;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

  LinkedList<Node> nodes;
  HashMap<String, LinkedList<String>> edges;

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
  public void addEdge(String id1, String id2) {
    // TODO:
    // Add id2 to the list of "connections" of id1
    // Add id1 to the list of "connections" of id2
    // Make sure to check for overlap. I.e. if there is an edge between id1 and id2 already, then
    // don't do anything.
    // We must be able add an edge between nodes, which don't exist yet (this condition will make it
    // faster for us to parse CSV file)
    if (edges.get(id1) == null) {
      edges.put(id1, new LinkedList<String>());
    }
    if (edges.get(id2) == null) {
      edges.put(id2, new LinkedList<String>());
    }
    if (!edges.get(id1).contains(id2)) {
      LinkedList<String> nodes = edges.get(id1);
      nodes.add(id2);
      edges.put(id1, nodes);
    }
    if (!edges.get(id2).contains(id1)) {
      LinkedList<String> nodes = edges.get(id2);
      nodes.add(id1);
      edges.put(id2, nodes);
    }
  }
}
