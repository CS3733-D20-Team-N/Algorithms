package edu.wpi.N;

public class Node implements Comparable<Node> {
  double xcoord, ycoord, score;
  String ID;

  public Node(double xcoord, double ycoord, String id) {
    this.xcoord = xcoord;
    this.ycoord = ycoord;
    this.ID = id;
    this.score = score;
  }

  @Override
  public int compareTo(Node other) {
    if(this.score > other.score) {
      return 1;
    }

    if(this.score < other.score) {
      return -1;
    }

    else
      return 0;
  }
}
