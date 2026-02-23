import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String[] files = new String[n];
        
        for (int i = 0; i < n; i++) {
            files[i] = sc.next();
        }
        
        // 결과 패턴을 저장할 StringBuilder (수정이 빈번하므로 사용)
        StringBuilder pattern = new StringBuilder();
        
        // 파일 이름의 길이는 모두 같으므로 첫 번째 파일의 길이를 기준으로 함
        int len = files[0].length();
        
        for (int i = 0; i < len; i++) {
            char baseChar = files[0].charAt(i); // 비교 기준 문자
            boolean isSame = true;
            
            for (int j = 1; j < n; j++) {
                if (baseChar != files[j].charAt(i)) {
                    isSame = false;
                    break;
                }
            }
            
            if (isSame) {
                pattern.append(baseChar);
            } else {
                pattern.append('?');
            }
        }
        
        System.out.println(pattern.toString());
        sc.close();
    }
}