package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11286 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int plusHeap[]=new int[N+1];
		int minusHeap[]=new int[N+1];
		int plusSize = 0;
		int minusSize =0;
		for(int i=0;i<N;i++) {
			int x=Integer.parseInt(br.readLine());
			if(x==0) {
				if(plusSize==0 && minusSize==0) {
					System.out.println(0);
				}else if(minusSize==0 || (plusSize>0 && plusHeap[1] <minusHeap[1]*-1)) {
					System.out.println(plusHeap[1]);
					plusHeap[1]=plusHeap[plusSize--];
					if(plusSize<0) plusSize=0;
					int parent=1;
					int child;
					while(parent*2<=plusSize) {
						child = (parent*2+1<=plusSize && plusHeap[parent*2] >plusHeap[parent*2+1] )? parent*2+1 : parent*2;
						if(child>plusSize || plusHeap[child]>plusHeap[parent] ) break;
						
						int temp=plusHeap[parent];
						plusHeap[parent] =plusHeap[child];
						plusHeap[child]= temp;
						parent=child;
					}
				}else{
					System.out.println(minusHeap[1]);
					minusHeap[1]=minusHeap[minusSize--];
					if(minusSize<0) minusSize=0;
					int parent=1;
					int child;
					while(parent*2<=minusSize) {
						child = (parent*2+1<=minusSize && minusHeap[parent*2] <minusHeap[parent*2+1]) ? parent*2+1 : parent*2;
						if(child>minusSize || minusHeap[child]<minusHeap[parent] ) break;
						
						int temp=minusHeap[parent];
						minusHeap[parent] =minusHeap[child];
						minusHeap[child]= temp;
						parent=child;
					}
					
				}
			}else {
				if(x>0) {
					plusHeap[++plusSize]=x;
					int child=plusSize;
					while(child!=1) {
						if(plusHeap[child]<plusHeap[child/2]) {
							int temp= plusHeap[child];
							plusHeap[child] = plusHeap[child/2];
							plusHeap[child/2]= temp;
							child/=2;
						}else {
							break;
						}
					}
				}else {
					minusHeap[++minusSize]=x;
					int child=minusSize;
					while(child!=1) {
						if(minusHeap[child]>minusHeap[child/2]) {
							int temp= minusHeap[child];
							minusHeap[child] = minusHeap[child/2];
							minusHeap[child/2]= temp;
							child/=2;
						}else {
							break;
						}
					}
				}
			}
		}
	}
}
