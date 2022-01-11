import java.util.*;

public class coinComb {

    static void coinChangeCombination(int [] coins,int idx,int amt,String ans){
        if(idx>coins.length || amt<0) return;
        if(idx==coins.length){
            if(amt==0){
                System.out.println(ans+".");
            }
            return;
        }
        coinChangeCombination(coins, idx+1, amt-coins[idx], ans+coins[idx] + "-");
        coinChangeCombination(coins, idx+1, amt, ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[] = new int[n];
        for(int i=0;i<coins.length;i++){
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        coinChangeCombination(coins,0,amt,"");
    }
}
