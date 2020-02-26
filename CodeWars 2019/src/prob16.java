import java.io.*;
import java.util.*;

public class prob16 {
	
	final static String probNum="00";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		String[] str = in.nextLine().split(" ");
		ArrayList<String> words = new ArrayList<String>();
		for(int i = 0; i < str.length; i++) {
			words.add(str[i]);
		}
		int index = 0;
		for(int i = 0; i < words.size() - 2; i++) {
			String word1 = words.get(index).toLowerCase();
			String word2 = words.get(index+1).toLowerCase();
			String word3 = words.get(index+2).toLowerCase();
			if(word1.equals(word2)) {
				if((word1.equals("is") && word2.equals("is") && word3.equals("is")) || (word1.equals("had") && word2.equals("had") && word3.equals("had"))) {
					words.remove(index+2);
				}
				else if ((word1.equals("is") && word2.equals("is") && !word3.equals("is")) || (word1.equals("had") && word2.equals("had") && !word3.equals("had"))){
					continue;
				} else {
					words.remove(index+1);
				}
			}
			index++;
		}
		String result = "";
		for(int i = 0; i < words.size(); i++) {
			result += " " + words.get(i);
		}
		System.out.println(result.substring(1));
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
