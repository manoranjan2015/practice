package org.mano.thread.lock.number;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class is an example printing odd and event number sequentially 
 * by two threads. Event thread prints even number and odd thread prints odd number
 * @author Manoranjan
 *
 */

public class PrintOddEventNumbers 
{
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private int counter = 0;
	
	public void printOddNumbers() throws Exception 
	{
		System.out.println("Inside methhod odd number");
		while(true) 
		{
			if(lock.tryLock()) 
			{
				if(counter%2 != 0) 
				{
					System.out.println(Thread.currentThread().getName()+" prints odd number: "+ counter);
					counter++;
					condition.signalAll();
					condition.await();
					
					
				}
				else 
				{
					condition.await();
				}
			}
		}
	}
	
	
	public void printEvenNumbers() throws Exception 
	{
		System.out.println("Inside methhod even number");
		while(true) 
		{
			if(lock.tryLock()) 
			{
				if(counter%2 == 0) 
				{
					System.out.println(Thread.currentThread().getName()+" prints even number: "+ counter);
					Thread.sleep(1000);
					counter++;
					condition.signalAll();
					condition.await();
				}
				else 
				{
					condition.await();
				}
			}
		}
		
	}

}
