import java.io.*;
import java.util.*;

/**
	Calculate the nth number in the Fibonacci sequence in O(log n) time.
	Note: The following algorithm works for Fibonacci values of 64-bit size.
	
	Author: Nick Salerni
*/
class FibLogN {
	public static long[] G = new long[] {1, 1, 1, 0};
	
	public static long[] GetFibMatrix(int n)
	{
		if (n == 1)
		{
			return G;
		}
		
		long[] current = GetFibMatrix(n/2);
		current= MatrixMult(current, current);
		
		if (n % 2 == 1)
		{
			current = MatrixMult(current, G);
		}
		
		return current;
	}
	
	public static long[] MatrixMult(long[] a, long[] b) 
	{
		if (a.length != 4 || b.length != 4)
		{
			System.out.println("\nInvalid Matrix Size.\n");
			System.exit(1);
		}
		
		long[] result = new long[4];
		result[0] = a[0] * b[0] + a[1] * b[2];
		result[1] = a[0] * b[1] + a[1] * b[3];
		result[2] = a[2] * b[0] + a[3] * b[2];
		result[3] = a[2] * b[1] + a[3] * b[3];
		return result;
	}
	
	public static long LogNSeqCalc(int n)
	{
		if (n <= 1)
		{
			return n;
		}
		return GetFibMatrix(n)[1];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the index n of the Fibonacci number: ");
		int n = scan.nextInt();
		
		System.out.println("The " + n + "th number of the Fibonacci sequence is: " + LogNSeqCalc(n));
	}
}