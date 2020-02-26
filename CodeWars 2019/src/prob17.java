import java.io.*;
import java.util.*;

public class prob17 {
	
	final static String probNum="00";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		String str = in.nextLine();
		char[] c = str.toCharArray();
		Arrays.sort(c);
		ArrayList<String> letters = new ArrayList<String>();
		int num = 1;
		ArrayList<String> end = new ArrayList<String>();
		for(int i = c.length - 1; i > 1; i--) {
			if(c[i] == c[i - 1]) num++;
			else {
				if(num >= 10) end.add(c[i] + "[" + num + "]");
				else {
					if(c[i] == ' ') letters.add("_[" + num + "]");
					else letters.add(c[i] + "[" + num + "]");
				}
				num = 1;
			}
		}
		String result = "";
		for(int i = 0; i < letters.size(); i++) {
			result+=letters.get(i);
		}
		result+=";";
		for(int i = end.size() - 1; i >= 0; i--) {
			result+=end.get(i);
		}
		System.out.println(result);
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
