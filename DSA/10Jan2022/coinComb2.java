import java.util.Scanner;

public class coinComb2 {

    static void coinChangeCombination2(int coins[],int idx,int amt,String ans){
        if(idx>=coins.length || amt<0) return;
        if(amt==0){
            System.out.println(ans+".");
            return;
        }
        coinChangeCombination2(coins, idx, amt-coins[idx], ans+coins[idx]+"-");
        coinChangeCombination2(coins, idx+1, amt, ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[] = new int[n];
        for(int i=0;i<coins.length;i++){
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        coinChangeCombination2(coins,0,amt,"");
        sc.close();
    }
}
