package src;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sum 
{

	private Integer sumInt;
	private Lock sumLock;
	
	public Sum()
	{
		sumInt = 0;
		sumLock = new ReentrantLock();
	}
	
	
	
	
	
	public void add()
	{
		sumLock.lock();
		try 
		{
			sumInt++;
			System.out.println("The new sum is: " + sumInt.toString());
		}
		finally
		{
			sumLock.unlock();
		}
		
	}
	
	
}
