import java.util.*;
import java.io.*;

public class prob04 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	
	public static void solve() {
		// TODO Auto-generated method stub
		int n = in.nextInt();
		while(n-->=0) {
			double taxrate = in.nextDouble();
			double amount = in.nextDouble();
			double pretax = amount / (1.0 + (taxrate / 100));
			double tax = pretax * (taxrate / 100);
			
			System.out.println("On your $" + printDecimals(amount, 2, true) + " purchase, the tax amount was $" + printDecimals(tax, 2, true));
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
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		solve();
	}

}
