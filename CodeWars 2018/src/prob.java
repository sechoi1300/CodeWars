import java.io.*;
import java.util.*;

public class prob {
	
	final static String probNum="";
	final static int MAX=100000000;
	static Scanner sc;
	
	public static void solve() throws IOException {//ans to STDOUT
		
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
