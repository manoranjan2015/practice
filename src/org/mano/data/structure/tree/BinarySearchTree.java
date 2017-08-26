package org.mano.data.structure.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class BinarySearchTree {
	private Node root;

	public void insert(int data) {
		if (null == root) {
			root = initializeNode(data);
		} else {
			insertNode(initializeNode(data));
		}
	}

	private Node initializeNode(int data) {
		Node node = new Node(null, null, data);
		return node;

	}

	public void insertNode(Node newNode) 
	{
		Node currentNode = root;
		while (true)
		{
			if (newNode.data < currentNode.data) {
				Node left;
				if (null == (left = currentNode.leftNode)) {
					currentNode.leftNode = newNode;
					break;
				} else {
					currentNode = left;
					continue;
				}
			} else if (newNode.data > currentNode.data) {
				Node right;
				if (null == (right = currentNode.rightnode)) {
					currentNode.rightnode = newNode;
					break;
				} else {
					currentNode = right;
					continue;
				}
			}
			else 
			
				System.out.println("BST can not contain duplicat elements:"+ newNode.data);
			}
	}
	

	public void inOrdertraversalUsingStack() {
		LinkedList<Node> list = new LinkedList<>();
		Node current = root;
		if (null == current) {
			return;
		}
		while (true) 
		{

			if (null == current && list.isEmpty()) {
				break;
			}

			if (null != current) {
				list.add(current);
				current = current.leftNode;
				continue;
			} else {
				Node popedNode = list.removeLast();
				System.out.println(popedNode.data);
				current = popedNode.rightnode;
			}
		}

	}
	
	
	
	public void preOrdertraversalUsingStack() 
	{
		LinkedList<Node> list = new LinkedList<>();
		Node current = root;
		if (null == current) {
			return;
		}
		list.add(root);
		while (true)
		{

			if ( list.isEmpty())
			{
				break;
			}
			else
			{
			
				Node popedNode = list.removeLast();
				System.out.println(popedNode.data);
				if(null != popedNode.rightnode) 
				{
				  list.add(popedNode.rightnode);
				}
				if(null != popedNode.leftNode) 
				{
				  list.add(popedNode.leftNode);
				}
				//current = popedNode;
			}
		}
	}
	
	
	public void postOrderTraversalUsingStack() 
	{
		LinkedList<Node> list = new LinkedList<>();
		Node current = root;
		if (null == current) {
			return;
		}
		while (true) {

			if (list.isEmpty()) {
				break;
			}

			if (null != current) 
			{
					
				list.add(current);
				if(null != current.rightnode) 
				{ 
					list.add(current.rightnode);
				}
				current = current.leftNode;
			}
			else 
			{
					current  = list.removeLast();
					Node prev = list.getLast();
					if(null != prev.rightnode && current == prev.rightnode) 
					{
						continue;
						
					}
					else 
					{
						System.out.println(current.data);
						current = null;
					}
					continue;			
				
			}
		}
	}
	
	
	public void traversePreOrderUisingRecursion() 
	{
		traversePreOrderUisingRecursion(root);
	}
	
	public void traversePreOrderUisingRecursion(Node currNode) 
	{
		
		if(null != currNode) 
		{
			System.out.println(currNode.getData());
			traversePreOrderUisingRecursion(currNode.leftNode);
			traversePreOrderUisingRecursion(currNode.rightnode);	
		}
		else 
		{
			return;
		}
		
			
	}
	
	
	public void traverseInOrderUisingRecursion() 
	{
		traverseInOrderUisingRecursion(root);
	}
	
	public void traverseInOrderUisingRecursion(Node currNode) 
	{
		
		if(null != currNode) 
		{
			traverseInOrderUisingRecursion(currNode.leftNode);
			System.out.println(currNode.getData());
			traverseInOrderUisingRecursion(currNode.rightnode);
		}
		else 
		{
			return;
		}
				
	}
	
	public boolean verifyIfBst()
	{
		return verifyIfBst(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
		
	}
	
	private boolean verifyIfBst(Node currentNode, int max , int min) 
	{
		if(null == currentNode ) 
		{
			return true;
		}
		
		if( currentNode.data > max || currentNode.data < min) 
		{
			return false;
		}	
		
		
		
		return (verifyIfBst(currentNode.leftNode, currentNode.data-1, Integer.MIN_VALUE) 
				&& verifyIfBst(currentNode.rightnode, Integer.MAX_VALUE, currentNode.data+1));
	}
		
	
	
	public boolean  search(int data) 
	{
		Map<Node, Node> map = new TreeMap();
		return searchNode(data, root);
		
	}
	
	public boolean  searchWithoutRecussion(int data) 
	{
		Map<Node, Node> map = new TreeMap();
		return serachNodeWithoutRecurssion(data);
		
	}
	
	private boolean serachNodeWithoutRecurssion(int data) 
	{
		Node currNode = this.root;
		while(true) 
		{			
			if(null == currNode) 
			{
				return false;
			}
			else if(data == currNode.data) 
			{
				return true;
			}
			else 
			{
				if(data < currNode.data) 
				{
					currNode = currNode.leftNode;
				}
				else 
				{
					currNode = currNode.rightnode;
				}
			}
		}
	}
	
	private boolean searchNode(int data, Node root) 
	{
		
		    Node currentNode = root;		
			if(null == currentNode) 
			{
				return false;
			}
			else if( data == currentNode.data) 
			{
				return true;
			}
			else 
			{
				if(data < currentNode.data) 
				{
					return searchNode(data, currentNode.leftNode);
				}
				else 
				{
					return searchNode(data, currentNode.rightnode);
					
				}
			}
		
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	private static class Node {

		private Node(Node leftNode, Node rightnode, int data) {
			super();
			this.leftNode = leftNode;
			this.rightnode = rightnode;
			this.data = data;
		}

		private Node leftNode;
		private Node rightnode;
		private int data;
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
	}

}
