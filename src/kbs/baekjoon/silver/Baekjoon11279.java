package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11279 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int []arr=new int[N+2];
		int size=0;
		for(int i=0;i<N;i++) {
			int x=Integer.parseInt(br.readLine());
			
			if(x==0) {
				if(size==0) {System.out.println(0);}
				else {
					System.out.println(arr[1]);
					arr[1]=arr[size--];
					int parent=1;
					int child;
					while(parent*2<=size) {
						child = (parent *2+1<=size && arr[parent*2]< arr[parent*2+1]) ? parent*2+1 : parent*2;
						if(child>size || arr[child]<arr[parent]) break;
						
						int temp=arr[parent];
						arr[parent]=arr[child];
						arr[child]=temp;
						
						parent=child;
					}
				}
			}else {
				arr[++size]=x;
				int p=size;
				while(p!=1) {
					int parent=p/2;
					if(arr[parent]<arr[p]) {
						int temp=arr[parent];
						arr[parent]=arr[p];
						arr[p]=temp;
						p = parent;
					}else {
						break;
					}
				}
			}
		}
	}
}
