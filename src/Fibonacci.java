import java.util.Arrays;
import java.util.Scanner;

//simple fibonacci number program with dynamic programming

public class Fibonacci {
	private long []array;
	private int n;
	private int index;
	
	
	public Fibonacci(int n){
		array = new long[n];
		Arrays.fill(array, -1); //initialize to -1...meaning element does not yet exist
		this.n = n;
		this.index = n;
	}
	
	public long compute(){
		return Helper(n);
	}
	
	private long Helper(int n){//will clean up code
	  
		if (n < 1)
			return 0;		
		if (n == 1) // base case
			return 1;
		else
			return Helper(n-1) + Helper(n-2);
	}
	
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the nth number of the Fibonacci sequence: ");
		int n = scan.nextInt();
		Fibonacci fb = new Fibonacci(n);
		System.out.println("Result is: " + fb.compute());		
		scan.close();
		
	}
}
