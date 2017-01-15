package me.osrecki.prog.java.ctci.chapter4;

import java.util.Random;

public class BST {
  private final Random random = new Random();

  private Node root;

  void insert(int value) {
    if (root == null) {
      root = new Node(value);
    } else {
      root.insert(value);
    }
  }

  Node find(int value) {
    if (root == null) return null;

    return root.find(value);
  }

  void delete(int value) {
    if (root != null)
      root.delete(value);
  }

  Node random() {
    if(root == null) return null;

    int i = random.nextInt(root.size);
    return root.ithNode(i);
  }

  static class Node {
    int value;
    int size;
    Node left, right;

    Node(int value) {
      this(value, null, null);
    }

    Node(int value, Node left, Node right) {
      this.value = value;
      this.left = left;
      this.right = right;
      this.size = calculateSize();
    }

    void insert(int v) {
      if (v <= value) {
        if (left == null) {
          left = new Node(v);
        } else {
          left.insert(v);
        }
      } else {
        if (right == null) {
          right = new Node(v);
        } else {
          right.insert(v);
        }
      }

      size++;
    }

    Node delete(int v) {
      if (v == value) {
        if (left == null && right == null) {
          return null;
        } else if (left == null) {
          return right;
        } else if (right == null) {
          return left;
        } else {
          Node minRight = right.min();
          value = minRight.value;
          right = right.delete(v);
        }
      } else if (v <= value && left != null) {
        left = left.delete(v);
      } else if (right != null) {
        right = right.delete(v);
      }

      size = calculateSize();

      return this;
    }

    Node find(int v) {
      if (v == value) {
        return this;
      } else if (v <= value && left != null) {
        return left.find(v);
      } else if (v > value && right != null) {
        return right.find(v);
      }

      return null;
    }

    Node ithNode(int i) {
      int border = (left == null) ? 0 : left.size;

      if (i < border) {
        return left.ithNode(i);
      } else if (i == border) {
        return this;
      } else {
        return right.ithNode(i - (border + 1));
      }
    }


    private Node min() {
      Node current = this;
      while (current.left != null) {
        current = current.left;
      }
      return current;
    }

    private int calculateSize() {
      size = 1;
      if (left != null) size += left.size;
      if (right != null) size += right.size;

      return size;
    }
  }
}
