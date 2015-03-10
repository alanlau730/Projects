import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Sieve {//n will be always 10 million for the sake of my sanity.
	private ArrayList<Long> primeList;
	private long[]numArray;
	private STATUS[]booleanArray;
	private long n;
	
	public enum STATUS{
		UNKNOWN,COMPOSITE,PRIME;
	}
	
	public Sieve(long n){
		this.n = n;
		numArray = new long[(int)n];//dangerous casting
		booleanArray = new STATUS[(int)n];
		

		for(int i=2;i<n;++i){//initialize array
			numArray[i-2] = i;
			booleanArray[i-2] = STATUS.UNKNOWN;
		}
	}
	
	private void computePrimes(){
		long currentIndex = 0;
		long currentPrime = 2;
		primeList = new ArrayList<Long>();//start with 2 in the arraylist
		primeList.add(currentPrime);
		
	  while (currentPrime <= n){//until we reach the end 
		for(long i = currentPrime;i<n;i+=currentPrime){//eliminate composite numbers
			if(booleanArray[(int) (i-2)] == STATUS.UNKNOWN){
				booleanArray[(int)(i-2)] = STATUS.COMPOSITE;
			}				
		
		}
		while(booleanArray[(int) (currentPrime-2)]!=STATUS.UNKNOWN)
			++currentPrime;//stop when we find the next Currentprime
	  }
		
	}
	
	public void printPrimes(){
		computePrimes();
		for(long prime:primeList){
			System.out.print(prime + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);
		System.out.println("We will calculate all the prime numbers up to : ");
		long limit = scan.nextLong();
		Sieve s = new Sieve(limit);
		s.printPrimes();
		scan.close();
		
	}

}
