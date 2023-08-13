import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean chk[];
    static int [][] stats;
    static long result=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        stats=new int[N][N];//능력치
        for(int i=0;i<N;i++){
            StringTokenizer strToken=new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++){
                stats[i][j]=Integer.parseInt(strToken.nextToken());
            }
        }
        chk=new boolean[N];
        dfs(0,0);
        System.out.println(result);
    }
    
    public static void dfs(int depth,int start){
        long starStat = 0, linkStat =0;
        if(depth==N/2){
            for(int i=0;i<N;i++){
                if(chk[i]){
                    starStat+=starStatAdd(i);
                }else{
                    linkStat+=linkStatADD(i);
                }
            }
            long diff=starStat-linkStat;
            diff=Math.abs(diff);
            if(diff==0){
                System.out.println(0);
                System.exit(0);
            }
            if(result>diff) {
                result=diff;
            }
            return;
        }
        for(int i=start;i<N;i++){
            chk[i]=true;
            dfs(depth+1,i+1);
            chk[i]=false;
        }
    }

    public static long starStatAdd(int i){
        long result=0;
        for(int j=0;j<N;j++){
            if(chk[j])
            result+=stats[i][j];
        }
        return result;
    }

    public static long linkStatADD(int i){
        long result=0;
        for(int j=0;j<N;j++){
            if(!chk[j])
                result+=stats[i][j];
        }
        return result;
    }

}