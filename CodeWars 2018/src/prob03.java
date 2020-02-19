import java.io.*;
import java.util.*;

public class prob03 {
	
	final static String probNum="00";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		while(true) {
			String num = in.next();
			if(num.equals("0")) break;
			int index = 1;
			while(true) {
				if(!isPrime(Integer.parseInt(num.substring(0, index)) + Integer.parseInt(num.substring(index)))) {
					System.out.println(num + " PETTY");
					break;
				}
				if(index == num.length() - 1) {
					System.out.println(num + " MAGNANIMOUS");
					break;
				}
				index++;
			}
			index = 0;
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
		for(int i=2;i<=Math.sqrt(MAX);i++)
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
