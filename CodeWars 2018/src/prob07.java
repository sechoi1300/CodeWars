import java.io.*;
import java.util.*;

public class prob07 {
	
	final static String probNum="";
	final static int MAX=100000000;
	static Scanner sc;
	
	public static void solve() throws IOException {//ans to STDOUT
		int loop = readInt();
		int[] num = new int[loop];
		String result = "";
		int max = 0;
		while(true) {
			
		}
		//put into array, sort, check last 3 or first 2 and last
		/*
		if(num[0] * num[1] > num[loop - 2] * num[loop - 1]) {
			result+=(num[0] * num[1]) + " ";
			num[0]
		} else if (num[0] * num[1] < num[loop - 2] * num[loop - 1]) {
			result +=(num[loop-2] * num[loop-1]) + " ";
		}
		*/
	}
	
	public static boolean isPrime(int n) {
		if(!notPrime[0])runSieve();
		return !notPrime[n];
	}
	
	static boolean[] notPrime=new boolean[MAX];
	public static void runSieve() {
		notPrime[0]=true;
		notPrime[1]=true;
		double limit=Math.sqrt(MAX);
		for(int i=2;i<=limit;i++)
			if(!notPrime[i])
				for(int j=i*i;j<MAX;j+=i)
					notPrime[j]=true;
	}

	public static void main(String[] args) throws IOException {
		try {
			sc=new Scanner(new FileInputStream("prob"+probNum+".txt"));
		} catch(Exception e) {//file does not exist
			sc=new Scanner(System.in);
		}
		solve();
	}
	
	static int readInt() {
		return sc.nextInt();
	}
	
	static double readDouble() {
		return sc.nextDouble();
	}
	
	static String readWord() {
		return sc.next();
	}
	
	static String readLine() {
		return sc.nextLine();
	}

}
