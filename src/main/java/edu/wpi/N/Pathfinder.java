package edu.wpi.N;

import java.util.LinkedList;
import java.lang.Math;

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
        return Math.abs(end.xcoord-currNode.xcoord)+ Math.abs(end.ycoord-currNode.ycoord);
    }

    //path finder
    public LinkedList<Node> pathfinder(){
        return null;
    }
}
