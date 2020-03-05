import java.util.*;
import java.io.*;

public class prob16 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	
	public static void solve() {
		// TODO Auto-generated method stub
		int cubeNum = Integer.parseInt(in.nextLine());
		String[] cubes = new String[cubeNum];
		for(int i = 0; i < cubeNum; i++) {
			cubes[i] = in.nextLine();
		}
		for(int i = 0; i < cubeNum; i++) {
			String temp = cubes[i];
			cubes[i] = "";
			for(int j = 0; j < temp.length(); j++) {
				if(Character.isLetter(temp.charAt(j))) cubes[i] += temp.charAt(j);
			}
		}
		char[][] letters = new char[cubeNum][6];
		for(int i = 0; i < cubeNum; i++) {
			letters[i] = cubes[i].toCharArray();
		}
		int wordsNum = in.nextInt();
		for(int i = 0; i < wordsNum; i++) {
			String temp = in.next();
			if(temp.length() > cubeNum) System.out.println(temp + " CANNOT be formed");
			else check(temp, cubeNum, letters);
		}
	}
	
	static void check(String temp, int cubeNum, char[][] letters) {
		char[][] tempc = new char[cubeNum][6];
		for(int i = 0; i < cubeNum; i++) {
			for(int j = 0; j < 6; j++) {
				tempc[i][j] = letters[i][j];
			}
		}
		boolean contains = false;
		for(int i = 0; i < temp.length(); i++) {
			for(int j = 0; j < cubeNum; j++) {
				for(int k = 0; k < 6; k++) {
					if(temp.charAt(i) == tempc[j][k]) {
						for(int m = 0; m < 6; m++) {
							tempc[j][m] = '-';
						}
						contains = true;
					}
				}
				if(contains) {
					contains = false;
					break;
				}
			}
		}
		boolean all = true;
		int lines = 0;
		//see if number of '-' lines is equal to temp length
		for(int i = 0; i < cubeNum; i++) {
			for(int j = 0; j < 6; j++) {
				if(tempc[i][j] != '-') all = false;
			}
			if(all) lines++;
			all = true;
		}
		if(lines == temp.length()) System.out.println(temp + " can be formed");
		else System.out.println(temp + " CANNOT be formed");
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