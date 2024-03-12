package com.BFS.SamplePracticeDay7;

import java.util.*;
class TreeNodes {
    int data;
    TreeNodes left, right;
    TreeNodes(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
class Tupless {
    TreeNodes node;
    int row;
    int col;
    public Tupless(TreeNodes _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}
public class TUF {
    public static List < List < Integer >> findVertical(TreeNodes root) {
        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        Queue < Tupless > q = new LinkedList < Tupless > ();
        q.offer(new Tupless(root, 0, 0));
        while (!q.isEmpty()) {
            Tupless Tupless = q.poll();
            TreeNodes node = Tupless.node;
            int x = Tupless.row;
            int y = Tupless.col;


            if (!map.containsKey(x)) {
                map.put(x, new TreeMap < > ());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue < > ());
            }
            map.get(x).get(y).offer(node.data);

            if (node.left != null) {
                q.offer(new Tupless(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tupless(node.right, x + 1, y + 1));
            }
        }
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    public static void main(String args[]) {

        TreeNodes root = new TreeNodes(1);
        root.left = new TreeNodes(2);
        root.left.left = new TreeNodes(4);
        root.left.right = new TreeNodes(10);
        root.left.left.right = new TreeNodes(5);
        root.left.left.right.right = new TreeNodes(6);
        root.right = new TreeNodes(3);
        root.right.left = new TreeNodes(9);
        root.right.right = new TreeNodes(10);

        List < List < Integer >> list = new ArrayList < > ();
        list = findVertical(root);

        System.out.println("The Vertical Traversal is : ");
        for (List < Integer > it: list) {
            for (int nodeVal: it) {
                System.out.print(nodeVal + " ");
            }
            System.out.println();
        }

    }
}