public class leetcode746 {
    public static void main(String[] args) {
        int cost[] = {10,15,20};
        System.out.println(Math.min(minCost(cost,0,new int[cost.length+1]),minCost(cost, 1, new int[cost.length])));
    }

    public static int minCost(int [] cost,int idx,int [] dp){
        if(idx>=cost.length) return 0;
        if(dp[idx] !=0) return dp[idx];
        return dp[idx] = cost[idx] + Math.min(minCost(cost,idx+1,dp),minCost(cost, idx+2, dp));
    }
}
