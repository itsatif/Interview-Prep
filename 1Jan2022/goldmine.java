public class goldmine {
    public static void main(String[] args) {
        int arr[][] = {{0,1,4,2,8,2},{4,3,6,5,0,4},{1,2,4,1,4,6},{2,0,7,3,2,2},{3,1,5,9,2,4},{2,7,0,8,5,1}};
        int dp[][] = new int[arr.length][arr[0].length];
        int max = Integer.MIN_VALUE;
        for(int row=0;row<arr.length;row++){
            int ans = goldmineC(arr,row,0,dp);
            max = Math.max(max,ans);
        }
        System.out.print(max);
    }

    public static int goldmineC(int arr[][], int r, int c, int dp[][]){
        if(r<0 || r>=arr.length) return 0;                     //edge case
        if(c==arr.length-1) return arr[r][c];                  //base case
        if(dp[r][c]!=0) return dp[r][c];                       //memoization 
        return dp[r][c] = arr[r][c] + Math.max(goldmineC(arr,r-1,c+1,dp),Math.max(goldmineC(arr, r, c+1, dp),goldmineC(arr, r+1, c+1, dp)));
    }
}
