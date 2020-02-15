import java.util.*;
import java.io.*;

public class prob08 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	static int[] c = new int[26];
	
	public static void solve() {
		// TODO Auto-generated method stub
		String num = "";
		String result = "";
		while(true) {
			int n = in.nextInt();
			if(n == 999) break;
			num += " " + n;
			switch(n) {
			case 0:replaceMax(count("ZERO"));break;
			case 1:replaceMax(count("ONE"));break;
			case 2:replaceMax(count("TWO"));break;
			case 3:replaceMax(count("THREE"));break;
			case 4:replaceMax(count("FOUR"));break;
			case 5:replaceMax(count("FIVE"));break;
			case 6:replaceMax(count("SIX"));break;
			case 7:replaceMax(count("SEVEN"));break;
			case 8:replaceMax(count("EIGHT"));break;
			case 9:replaceMax(count("NINE"));break;
			case 10:replaceMax(count("TEN"));break;
			case 11:replaceMax(count("ELEVEN"));break;
			case 12:replaceMax(count("TWELVE"));break;
			}
		}
		System.out.print(num.substring(1) + ".");
		for(int i = 0; i < 26; i++) {
			while(c[i]-->0) {
				System.out.print(" " + (char)(i + 65));
			}
		}
		System.out.println();
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
	
	public static int[] count(String one) {
		int[] cnt=new int[26];
		for(char c : one.toCharArray()) {
			cnt[((int)(c - 'A'))]++;
		}
		return cnt;
	}
	
	public static void replaceMax(int[]cnt) {
		for(int i = 0; i < 26; i++) {
			if(cnt[i] > c[i]) {
				c[i] = cnt[i];
			}
		}
	}
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		solve();
	}

}
