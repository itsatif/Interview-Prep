public class power {
    public static void main(String[] args) {
        int x = 2;
        int n = 3;
        System.out.println(powerImp(x,n));
    }

    private static int powerImp(int x,int n) {
        if(n==0) return 1;
        return n%2!=0 ? x * powerImp(x,n/2) * powerImp(x,n/2) : powerImp(x, n/2)*powerImp(x,n/2);
    }
}
