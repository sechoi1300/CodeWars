import java.io.*;
import java.util.*;

public class prob12 {
	
	final static String probNum="00";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		int loop = Integer.parseInt(in.nextLine());
		int index = Integer.parseInt(in.nextLine());
		int sign = 1;
		double pi = 3;
		for(double i = 2; i <= (loop * 2); i+=2) {
			if(sign == 1) pi += (4.0 / (i * (i + 1) * (i + 2)));
			else pi -= (4.0 / (i * (i + 1) * (i + 2)));
			sign *= -1;
		}
		String result = pi+"";
		System.out.println(result.charAt(index+1));
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
