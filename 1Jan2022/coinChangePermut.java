import java.util.*;
public class coinChangePermut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        sc.close();
        int dp[] = new int[amount+1];
        System.out.println(coinPerTab(arr,amount,dp)  + " => This is Tabulated");
        System.out.println(coinPer(arr,amount,dp)  + " => This is memoized");
    }
    public static int coinPer(int arr[], int amount, int dp[]) {
        if(amount==0) return 1;
        if(amount<0) return 0;
        if(dp[amount] != 0) return dp[amount];
        int count =0;
        for(int i=0;i<arr.length;i++){
            count += coinPer(arr, amount-arr[i], dp);
        }
        return dp[amount] = count;
    }

    public static int coinPerTab(int arr[],int amount,int dp[]){
        dp[0] = 1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i>=arr[j]){
                dp[i] += dp[i-arr[j]]; 
                }
            }
        }
        return dp[amount];
    }
}
