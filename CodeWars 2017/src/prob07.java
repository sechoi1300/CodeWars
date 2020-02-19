import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class prob07 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	
	public static void solve() {
		// TODO Auto-generated method stub
		int loop = in.nextInt();
		for(int i = 0; i < loop; i++) {
			double x1 = in.nextDouble();
			double A = in.nextDouble();
			double B = in.nextDouble();
			double C = in.nextDouble();
			double M = in.nextDouble();
			double N = in.nextDouble();
			double e = in.nextDouble();
			double x2 = 0;
			int index = 0;
			while(true) {
				x2 = C + ( A * x1 + M ) / ( B * x1 + N);
				if(Math.abs(x2 - x1) < e) {
					DecimalFormat d = new DecimalFormat("0.000000");
					System.out.println(d.format(x2));
					break;
				}
				if(index == 100) {
					System.out.println("DIVERGES");
					break;
				}
				index++;
				x1 = x2;
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