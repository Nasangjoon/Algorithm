import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			boolean tf = true;
			String s = sc.next();
			if (s.equals("0")) break;
			int half = s.length() / 2;
			int end = s.length() - 1;
			for(int i = 0; i < half; i++) {
				if (s.charAt(i) != s.charAt(end)) {
					tf = false;
					break;
				}
				end--;
			}
			System.out.println(tf ? "yes" : "no");
		}
	}
}