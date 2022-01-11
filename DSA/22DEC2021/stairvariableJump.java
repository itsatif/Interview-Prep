import java.util.*;

public class stairvariableJump {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(varJump(a, 0, new int[n + 1]) + " =>\tI m memoize");
        System.out.println(varJumpTab(a,new int[n+1]) + " =>\tthis is tabultion");
        sc.close();
    }

    public static int varJump(int[] arr, int idx, int[] dp) {
        if (idx == arr.length) return 1;
        if (idx > arr.length) return 0;
        if (dp[idx] != 0) return dp[idx];
        int count = 0;
        for (int i = 1; i <= arr[idx]; i++) {
            count += varJump(arr, idx + i, dp);
        }
        return dp[idx] = count;
    }

    public static int varJumpTab(int[] arr,int dp[]){
        dp[arr.length] = 1;
        for(int i=arr.length-1;i>=0;i--){
            for(int j=1;j<=arr[i] && i+j<dp.length;j++){
                    dp[i] += dp[i+j];
            
            }
        }
        return dp[0];
    }

}
