import java.io.*;
import java.util.*;

public class prob04 {
	
	final static String probNum="";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		int loop = Integer.parseInt(in.nextLine());
		while(loop-->0) {
			int gold = in.nextInt();
			int silver = in.nextInt();
			int bronze = in.nextInt();
			while(true) {
				if(silver >= 10 && silver - 10 >= 1) {
					silver -= 10;
					gold++;
				}
				if(bronze >= 50 && bronze - 50 >= 1) {
					bronze-=50;
					gold++;
				}
				if(bronze <= 50 && silver <= 10) {
					break;
				}
			}
			while(true) {
				if(bronze >= 5 && bronze - 5 >= 1) {
					silver++;
					bronze-=5;
				}
				if(bronze <= 5) {
					break;
				}
			}
			System.out.println(gold + " " + silver + " " + bronze);
		}
	}
	
	public static boolean isPrime(int n) {
		if(!notPrime[0])runSieve();
		return !notPrime[n];
	}
	
	static boolean[] notPrime=new boolean[MAX];
	public static void runSieve() {
		notPrime[0]=true;
		notPrime[1]=true;
		for(int i=2;i<=MAX/2;i++)
			if(!notPrime[i])
				for(int j=i*i;j<MAX;j+=i)
					notPrime[j]=true;
	}

	public static void main(String[] args) throws IOException {
		try {
			in=new Scanner(new FileInputStream("prob"+probNum+".txt"));
		} catch(Exception e) {//file does not exist
			in=new Scanner(System.in);
		}
		solve();
	}

}
