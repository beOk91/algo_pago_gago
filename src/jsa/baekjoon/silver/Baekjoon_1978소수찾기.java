import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int count = 0;
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(str[i]);
			if(isPrime(temp)) count++; 
		}
		System.out.println(count);
	}
	
    public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;            
        }
        return true;
    }
}