import java.util.Scanner;

public class tohGfg {
    

    private static long toh(int n,int t1,int t2,int t3){
        long count =1;
        if(n==0) return 0;
        count += toh(n-1,t1,t3,t2);
        System.out.println("move disk " + n + " from rod "+  t1 + " to rod " + t2);
        count+=toh(n-1,t3,t2,t1);
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(toh(n,1,3,2));
        sc.close();
    }
}
