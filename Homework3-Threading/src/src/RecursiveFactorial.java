package src;

import java.util.Scanner;

public class RecursiveFactorial {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("What number do you want to find the factorial of?");
		int i = input.nextInt();
		RecursiveFactorial rf = new RecursiveFactorial();
		int total = rf.factorial(i);
		System.out.println("Factorial of " + i + " is " + total);
		input.close();
		

	}

	
	public int factorial(int i) 
	{
		int subtotal = 0;
		if (i <= 1)
		{
			subtotal = 1;
		}
		else if (i > 1)
		{
			subtotal = i * factorial(i-1);
		}
		return subtotal;
		
		
	}
	
	
	
	
}
