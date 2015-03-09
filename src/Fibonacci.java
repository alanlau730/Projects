import java.util.Arrays;
import java.util.Scanner;

//simple fibonacci number program with dynamic programming
//will add timing shortly comparing dynamic vs non-dynamic

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
	  if (n == 1 || n == 2)
		  //array[n-1] = 1; //caching
		  return 1;
	  
	  else{
		  long helpOne;
		  long helpTwo;
		  
		  if(array[n-2] != -1)//see if value is already cached or not
			  helpOne = array[n-2];
		  else
			  helpOne = Helper(n-1);
		  
		  if(array[n-3]!=-1)
			  helpTwo = array[n-3];
		  else
			  helpTwo = Helper(n-2);
		  
		  return helpOne+helpTwo;
	  	}
			
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
