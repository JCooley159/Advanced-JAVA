package src;

import java.util.Scanner;

public class NineMillionMain 
{
		
	// no constructor needed
	
	public static void main(String[] args) 
	{
		
	// Fields
		int nineMil = 9000000;						// size
		int numThreads = 10;						// to be variable
		int nThs = nineMil / numThreads;			// the size of each subset of nmArray
		double[] nmArray = new double[nineMil];		// field for the 9 Million array
		Sum sum = new Sum();						// new shared data class
		NineMillionMain nmm = new NineMillionMain();// new object instance
		
		
		
	// Interface   (GUI to be added for extra credit)
		Scanner input = new Scanner(System.in);
		System.out.println("Hi! Welcome to Jeremy Cooley's Thread Test. \n \n How many "
				+ "threads do you want to split our size 9 Million into? \n");
		numThreads = Integer.parseInt(input.nextLine());
		System.out.println("Okay, " + numThreads + " threads it is. Would you like to "
				+ "use randomized numbers or all ones for this test?");
		String onesRand = input.nextLine();
		
	// Sets the values of the array
		if (onesRand.equalsIgnoreCase("ones"))
		{
			nmm.setArrayNums(nmArray);
		}
		else
		{
			nmm.setRandArrayNums(nmArray);
		}
		input.close();
		
		
	// starts a timer for the code
		long startTime = System.currentTimeMillis();
	// Runs numThreads times, creating threads that process the array accordingly 
		for (int i = 0; i < numThreads; i++)
		{
			
		// Creates an array of length nThs
			double[] nthSubArray = new double[ nThs ];
			
		// finds the index to begin at for each chunk of array 
			int beginIndex = i * nThs;
			
			
		// copies the chunk of the original array into nthSubArray
			System.arraycopy( nmArray, beginIndex, nthSubArray, 0, nThs );
			
			
		// Creates the Runnable with the Sum object and sub-array 
			ArraySumRunnable sumRun = new ArraySumRunnable( sum, nthSubArray ); // new runnable
			
		// Assigns the sumRunnable to a thread & runs it 
			Thread t = new Thread( sumRun );
						
			t.start();
		// --> see ArraySumRunnable.run()
		// where the sub-array is totaled and added to the Sum object
			
		}
		
		
		// Calculates the time for a given number of threads to complete
		long endTime = System.currentTimeMillis();
	    System.out.println("\nIt took " + ((endTime - startTime) / 100) +
	    		" seconds for " + numThreads + " threads to complete the array sum.");
		
		
	}

	
	
	
	// setArrayNums() - for setting the values to 1 or random
	public void setArrayNums(double[] nmArray)
	{
		for (int i = 0; i < nmArray.length; i++)
		{
			nmArray[i] = 1; 
		}
	}
	
	
	// setArrayNums() - for setting the array values to random #'s between 1 and 10
	public void setRandArrayNums(double[] nmArray)
	{
		for (int i = 0; i < nmArray.length; i++)
		{
			nmArray[i] = Math.random() * 10;
		}
	}
	
	
	
	
	
}