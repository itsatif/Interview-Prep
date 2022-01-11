import java.util.Scanner;

public class coinPermut2 {

    static void coinChangePermuations2(int [] coins,int amt,String ans){
        if(amt<0) return;
        if(amt==0){
            System.out.println(ans+".");
            return;
        }
        for(int i=0;i<coins.length;i++){
            coinChangePermuations2(coins, amt-coins[i], ans+coins[i] + "-");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[] =  new int[n];
        for(int i=0;i<coins.length;i++){
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        coinChangePermuations2(coins,amt,"");
        sc.close();
    }   
}
