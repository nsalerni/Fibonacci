import java.io.*;
import java.util.*;

/**
	Calculate the nth number in the Fibonacci sequence in O(n) time.
	Note: The following algorithm works for Fibonacci values of 64-bit size.
	
	Author: Nick Salerni
*/
public class Fib{
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the index n of the fibonacci number: ");
		int n = scan.nextInt();
		
		if (n <= 1)
		{
			System.out.println(n);
			System.exit(0);
		}
		
		long first = 0; long second = 1; long current = 1;
		
		for (int i = 2; i <= n; i++)
		{
			current = first + second;
			first = second;
			second = current;
		}
		
		System.out.println("The " + n + "th number of the Fibonacci sequence is: " + current);
	}
}