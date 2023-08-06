package kbs.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon1644 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		boolean isPrime[]=new boolean[N+1]; isPrime[0]=true; isPrime[1]=true;
		for(int i=2;i<=(Math.sqrt(N)+1);i++) {
			for(int j=2;j<=N/i;j++) {
				if(!isPrime[i*j]) isPrime[i*j]=true;
			}
		}
		ArrayList<Integer> primeList=new ArrayList<>();
		for(int i=0;i<N+1;i++) {
			if(!isPrime[i]) primeList.add(i);
		}
		int primeSum=0, result=0;
		int left=0,right=0;
		while(right<primeList.size()) {
			primeSum+=primeList.get(right++);
			if(primeSum==N) result++;
			if(primeSum>=N) {
				while(primeSum>N) {
					primeSum-=primeList.get(left++);
					if(primeSum==N) {result++; break;}
				}
			}
		}
		
		
		
		System.out.println(result);
	}
}