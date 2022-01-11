import java.util.*;

public class coinPermut {


    static void coinChangePermuations(int [] coins,int amount,String ans,boolean[] vis){
        if(amount<0) return;
        if(amount==0){
            System.out.println(ans + ".");
            return;
        }
        for(int i=0;i<coins.length;i++){
            if(vis[i]==false){
                vis[i] = true;
                coinChangePermuations(coins, amount-coins[i], ans+coins[i] + "-", vis);
                vis[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] coins = new int[n];
        for(int i=0;i<coins.length;i++){
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        sc.close();
        coinChangePermuations(coins,amount,"",new boolean [n]);
    }
}
