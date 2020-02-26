import java.io.*;
import java.util.*;

public class prob18 {
	
	final static String probNum="00";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		int options = Integer.parseInt(in.nextLine());
		String result = "Your MASH Story:" + "\n";
		String category = in.next();
		in.nextLine();
		ArrayList<String> c1 = new ArrayList<String>();
		for(int j = 0; j < options; j++) {
			c1.add(in.nextLine());
		}
		in.nextLine();
		String[] c2 = new String[options];
		for(int j = 0; j < options; j++) {
			c2[j] = in.nextLine();
		}
		in.nextLine();
		String[] c3 = new String[options];
		for(int j = 0; j < options; j++) {
			c3[j] = in.nextLine();
		}
		in.nextLine();
		String[] c4 = new String[options];
		for(int j = 0; j < options; j++) {
			c4[j] = in.nextLine();
		}
		in.nextLine();
		int magicnum = Integer.parseInt(in.nextLine());
		int index = 0;
		while(true) {
			if(c1.length == 1) break;
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
