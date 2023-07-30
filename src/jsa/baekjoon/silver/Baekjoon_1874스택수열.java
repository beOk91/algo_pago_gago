import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringBuilder sb = new StringBuilder();
		int index = 0;
		int num = 1;
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(index < n) {
			if(!stack.empty() && arr[index] < stack.get(stack.size() - 1)) {
				break;
			}else if(!stack.empty() && arr[index] == stack.get(stack.size() - 1)) {
				stack.pop();
				sb.append("-").append("\n");
				index++;
			}else {
				while(num <= n) {
					if(arr[index] != num) {
						stack.push(num);
						sb.append("+").append("\n");
						num++;
					}else {
						stack.push(num);
						sb.append("+").append("\n");
						num++;
						break;
					}
				}
			}
		}
		
		if(index == n) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
	}

}