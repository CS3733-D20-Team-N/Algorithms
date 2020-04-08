package edu.wpi.N;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NodeMethodsTest {

  @DisplayName("CompareTo: score of first node < score of second node'")
  @Test
  public void testCompareToMethod1() {
    Node testNodeOne = new Node(5.5, 6.7, "TestNode");
    testNodeOne.score = 5;
    Node testNodeTwo = new Node(6.3, 2.3, "DifferentName");
    testNodeTwo.score = 6;

    // Score of testNodeOne is smaller than testNodeTwo score
    Assertions.assertEquals(testNodeOne.compareTo(testNodeTwo), -1);
  }

  @DisplayName("CompareTo: score of first node > score of second node")
  @Test
  public void testCompareToMethod2() {
    Node testNodeOne = new Node(5.5, 6.7, "TestNode");
    testNodeOne.score = 6;
    Node testNodeTwo = new Node(6.3, 2.3, "DifferentName");
    testNodeTwo.score = 5;

    // Score of testNodeOne is smaller than testNodeTwo score
    Assertions.assertEquals(testNodeOne.compareTo(testNodeTwo), 1);
  }

  @DisplayName("CompareTo: score of first node = score of second node")
  @Test
  public void testCompareToMethod3() {
    Node testNodeOne = new Node(5.5, 6.7, "TestNode");
    testNodeOne.score = 5;
    Node testNodeTwo = new Node(6.3, 2.3, "DifferentName");
    testNodeTwo.score = 5;

    // Score of testNodeOne is smaller than testNodeTwo score
    Assertions.assertEquals(testNodeOne.compareTo(testNodeTwo), 0);
  }

  @DisplayName("CompareTo: null as input")
  @Test
  public void testCompareToMethod4() {
    Node testNodeOne = new Node(5.5, 6.7, "TestNode");
    testNodeOne.score = 5;

    // Score of testNodeOne is smaller than testNodeTwo score
    Assertions.assertThrows(NullPointerException.class, () -> testNodeOne.compareTo(null));
  }

  @DisplayName("Equals: similar node IDs")
  @Test
  public void testEquals1() {
    Node testNodeOne = new Node(5.5, 6.7, "TestNodeOne");
    Node testNodeTwo = new Node(1.1, 6.7, "TestNodeOne");

    Assertions.assertEquals(testNodeOne.equals(testNodeTwo), true);
  }

  @DisplayName("Equals: different node IDs")
  @Test
  public void testEquals2() {
    Node testNodeOne = new Node(5.5, 6.7, "TestNodeOne");
    Node testNodeTwo = new Node(1.1, 6.7, "TestNodeTwo");

    Assertions.assertEquals(testNodeOne.equals(testNodeTwo), false);
  }

  @DisplayName("Equals: compare with Null")
  @Test
  public void testEquals3() {
    Node testNodeOne = new Node(1, 2, "TestNodeOne");
    Assertions.assertEquals(testNodeOne.equals(null), false);
  }
}
