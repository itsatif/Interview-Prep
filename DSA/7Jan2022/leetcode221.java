class leetcode221 {
    public static void main(String[] args) {
        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        char[][] mat = { { '0', '1' }, { '1', '0' } };
        char[][] m = { { '0' } };
        // for (int i = 0; i < matrix.length; i++) {
        //     for (char val : matrix[i]) {
        //         System.out.print(val + "\t");
        //     }
        // }

        int dp[][] = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else if(i==dp.length-1 || j==dp[0].length-1){
                    dp[i][j] = 1;
                }else{
                    int min = Math.min(dp[i][j+1],dp[i+1][j+1]);
                    min = Math.min(min,dp[i+1][j+1]);
                    dp[i][j] = min + 1;
                }
                if(dp[i][j]>ans){
                    ans = dp[i][j];
                }
            }
        }
        System.out.println(ans*ans);
    }
}