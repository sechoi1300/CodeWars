import java.io.*;
import java.util.*;

public class prob11 {
	
	final static String probNum="00";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		int n = in.nextInt();
		int loop = in.nextInt();
		in.nextLine();
		String[] sky = new String[loop];
		for(int i = 0; i < loop; i++) {
			int j = in.nextInt();
			sky[j] = in.nextLine();
		}
		for(int i = loop; i > 0; i--) {
			System.out.println(sky[i]);
		}
		int index = 0;
		for(int i = 0; i < n; i++) {
			System.out.print(index);
			index++;
			if(index == 10) index = 0;
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
