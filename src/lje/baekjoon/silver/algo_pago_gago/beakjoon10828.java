package algo_pago_gago;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class stack {
	int top;
	int[] stack;
	int size;

	public stack(int size) {
		top = -1;
		stack = new int[size + 1];
		this.size= size;
	}

	public void push(int value) {

		if (top >= size - 1) {
			System.out.println("-1");
		} else {
			stack[++top] = value;
		}

	}

	public void pop() {
		if (top < 0) {
			System.out.println("-1");
		} else {
			System.out.println(stack[top]);
			stack[top] = 0;
			top--;

		}
	}

	public String top() {
		if (top < 0) {
			return "-1";
		} else
			return String.valueOf(stack[top]);
	}

	public void size() {
		System.out.println(top+1);
	}

	public void empty() {
		if (top < 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}

public class beakjoon10828 {

	public static BufferedReader bf;
	public static StringTokenizer st;

	public static void main(String args[]) throws IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		stack s = new stack(100000);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			String tmp = st.nextToken();

			if (tmp.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				s.push(num);
			} else if (tmp.equals("pop")) {
				s.pop();
			} else if (tmp.equals("top")) {
				System.out.println(s.top());
			} else if (tmp.equals("size")) {
				s.size();
			} else if (tmp.equals("empty")) {
				s.empty();
			}

		}
	}

}
