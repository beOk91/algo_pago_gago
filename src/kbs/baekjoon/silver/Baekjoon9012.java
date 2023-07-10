package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String in = br.readLine();
			int chk=0;
			for(int j=0;j<in.length();j++) {
				String val = in.charAt(j)+"";
				if(val.equals("(")) {
					chk++;
				}else {
					if(chk>0) { chk--;
					}else { chk--; break; }
				}
			}
			System.out.println(chk==0 ? "YES" : "NO");
			
		}
	}

}
