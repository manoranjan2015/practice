package org.mano.data.structure.tree.test;

import org.junit.Assert;
import org.junit.Test;
import org.mano.data.structure.tree.BinarySearchTree;

public class BinarySearchTreeTest 
{
	
	@Test
	public void testInsert() 
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(2);
		bst.insert(81);
		bst.insert(87);
		bst.insert(42);
		bst.insert(66);
		bst.insert(90);
		bst.insert(45);
	    Assert.assertTrue(bst.search(2));
	    Assert.assertTrue(bst.search(81));
	    Assert.assertTrue(bst.search(87));
	    Assert.assertTrue(bst.search(42));
	    Assert.assertTrue(bst.search(66));
	    Assert.assertTrue(bst.search(90));
	    Assert.assertTrue(bst.search(45));
	    Assert.assertFalse(bst.search(49));
	}
	
	@Test
	public void testverifyBst() 
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(2);
		bst.insert(81);
		bst.insert(87);
		bst.insert(42);
		bst.insert(66);
		bst.insert(90);
		bst.insert(45);
		
		Assert.assertTrue(bst.verifyIfBst());
	}
	
	@Test
	public void testSerchWithoutRecurssion() 
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(2);
		bst.insert(81);
		bst.insert(87);
		bst.insert(42);
		bst.insert(66);
		bst.insert(90);
		bst.insert(45);
		Assert.assertTrue(bst.searchWithoutRecussion(2));
		Assert.assertFalse(bst.searchWithoutRecussion(100));
	}

	@Test
	public void testPreOrdertraversalUsingStack() 
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(2);
		bst.insert(81);
		bst.insert(87);
		bst.insert(42);
		bst.insert(66);
		bst.insert(90);
		bst.insert(45);
		
	bst.preOrdertraversalUsingStack();
	}
	
	@Test
	public void testpostOrdertraversalUsingStack() 
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(2);
		bst.insert(81);
		bst.insert(87);
		bst.insert(42);
		bst.insert(66);
		bst.insert(90);
		bst.insert(45);
		bst.postOrderTraversalUsingStack();
		
		
	}
	/**
	 * 
	 */
	
	
	@Test
	public void traversePreOrderUisingRecursionTest() 
	{
		System.out.println("start");
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(2);
		bst.insert(81);
		bst.insert(87);
		bst.insert(42);
		bst.insert(66);
		bst.insert(90);
		bst.insert(45);
		bst.traversePreOrderUisingRecursion();
		System.out.println("end");
		
	}
	
	@Test
	public void traverseInOrderUisingRecursionTest() 
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(2);
		bst.insert(81);
		bst.insert(87);
		bst.insert(42);
		bst.insert(66);
		bst.insert(90);
		bst.insert(45);
		bst.traverseInOrderUisingRecursion();
		
	}
}
