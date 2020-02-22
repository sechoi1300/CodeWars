import java.io.*;
import java.util.*;

public class prob10 {
	
	final static String probNum="";
	final static int MAX=100000000;
	static Scanner in;
	
	public static void solve() throws IOException {//ans to STDOUT
		//int loop = Integer.parseInt(in.nextLine());
		int loop = in.nextInt();
		for(int i = 0; i < loop; i++) {
			int count = 1;
			int paint = 0;
			int top = in.nextInt();
			int row = in.nextInt();
			if(top == 1) paint+=5;
			else {
				paint+=(Math.sqrt(top) * 4) + top;
			}
			top = (int) Math.sqrt(top);
			for(int j = count; count < row; count++ ) {
				top++;
				paint+=(top * 4);
				paint+=((top * top) - ((top - 1) * (top - 1)));
			}
			System.out.println(paint + " liters");
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
