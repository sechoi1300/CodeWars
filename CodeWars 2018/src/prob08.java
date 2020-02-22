import java.io.*;
import java.util.*;

public class prob08 {
	
	final static String probNum="";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		while(true) {
			int num1 = in.nextInt();
			int num2 = in.nextInt();
			if(num1 == 0 && num2 == 0) break;
			String result = num1+"";
			int lastnum = num1;
			while(true) {
				lastnum++;
				if(result.length() + Integer.toString(lastnum).length() > num2) {
					lastnum--;
					break;
				}
				else result += lastnum;
			}
			if(Integer.toString(num1).length() > num2) System.out.println(num1 + " " + num2 + " 0");
			else System.out.println(num1 + " " + num2 + " " + lastnum);
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
