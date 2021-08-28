package src;

public class SumRunnable implements Runnable 
{
	private Sum sum;
	
	
	public SumRunnable(Sum sum) 
	{
		this.sum = sum;
	}
	
	
	
	public void run()
	{
		
		 sum.add();
	}
	
	
	
	
	
}
