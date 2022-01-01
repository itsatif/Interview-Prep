public class lastIndex {
    public static void main(String[] args) {
        int n = 6;
        int a[] = {15,11,40,4,4,9};
        int x = 4;
        System.out.println(lastidx(a,n-1,x));
    }

    private static int lastidx(int [] arr,int n,int x) {
        if(n == -1) return -1;
        if(arr[n] == x) return n;
        return lastidx(arr, n-1, x);
    }

}
