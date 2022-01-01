class leetcode322{
    public static void main(String[] args) {
        int arr[] = {1,2,5};
        int amount = 11;
        int ans = coinChange1(arr, 0, amount, new int [arr.length][amount+1]);
        int sol = (ans==Integer.MAX_VALUE-1 ? -1 : ans);
        System.out.println(sol);
    }

    private static int coinChange1(int [] arr,int idx,int amount,int dp[][]) {
       if(amount==0) return 0;
       if(idx>=arr.length) return Integer.MAX_VALUE-1;
       if(dp[idx][amount]!=0) return dp[idx][amount];
       int left = Integer.MAX_VALUE -1;
       if(arr[idx]<=amount){
           left = 1 + coinChange1(arr, idx, amount-arr[idx], dp);
       }
       int right = coinChange1(arr, idx+1, amount, dp);
       return dp[idx][amount] = Math.min(left,right);
    }
}