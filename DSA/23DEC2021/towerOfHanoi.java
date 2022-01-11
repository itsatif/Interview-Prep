public class towerOfHanoi {
    public static void main(String[] args){
        int n = 3;
        int A = 10;
        int B = 11;
        int C = 12;
        toh(n,A,B,C);
    }
    private static void toh(int n,int A,int B,int C){
        if(n==0) return;
        toh(n-1,A,C,B);
        System.out.println(n +"[" + A + " -> " + B +"]");
        toh(n-1,C,B,A);
    }
}
