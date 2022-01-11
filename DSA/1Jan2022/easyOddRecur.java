import java.util.Scanner;

class easyOddRecur{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(easyOdd(n));
    }
    static int easyOdd(int n){
        if(n==0) return 0;
        if((n%10)%2!=0) return n%10 + easyOdd(n/10);
        return easyOdd(n/10);
    }
}