import java.util.Scanner;
 

// 직각 삼각형 구하는 공식 a^2 = b^2 + c^2

public class Main {
	public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in);
       
        
        while(true) {
        	
        	int x = in.nextInt();
        	int y = in.nextInt();
        	int z = in.nextInt();
        	
			// 0 0 0 을 입력받으면 종료
        	if(x == 0 && y == 0 && z == 0) break;
            
        	
        	if((x * x + y * y) == z * z) {
				System.out.println("right");
			}
        	else if(x * x == (y * y + z * z)) {
				System.out.println("right");
			}
        	else if(y * y == (z * z + x * x)) {
				System.out.println("right");
			}
        	else {
				System.out.println("wrong");
			}
        	
		}
 
	}
 
}