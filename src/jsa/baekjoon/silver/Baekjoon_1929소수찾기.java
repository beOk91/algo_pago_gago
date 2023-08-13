import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		boolean arr[] = new boolean[end+1];
		arr[1] = true;
		
		for(int i=2; i<=end; i++) {
			for(int j=2; i*j<=end; j++){
				arr[i*j] = true;
			}
		}
		for(int i=start; i<=end; i++) {
			if( !arr[i]) {
				bw.write(String.valueOf(i)+"\n");
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}