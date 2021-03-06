import java.util.*;
import java.io.*;

public class prob05 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	
	public static void solve() {
		// TODO Auto-generated method stub
		int n = in.nextInt();
		int cubes = 0;
		for(int i = 1; i <= n; i++) {
			cubes += i * i;
		}
		System.out.println(cubes);
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
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		solve();
	}

}