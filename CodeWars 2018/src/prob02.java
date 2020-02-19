import java.io.*;
import java.util.*;

public class prob02 {
	
	final static String probNum="00";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		while(true) {
			double v = in.nextDouble();
			double a = in.nextDouble();
			double t = in.nextDouble();
			if(v == 0 && a == 0 && t == 0) break;
			//DecimalFormat df = 
			System.out.println(v * t + (0.5 * a * (t * t)));
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
