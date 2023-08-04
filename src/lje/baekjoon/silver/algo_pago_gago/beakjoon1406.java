package algo_pago_gago;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class beakjoon1406 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String N = bf.readLine();
		Stack stackL = new Stack<>();
		Stack stackR = new Stack<>();
		for (int i=0;i<N.length();i++) {
			stackL.push(N.charAt(i));
		}
		int M = Integer.parseInt(bf.readLine());
		
		String order;
		for(int i=0; i< M; i++) {
			
			order = bf.readLine();
			if(order.equals("L")) {
				if(!stackL.empty()) {
					stackR.push(stackL.pop());
				}
				
			}else if(order.equals("D")) {
				if(!stackR.empty()) {
					stackL.push(stackR.pop());
				}
				
			}else if(order.equals("B")) {
				if(!stackL.empty()) {
					stackL.pop();
				}
				
			}else {
				stackL.push(order.charAt(2));
			}
			
		}
		while(!stackL.empty()) {
			stackR.push(stackL.pop());
		}
		StringBuilder answer = new StringBuilder();
		while (!stackR.empty()) {
			answer.append(stackR.pop());
		}
		System.out.println(answer);

		
	}

}
