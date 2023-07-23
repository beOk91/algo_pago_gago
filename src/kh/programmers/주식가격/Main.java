package kh.programmers.주식가격;


import java.util.Stack;

class Stock {
    int price;
    int pos;

    Stock(int price, int pos) {
        this.price = price;
        this.pos = pos;
    }
}

class Solution {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Stock> st = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && st.peek().price > prices[i]) {
                Stock stock = st.pop();
                answer[stock.pos] = i - stock.pos;
            }
            st.push(new Stock(prices[i], i));
        }

        while(!st.isEmpty()) {
            Stock stock = st.pop();
            answer[stock.pos] = prices.length - stock.pos - 1;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] prices = {1, 1, 1, 1, 1};

        int[] solution = s.solution(prices);

        for (int n : solution) {
            System.out.print(n + ", ");
        }
    }
}
