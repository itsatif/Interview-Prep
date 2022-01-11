public class fact {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(facto(n,new int[n+1]));
    }

    private static int facto(int n,int[] dp){
        if(n==1) return 1;
        if(dp[n]!=0) return dp[n];
        return dp[n] =n*facto(n-1,dp);
    }
}
