package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class beakjoon2529 {

	static BufferedReader bf;
	static StringTokenizer st;
	static int k;
	static String map;
	static ArrayList<String> a = new ArrayList<String>();

	public static boolean doCheck(LinkedList<Integer> list) {
		for (int i = 0; i < k; i++) {
			if (map.charAt(i) == '<') {
				if (list.get(i) > list.get(i + 1))
					return false;
			} else {
				if (list.get(i) < list.get(i + 1))
					return false;
			}
		}

		return true;
	}

	public static void doPermutation(LinkedList<Integer> list, boolean[] check, int r) {
		if (list.size() == r) {
			if (doCheck(list)) {
				String result = "";
				for (int i : list) {
					result = result + String.valueOf(i);
				}
				a.add(result);
			}
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (!check[i]) {
				list.add(i);
				check[i] = true;
				doPermutation(list, check, r);
				check[i] = false;
				list.removeLast();
			}
		}

	}

	public static void main(String[] args) throws IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		map = "";
		for (int i = 0; i < k; i++) {
			map += st.nextToken();
		}
		boolean[] check = new boolean[10];
		LinkedList<Integer> list = new LinkedList<Integer>();
		doPermutation(list, check, k + 1);
		System.out.println(a.get(a.size()-1));
		System.out.println(a.get(0));
	}


}
