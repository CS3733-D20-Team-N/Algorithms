package edu.wpi.N;

import java.util.LinkedList;

public class Pathfinder {
    Graph graph;
    Node start, end;

    public Pathfinder(Graph graph, Node start, Node end){
        this.graph=graph;
        this.start=start;
        this.end=end;
    }

    //cost function
    public double cost(Node currNode){
        return 0;
    }


    //heuristic function
    public double heuristic(Node currNode){
        return 0;
    }

    //path finder
    public LinkedList<Node> pathfinder(){
        return null;
    }
}
