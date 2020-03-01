import java.io.*;
import java.util.*;

public class prob06 {
	
	final static String probNum="00";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		int loop  = Integer.parseInt(in.nextLine());
		for(int i = 0; i < loop; i++) {
			double t = in.nextDouble();
			double t0 = in.nextDouble();
			double t1 = in.nextDouble();
			double c0 = in.nextDouble();
			c0 = c0 / 8;
			double c1 = in.nextDouble();
			c1 = c1 / 8;
			double m = (t1 - t0) / (c1 - c0);
			double intercept = Math.abs(t0 - m * c0);
			double result = (intercept / m) + (t / m);
			System.out.println(result);
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
