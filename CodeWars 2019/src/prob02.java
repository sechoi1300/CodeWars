import java.util.*;
import java.io.*;

public class prob02 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	
	public static void solve() {
		// TODO Auto-generated method stub
		int hr = in.nextInt();
		int mi = in.nextInt();
		int speed = in.nextInt();
		System.out.println(hr + " " + mi + " " + speed+(hr * speed >= mi?". I will make it!":". I will be late!"));
	}
	
	
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		solve();
	}

}
