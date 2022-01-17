import java.util.Scanner;

public class lastIndex {


    private static int LastIndex(int arr[],int idx,int x){
        if(idx==-1) return -1;
        if(arr[idx] == x) return idx;
        return LastIndex(arr, idx-1, x);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        sc.close();
        System.out.println(LastIndex(arr,n-1,x));
    }
}
