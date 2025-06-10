import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
	
public class Main{
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader inputStr = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(inputStr.readLine());
		String[] numList = inputStr.readLine().split(" ");
		float[] cardList = new float[n];
		Float tmp;
		StringBuilder out = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			cardList[i] = Float.parseFloat(numList[i]);
		}
		
		Arrays.sort(cardList);
		
		int m = Integer.parseInt(inputStr.readLine());
		
		numList = inputStr.readLine().split(" ");
		
		for(int i = 0; i < m; i++) {
			tmp = Float.parseFloat(numList[i]);
			
			out.append((upper(cardList, tmp) - lowwer(cardList, tmp))).append(' ');
		}
		
		System.out.println(out);
	}
	
	public static int lowwer(float[] arr, float a) {
		int start = 0;
		int end = arr.length;
		int mid;
		
		while(start < end) {
			
			mid = (start+end)/2;
			
			if(a <= arr[mid]) {
				end = mid;
			}else {
				start = mid + 1;
			}
			
		}
		
		return start;
	}
	
	public static int upper(float[] arr, float a) {
		
		int start = 0;
		int end = arr.length;
		int mid;
		
		while(start < end) {
			
			mid = (start+end)/2;
			
			if(a < arr[mid]) {
				end = mid;
			}else {
				start = mid + 1;
			}
			
		}
		
		return start;
	}
}