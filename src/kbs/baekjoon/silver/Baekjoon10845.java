package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<N;i++) {
			String input[]=br.readLine().split(" ");
			if("push".equals(input[0])) {
				list.add(Integer.parseInt(input[1]));
			}else if("pop".equals(input[0])) {
				System.out.println(list.size()==0? -1:list.remove(0));
			}else if("size".equals(input[0])) {
				System.out.println(list.size());
			}else if("empty".equals(input[0])) {
				System.out.println(list.size()==0 ? 1:0);
			}else if("front".equals(input[0])) {
				System.out.println(list.size()==0 ? -1 :list.get(0));
			}else {
				System.out.println(list.size()==0 ? -1 :list.get(list.size()-1));
			}
		}
	}
	
}
