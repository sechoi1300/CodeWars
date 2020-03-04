import java.util.*;
import java.io.*;

public class prob17 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	
	public static void solve() {
		// TODO Auto-generated method stub
		ArrayList<String> numerals = new ArrayList<String>();
		while(true) {
			String input = in.nextLine();
			if(input.equals("0")) break;
			input = input.toUpperCase();
			String analyze = "";
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == 'S' || input.charAt(i) == 'I' || input.charAt(i) == 'V' ||input.charAt(i) == 'X' ||input.charAt(i) == 'L' ||input.charAt(i) == 'C' ||input.charAt(i) == 'D' ||input.charAt(i) == 'M') {
					analyze += input.charAt(i);
				}
			}
			System.out.println(analyze);
			for(int i = 0; i < analyze.length() - 3; i++) {
				if(analyze.charAt(i) == 'I') {
					if(analyze.charAt(i + 1) == 'I') {
						if(analyze.charAt(i + 2) == 'I') {
							if(analyze.charAt(i + 3) == 'I') {
								analyze = analyze.substring(i + 3);
							}
						}
					}
				}
				if(analyze.charAt(i) == 'X') {
					if(analyze.charAt(i + 1) == 'X') {
						if(analyze.charAt(i + 2) == 'X') {
							if(analyze.charAt(i + 3) == 'X') {
								analyze = analyze.substring(i + 3);
							}
						}
					}
				}
				if(analyze.charAt(i) == 'C') {
					if(analyze.charAt(i + 1) == 'C') {
						if(analyze.charAt(i + 2) == 'C') {
							if(analyze.charAt(i + 3) == 'C') {
								analyze = analyze.substring(i + 3);
							}
						}
					}
				}
				if(analyze.charAt(i) == 'M') {
					if(analyze.charAt(i + 1) == 'M') {
						if(analyze.charAt(i + 2) == 'M') {
							if(analyze.charAt(i + 3) == 'M') {
								analyze = analyze.substring(i + 3);
							}
						}
					}
				}
			}
			for(int i = 0; i < analyze.length(); i++) {
				if(analyze.charAt(i) == 'D') {
					for(int j = i; j < analyze.length(); j++) {
						if(analyze.charAt(j) == 'D') analyze = analyze.substring(j);
					}
				}
				if(analyze.charAt(i) == 'L') {
					for(int j = i; j < analyze.length(); j++) {
						if(analyze.charAt(j) == 'L') analyze = analyze.substring(j);
					}
				}
				if(analyze.charAt(i) == 'V') {
					for(int j = i; j < analyze.length(); j++) {
						if(analyze.charAt(j) == 'V') analyze = analyze.substring(j);
					}
				}
				if(analyze.charAt(i) == 'S') analyze = analyze.substring(i);
			}
			for(int i = 0; i < analyze.length() - 1; i++) {
				if(analyze.charAt(i) == 'V' && analyze.charAt(i + 1) == 'I') analyze = analyze.substring(i + 1);
				if(analyze.charAt(i) == 'L' && (analyze.charAt(i + 1) == 'C' || analyze.charAt(i + 1) == 'D' || analyze.charAt(i + 1) == 'M')) analyze = analyze.substring(i + 1);
				if(analyze.charAt(i) == 'D' && analyze.charAt(i + 1) == 'M') analyze = analyze.substring(i + 1);
				if(analyze.charAt(i) == 'I' && (analyze.charAt(i + 1) != 'V' || analyze.charAt(i + 1) != 'X')) analyze = analyze.substring(i + 1);
				if(analyze.charAt(i) == 'X' && (analyze.charAt(i + 1) != 'L' || analyze.charAt(i + 1) != 'C')) analyze = analyze.substring(i + 1);
				if(analyze.charAt(i) == 'C' && (analyze.charAt(i + 1) != 'D' || analyze.charAt(i + 1) != 'M')) analyze = analyze.substring(i + 1);
			}
			System.out.println(analyze);
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