package edu.wpi.N;

import java.util.LinkedList;
import java.util.Map;

public class Graph {

    LinkedList<Node> nodes;
    Map<String, LinkedList<String>> edges;

    public Graph(LinkedList<Node> nodes, Map<String, LinkedList<String>> edges){
        this.nodes=nodes;
        this.edges=edges;
    }

    public Node getNode(String id){
        for(int i=0; i<nodes.size(); i++){
            if(this.nodes.get(i).ID.equals(id))
                return this.nodes.get(i);
        }
        return null;
    }

    public void addNode(Node node){
        this.nodes.add(node);
    }

}
