package org.mano.thread.waitAndNotify;

import org.mano.thread.lock.number.PrintOddEventNumbers;

public class TestPrintNumber {

	public static void main(String[] args) 
	{
		//PrintNumbersUsingWaitAndNotify printNumbers = new PrintNumbersUsingWaitAndNotify();
		PrintOddEventNumbers printNumbers = new PrintOddEventNumbers();
		
		Thread thOdd = new Thread(new Runnable() {
			
			@Override
			public void run() {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						printNumbers.printOddNumbers();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			
		}, "OddThread");
		
		thOdd.start();
		
Thread thEven= new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				{
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  try {
					printNumbers.printEvenNumbers();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		}, "EvenThread");


thEven.start();
		

	}

}
