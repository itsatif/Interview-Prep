import java.util.Scanner;

public class leetcode326 {

    static boolean isPowerOfThree(int n){
        if(n==1) return true;
        if(n<=0 || n%3!=0) return false;
        return isPowerOfThree(n/3);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(isPowerOfThree(n));
    }
}
