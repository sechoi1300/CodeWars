import java.util.*;
import java.io.*;

public class prob05 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	static String file1 = "prob02 - 1 - in.txt";
	static String file2 = "prob02 - 2 - in.txt";
	static String file3 = "prob02 - 3 - in.txt";
	
	public static void solve() {
		// TODO Auto-generated method stub
		int loop = in.nextInt();
		String[] names = new String[loop];
		double[] time = new double[loop];
		for(int i = 0; i < 3; i++) {
			names[i] = in.next();
			double distance = in.nextDouble();;
			double speed = in.nextDouble();
			time[i] = distance / speed;
		}
		int index = 15;
		double min = 15;
		for(int i = 0; i < loop; i++) {
			if(time[i] < min) {
				index = i;
				min = Math.min(min, time[i]);
			}
		}
		System.out.println(names[index] + " " + time[index]);
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