import java.util.*;
//빠르게 휘리릭
public class Main {

    public static void main(String args[]) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            sb.append(iter.next()+" ");
        }
        
        System.out.println(sb);
        sc.close();
    }
}
