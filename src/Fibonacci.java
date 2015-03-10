import java.util.Arrays;
import java.util.Scanner;

//simple fibonacci number program with dynamic programming
//will add timing shortly comparing dynamic vs non-dynamic

//as the value of n increases the dynamic program becomes noticeably faster

public class Fibonacci {
	private long []array;
	private int n;
	
	
	
	public Fibonacci(int n){
		array = new long[n];
		Arrays.fill(array, -1); //initialize to -1...meaning element does not yet exist
		this.n = n;
		
	}
	
	public long compute(boolean dynamic){
		long start = System.currentTimeMillis();
		//System.out.println("Start time: " + System.currentTimeMillis());
		long result = Helper(n,dynamic);
		if (dynamic)
			System.out.println("Total dynamic time: " + (System.currentTimeMillis()-start) + "ms");
		else
			System.out.println("Total normal time: " + (System.currentTimeMillis()-start)+"ms");
		return result;
	}
	
	private long Helper(int n,boolean dynamic){//will clean up code
	  if (n == 1 || n == 2)	
		  return 1;
	  
	  else{
			  if(dynamic){
				  long helpOne = 0;
				  long helpTwo = 0;
				  
				 if(array[n-2] == -1){//see if value is already cached or not
					 helpOne = Helper(n-1,dynamic);
					 array[n-2] = helpOne;
			  	 }
				 else
					 helpOne = array[n-2];
				 
				 System.out.println(helpOne + " HELP ONE ");
				  
				  if(array[n-3]==-1){
					  helpTwo = Helper(n-2,dynamic);					  
					  array[n-3] = helpTwo;
				  }
				  
				  else
					  helpTwo = array[n-3];
				  
				  System.out.println(helpTwo + " HELP two ");
				 				  
				  return helpOne+helpTwo;
			  }
		  else
			  return Helper(n-1,dynamic) + Helper(n-2,dynamic);//without caching
	  	}
	  		
	}
	
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the nth number of the Fibonacci sequence: ");
		int n = scan.nextInt();
		Fibonacci fb = new Fibonacci(n);
		System.out.println(n + "th number.Dynamic is: " + fb.compute(true) + " Normal is: " + fb.compute(false));		
		scan.close();
		
	}
}
