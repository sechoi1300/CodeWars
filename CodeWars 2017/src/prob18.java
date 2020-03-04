import java.util.*;
import java.io.*;

public class prob18 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	
	public static void solve() {
		// TODO Auto-generated method stub
		int loop = Integer.parseInt(in.nextLine());
		String[] ponyMon = new String[loop];
		String[] type = new String[loop];
		String[] weakness = new String[loop];
		String[] resistance = new String[loop];
		int[] hp = new int[loop];
		int[] attack1lvl = new int[loop];
		int[] attack1dmg = new int[loop];
		int[] attack2lvl = new int[loop];
		int[] attack2dmg = new int[loop];
		for(int i = 0; i < loop; i++) {
			ponyMon[i] = in.next();
			type[i] = in.next();
			weakness[i] = in.next();
			resistance[i] = in.next();
			hp[i] = in.nextInt();
			in.next();
			attack1lvl[i] = in.nextInt();
			attack1dmg[i] = in.nextInt();
			in.next();
			attack2lvl[i] = in.nextInt();
			attack2dmg[i] = in.nextInt();
		}
		int loop2 = in.nextInt();
		for(int i = 0; i < loop2; i++) {
			String match1 = in.next();
			String match2 = in.next();
			int index1 = loop + 1;
			int index2 = loop + 1;
			for(int j = 0; j < loop; j++) {
				if(ponyMon[j].equals(match1)) index1 = j;
				if(ponyMon[j].equals(match2)) index2 = j;
			}
			int round = 1;
			int hp1 = hp[index1];
			int hp2 = hp[index2];
			boolean resist1 = false;
			boolean resist2 = false;
			boolean weak1 = false;
			boolean weak2 = false;
			if(type[index2].equals(resistance[index1])) resist1 = true;
			if(type[index1].equals(resistance[index2])) resist2 = true;
			if(type[index2].equals(weakness[index1])) weak1 = true;
			if(type[index1].equals(weakness[index2])) weak2 = true;
			while(true) {
				if(round >= attack2lvl[index1]) {
					if(resist2) hp2 -= (attack2dmg[index1] / 2);
					else if(weak2) hp2 -= (attack2dmg[index1] * 2);
					else hp2 -= attack2dmg[index1];
					if(hp2 <= 0) break;
				}
				else if(round >= attack1lvl[index1]) {
					if(resist2) hp2 -= (attack1dmg[index1] / 2);
					else if(weak2) hp2 -= (attack1dmg[index1] * 2);
					else hp2 -= attack1dmg[index1];
					if(hp2 <= 0) break;
				}
				else hp2 = hp2;
				if(round >= attack2lvl[index2]) {
					if(resist1) hp1 -= (attack2dmg[index2] / 2);
					else if(weak1) hp1 -= (attack2dmg[index2] * 2);
					else hp1 -= attack2dmg[index2];
					if(hp1 <= 0) break;
				}
				else if(round >= attack1lvl[index2]) {
					if(resist1) hp1 -= (attack1dmg[index2] / 2);
					else if(weak1) hp1 -= (attack1dmg[index2] * 2);
					else hp1 -= attack1dmg[index2];
					if(hp1 <= 0) break;
				}
				else hp1 = hp1;
				round++;
			}
			if(hp1 > hp2) System.out.println(ponyMon[index1] + " defeats " + ponyMon[index2] + " with " + hp1 + " HP remaining.");
			else System.out.println(ponyMon[index2] + " defeats " + ponyMon[index1] + " with " + hp2 + " HP remaining.");
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