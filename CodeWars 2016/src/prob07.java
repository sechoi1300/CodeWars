import java.io.*;
import java.util.*;

public class prob07 {
	
	final static String probNum="00";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		int loop = Integer.parseInt(in.nextLine());
		for(int i = 0; i < loop; i++) {
			String word1 = in.next();
			String word2 = in.next();
			String word3 = in.next();
			char[] c1 = word1.toCharArray();
			char[] c2 = word2.toCharArray();
			char[] c3 = word3.toCharArray();
			String result = "";
			for(int j = 0; j < c1.length; j++) {
				for(int k = 0; k < c2.length; k++) {
					for(int m = 0; m < c3.length; m++) {
						if(c1[j] == c2[k] && c1[j] == c3[m] && c2[k] == c3[m]) result+= c1[j];
					}
				}
			}
			char[] cresult = result.toCharArray();
			for(int j = 0; j < cresult.length-1; j++) {
				if(cresult[j] == cresult[j+1]) cresult[j] = '-';
			}
			result = "";
			for(int j = 0; j < cresult.length; j++) {
				if(cresult[j] != '-') result += cresult[j];
			}
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
