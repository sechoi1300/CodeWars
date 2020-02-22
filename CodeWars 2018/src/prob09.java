import java.io.*;
import java.util.*;

public class prob09 {
	
	final static String probNum="";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		while(true) {
			int n = in.nextInt();
			if(n == 0) break;
			String s = Integer.toBinaryString(n);
			int ones = 0;
			int zeroes = 0;
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '1') ones++;
				else zeroes++;
			}
			if(ones == zeroes) System.out.println(n + " BALANCED");
			else if(ones > zeroes) System.out.println(n + " HEAVY");
			else System.out.println(n + " LIGHT");
		}
	}
	
	public static boolean isPrime(int n) {
		if(!notPrime[0])runSieve();
		return !notPrime[n];
	}
	
	static boolean[] notPrime=new boolean[MAX];
	public static void runSieve() {
		notPrime[0]=true;
		notPrime[1]=true;
		for(int i=2;i<=MAX/2;i++)
			if(!notPrime[i])
				for(int j=i*i;j<MAX;j+=i)
					notPrime[j]=true;
	}

	public static void main(String[] args) throws IOException {
		try {
			in=new Scanner(new FileInputStream("prob"+probNum+".txt"));
		} catch(Exception e) {//file does not exist
			in=new Scanner(System.in);
		}
		solve();
	}

}
