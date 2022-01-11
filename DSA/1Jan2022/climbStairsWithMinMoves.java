import java.util.Scanner;
public class climbStairsWithMinMoves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int dp[] = new int [n+1];
        System.out.println(MinMoves(arr,0,dp) + " => This is Memoized");
        System.out.println(MinMovesTab(arr,dp) + " => This is Tabulated");
    }

    public static int MinMoves(int arr[], int idx, int dp[]){
        if(idx >= arr.length) return 0;
        if(dp[idx]!=0) return dp[idx];
        int min = arr.length+1;                           // any value which is max and greater than max jump
        for(int i=1;i<=arr[idx];i++){
            int ans = MinMoves(arr, idx+i, dp);
            if(ans<min) min = ans;
        }
        return dp[idx] = min + 1;
    }

    public static int MinMovesTab(int arr[], int dp[]){
        dp[arr.length] = 0;
        for(int i=arr.length-1;i>=0;i--){
            int min = arr.length+1;                         // any value which is max and greater than max jump
            for(int j=1;j<=arr[i] && i+j < dp.length ;j++){
                min = Math.min(min, dp[i+j] + 1);
            }
            dp[i] = min;
        }
        return dp[0];
    }
}
