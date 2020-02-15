import java.util.*;
import java.io.*;

public class prob03 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	
	public static void solve() {
		// TODO Auto-generated method stub
		int n = in.nextInt();
		System.out.println(3.14159 * n * n * 3 / 4);
	}
	
	
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		solve();
	}

}