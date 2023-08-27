import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		long size = max-min + 1;
		
		boolean[] visited = new boolean[(int)size];
		long i = 2;
		while (i * i <= max) {
			long value = i * i;
			int remain = 0;
			if (min % value != 0) {
				remain = 1;
			}
			
			long data = (min / value) + remain;
			while (value * data <= max) {
				if (!visited[(int)(value * data - min)]) {
					visited[(int)(value * data - min)] = true;
					size -= 1;
				}
				data += 1;
			}
			
			i += 1;
		}
		
		System.out.println(size);
	}
}