import java.io.*;
import java.util.*;

public class prob14 {
	
	final static String probNum="00";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		int f0 = Integer.parseInt(in.nextLine());
		int f1 = Integer.parseInt(in.nextLine());
		int fn = Integer.parseInt(in.nextLine());
		int num = 0;
		String result = f0 + "," + f1 + ",";
		for(int i = 0; i < fn - 2; i++) {
			num = f0 + f1;
			f0 = f1;
			f1 = num;
			result+=num + ",";
		}
		System.out.println(result.substring(0, result.length() - 1));
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
