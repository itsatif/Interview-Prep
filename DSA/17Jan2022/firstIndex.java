import java.util.Scanner;

public class firstIndex {

    private static int FirstIndex(int arr[],int idx,int x){
        if(idx==arr.length) return -1;
        if(arr[idx]==x) return idx;
        return FirstIndex(arr, idx+1, x);
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
        System.out.println(FirstIndex(arr,0,x));
    }
}
