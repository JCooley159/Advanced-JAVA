package src;



public class ArraySumRunnable implements Runnable 
{
	// Fields
	private Sum sum;		// holds the Sum to reference/work with
	private double[] nthSubArray;
	private double subtotal;
		
	
	// Constructor
	public ArraySumRunnable(Sum sumInstance, double[] nthSubArray) 
	{
		this.sum = sumInstance;
		this.nthSubArray = nthSubArray;
		this.subtotal = 0.0;
	}
	
	

	// Run method
	@Override
	public void run() 
	{
		
		// finds a sub-total for the array
		for (double element : nthSubArray)
		{
			subtotal = subtotal + element;
		}
        
		System.out.println("The subtotal for this thread is: " + subtotal);
      
        sum.add(subtotal);


		
	}
	
	
}
