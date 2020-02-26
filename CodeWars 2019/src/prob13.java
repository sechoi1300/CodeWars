import java.io.*;
import java.util.*;

public class prob13 {
	
	final static String probNum="00";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		String num1str = in.nextLine();
		String num2str = in.nextLine();
		String num3str = in.nextLine();
		String num4str = in.nextLine();
		if(num1str.equals("X")) {
			double num2 = Double.parseDouble(num2str);
			double num3 = Double.parseDouble(num3str);
			double num4 = Double.parseDouble(num4str);
			System.out.println(num3 / num4 * num2);
		}
		else if(num2str.equals("X")) {
			double num1 = Double.parseDouble(num1str);
			double num3 = Double.parseDouble(num3str);
			double num4 = Double.parseDouble(num4str);
			System.out.println(num4 / num3 * num1);
		}
		else if(num3str.equals("X")) {
			double num1 = Double.parseDouble(num1str);
			double num2 = Double.parseDouble(num2str);
			double num4 = Double.parseDouble(num4str);
			System.out.println(num1 / num2 * num4);
		}
		else {
			double num1 = Double.parseDouble(num1str);
			double num2 = Double.parseDouble(num2str);
			double num3 = Double.parseDouble(num3str);
			System.out.println(num2 / num1 * num3);
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
