package com.BFS.SamplePracticeDay8;

public class Node {
	int data;
	Node left;
	Node right;
	Node(int data, Node left, Node right){
		this.data=data;
		this.left=left;
		this.right=right;
	}
	Node(int data){
		this.data= data;
	}
}
