import java.util.*;
class staircase{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(stair(n,new int[n+1]));
        sc.close();
    }

    public static int stair(int n,int[] dp){
        if(n<0)  return 0;
        if(n==0) return 1;
        if(dp[n]!=0) return dp[n];
        return dp[n] = stair(n-1, dp) + stair(n-2, dp) + stair(n-3, dp);
    }
}