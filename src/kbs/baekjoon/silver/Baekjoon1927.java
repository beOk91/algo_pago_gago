package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1927 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int []arr=new int[100001];
		int size=0;
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(size==0) {
					System.out.println(0);
				}else {
					System.out.println(arr[1]);
					arr[1]=arr[size]; arr[size]=0; size--;
					int parent=1;
					int child;
					while(parent*2<=size) {
						child = (parent*2+1<=size && arr[parent*2]>arr[parent*2+1]) ? parent*2+1 :parent*2;
						
						if(child>size || arr[child]>arr[parent]) break;
						
						int temp=arr[parent];
						arr[parent]=arr[child];
						arr[child]=temp;
						parent=child;
					}
				}
			}else {
				arr[++size]=x;
				int tmp=size;
				while(tmp!=1) {
					if(arr[tmp/2]>arr[tmp]) {
						int temp=arr[tmp];
						arr[tmp]=arr[tmp/2];
						arr[tmp/2]=temp;
						tmp/=2;
					}else {
						break;
					}
				}
			}
		}
	}
}
