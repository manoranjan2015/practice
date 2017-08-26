package org.mano.thread.waitAndNotify;

/**
 * This class is a implementation to print odd and even number concurrently by two threads.
 * Make sure only one instance is created. Same instance is used by both thread to print odd and even number
 * alternatively.
 * @author Manoranjan
 *
 */

public class PrintOddAndEvenNumbers 
{
   private int counter = 1;
   
   public static final Object lock = new Object();
   
   
   /**
    * Call this method to print odd numbers
    */
  public void printEvenNumbers() 
  {
	  while(true) 
	  {
	    synchronized (lock) 
		  {
			try
			{
				if(counter%2 == 0) 
				  {
					System.out.println(Thread.currentThread().getName()+" print:"+counter);
					counter++;
					  Thread.sleep(2 *1000);
					  lock.notifyAll();
					lock.wait();
				  }
				else 
				  {  
					  /*synchronized (lock) 
					  {
						  System.out.println(Thread.currentThread().getName()+" aquired lock");
						  System.out.println("Thread:"+Thread.currentThread().getName() +" printing odd number:"+counter);
						  counter++;
						  Thread.sleep(2 *1000);
						  lock.notifyAll();
					 // }
*/
					lock.wait();
				  }
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		  }
	  }
	    
	  
  }
  
  /**
   * Call this method to print event number
   */
  public void printOddNumbers() 
  {
	  while(true) 
	  {
		  synchronized (lock) 
		  {
			try
			{
				if(counter%2 != 0) 
				  {
					System.out.println(Thread.currentThread().getName()+" print:"+counter);
					 counter++;
					  Thread.sleep(2 *1000);
					  lock.notifyAll();
					lock.wait();
				  }
				else 
				  {  
					  /*synchronized (lock) 
					  {
						 System.out.println(Thread.currentThread().getName()+" aquired lock");
						  System.out.println("Thread:"+Thread.currentThread().getName() +" printing even number:"+counter);
						  counter++;
						  Thread.sleep(2 *1000);
						  lock.notifyAll();
					 // }
*/					    
					lock.wait();
				  }
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	  }	  

}}