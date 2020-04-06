package edu.wpi.N;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

  private LinkedList<Node> nodes;
  private HashMap<String, LinkedList<String>> edges;

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
    Iterator<Node> nodeIt = this.nodes.iterator();
    Node n;
    while (nodeIt.hasNext()) {
      n = nodeIt.next();
      if (n.ID.equals(id)) return n;
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
    edges.computeIfAbsent(id1, k -> new LinkedList<String>());
    edges.computeIfAbsent(id2, k -> new LinkedList<String>());
    if (!edges.get(id1).contains(id2)) {
      LinkedList<String> nodes = edges.get(id1);
      nodes.add(id2);
    }
    if (!edges.get(id2).contains(id1)) {
      LinkedList<String> nodes = edges.get(id2);
      nodes.add(id1);
    }
  }
}
