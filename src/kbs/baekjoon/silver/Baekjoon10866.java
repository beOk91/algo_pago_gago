package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon10866 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<N;i++) {
			String []temp=br.readLine().split(" "); 
			if("push_front".equals(temp[0])) {
				list.add(0, Integer.parseInt(temp[1]));
			}else if("push_back".equals(temp[0])){
				list.add(Integer.parseInt(temp[1]));
			}else if("size".equals(temp[0])) {
				System.out.println(list.size());
			}else if("empty".equals(temp[0])) {
				System.out.println(list.isEmpty() ? 1:0);
			}else if(list.isEmpty()) {
				System.out.println(-1);
			}else if("pop_front".equals(temp[0])){
				System.out.println(list.remove(0));
			}else if("pop_back".equals(temp[0])) {
				System.out.println(list.remove(list.size()-1));
			}else if("front".equals(temp[0])) {
				System.out.println(list.get(0));
			}else if("back".equals(temp[0])) {
				System.out.println(list.get(list.size()-1));
			}
		}
	}

}
