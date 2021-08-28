package src;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sum 
{

	private Double sumDouble;
	private Lock sumLock;
	
	public Sum()
	{
		sumDouble = 0.00;
		sumLock = new ReentrantLock();
	}
	
	
	
	
	// lock and unlock in the methods in the shared data class
	public void add(double amount)
	{
		sumLock.lock();
		try 
		{
			sumDouble = sumDouble + amount;
			System.out.println("The new sum is: " + sumDouble.toString());
		}
		finally
		{
			sumLock.unlock();
		}
		
	}
	
	
}
