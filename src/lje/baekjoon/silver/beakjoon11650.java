package lje.baekjoon.silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class beakjoon11650{
	static int arr[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		arr = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
	Arrays.sort(arr, (arr_1, arr_2) -> {
		if(arr_1[0] == arr_2[0]) {
			return arr_1[1]-arr_2[1];
		}else {
			return arr_1[0] - arr_2[0];
		}
	});

	for(int i=0;i<N;i++) {
		System.out.println(arr[i][0] + " " + arr[i][1]);
	}
	
	}
	

}
