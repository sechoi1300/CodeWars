import java.util.*;
import java.io.*;

public class prob07 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	
	public static void solve() {
		// TODO Auto-generated method stub
		while(true) {
			int num1 = in.nextInt();
			int num2 = in.nextInt();
			if(num1 == 0 && num2 == 0) break;
			else if(num2 == 0) {
				if(num1 % 2 == 0) System.out.println(num1 + 2);
				else System.out.println(num1 + 1);
			}
			else if(num2 == 1) {
				while(!isPrime(num1)) {
					num1++;
				}
			}
			else if(num2 == 2) {
				System.out.println((int)Math.pow(((int)Math.sqrt(num1) + 1), 2));
			} else {
				System.out.println((int)Math.pow(((int)Math.cbrt(num1) + 1), 3));
			}
		}
	}
	
	static String printDecimals(double value, int digits, boolean round) {
		for(int i = 0; i < digits; i++) {
			value *= 10;
		}
		int point = (int) ((value * 10) % 10);
		int val = (int) value;
		if(round && point > 4) {
			val++;
		}
		String ret = val + "";
		if(ret.length() == digits) {
			return "0." + ret;
		}
		return ret.substring(0, ret.length() - digits) + "." + ret.substring(ret.length() - digits);
 	}
	
	public static boolean isPrime(int n) {
		if(!notPrime[0])runSieve();
		return !notPrime[n];
	}
	
	static boolean[] notPrime = new boolean[MAX];
	
	public static void runSieve() {
		notPrime[0] = true;
		notPrime[1] = true;
		for(int i = 2; i <= MAX / 2; i++)	{
			if(!notPrime[i]) {
				for(int j = i * 2; j < MAX; j += i) {
					notPrime[j] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		solve();
	}

}
