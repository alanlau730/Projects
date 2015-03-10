import java.util.Arrays;
//program serves similar function as the fibonacci program I wrote earlier.
import java.util.Scanner;

public class Factorial {
	private long []array;
	private int n;
	
	public Factorial(int n){
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
		  if (n < 2)	
			  return 1;
		  
		  else{
				  if(dynamic){
					  long helpOne = 0;
					  
					  
					 if(array[n-2] == -1){//see if value is already cached or not
						 helpOne = Helper(n-1,dynamic);
						 array[n-2] = helpOne;
				  	 }
					 else
						 helpOne = array[n-2];					
					 				  
					  return helpOne*n;
				  }
			  else
				  return Helper(n-1,dynamic)*n;//without caching, eg. fact(5) = 5*fact(4)
		  	}
		  		
		}
		
	
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the nth number of the factorial: ");
		int n = scan.nextInt();
		Factorial fact = new Factorial(n);
		System.out.println(n + "th factorial.Dynamic is: " + fact.compute(true) + " Normal is: " + fact.compute(false));		
		scan.close();
	}
}
