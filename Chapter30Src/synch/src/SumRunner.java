package src;

public class SumRunner {

	
	
	public static void main(String[] args) 
	{

		Sum sumInstance = new Sum();
		final int thousand = 1000;
		
		
		for (int i = 1; i <= thousand; i++)
		{
			SumRunnable sumThr = new SumRunnable(sumInstance);
			Thread t = new Thread(sumThr);
			t.start();
		}
		
	}

}
