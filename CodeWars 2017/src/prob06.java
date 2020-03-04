import java.util.*;
import java.io.*;

public class prob06 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	
	public static void solve() {
		// TODO Auto-generated method stub
		int loop = Integer.parseInt(in.nextLine());
		for(int i = 0; i < loop; i++) {
			int n = in.nextInt();
			int[] num = new int[n];
			int[] delta = new int[num.length - 1];
			int index = 0;
			for(int j = 0; j < n; j++) {
				num[j] = in.nextInt();
			}
			for(int j = 0; j < n - 1; j++) {
				delta[j] = -(num[index+1] - num[index]);
				index++;
			}
			index = 0;
			for(int j = 1; j < num.length; j++) {
				num[j] = num[j-1] + delta[index];
				index++;
			}
			System.out.println(Arrays.toString(num));
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