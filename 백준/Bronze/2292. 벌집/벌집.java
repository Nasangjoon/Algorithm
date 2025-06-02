import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int room = 1;
        int findroom = 1;
        while(true){
            if(findroom >= n){ 
                break;
            }
            findroom += (room*6); 
            room++;
        }

        System.out.println(room);

    }
}