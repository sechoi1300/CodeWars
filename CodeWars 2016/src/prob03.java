import java.io.*;
import java.util.*;

public class prob03 {
	
	final static String probNum="00";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		int loop = Integer.parseInt(in.nextLine());
		for(int i = 0; i < loop; i++) {
			String word = in.nextLine();
			char[] c = word.toCharArray();
			boolean same = false;
			for(int j = 0; j < c.length - 1; j++) {
				if(c[j] == c[j+1]) same = true;
			}
			if(same) System.out.println("likes " + word);
			else System.out.println("hates " + word);
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
