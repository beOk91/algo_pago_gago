package algo_pago_gago;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Queue{
	
	int[] queue;
	int front;
	int back;
	int size;
	public Queue(int size) {
		front = 0;
		back = -1;
		queue = new int[size+1];
		this.size = size;
	}
	//push
	public void push (int x) {	
			queue[++back] = x;
	}
	//pop
	public void pop() {
		if(front > back){
			System.out.println("-1");			
		}else {
			System.out.println(queue[front++]);
		}
	}
	//front
	public void front() {
		if(front>back) {
			System.out.println("-1");
		}else {
		System.out.println(queue[front]);
		}
	}
	//back
	public void back() {
		if(front>back) {
			System.out.println("-1");
		}else {
		System.out.println(queue[back]);
		}
	}
	//size
	public void size(){
		System.out.println(back-front+1);
	}
	//empty()
	public void empty() {
		if(front>back) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}
	
	
}
public class beakjoon10845 {

	public static BufferedReader bf;
	public static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		 bf =  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String order;
		Queue queue = new Queue(10000);
		
		for(int i=0;i<N;i++) {
		 st = new StringTokenizer(bf.readLine());
		 order = st.nextToken();
		 if(order.equals("push")) {
			 queue.push( Integer.parseInt(st.nextToken()));
		 }else if(order.equals("pop")) {
			 queue.pop();
		 }else if(order.equals("size")) {
			 queue.size();
		 }else if(order.equals("empty")) {
			 queue.empty();
		 }else if(order.equals("front")) {
			 queue.front();
		 }else if(order.equals("back")) {
			 queue.back();
		 }
		 
		}

	}
	
	

}
