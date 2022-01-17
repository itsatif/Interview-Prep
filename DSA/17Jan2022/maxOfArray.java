import java.util.Scanner;

public class maxOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(maxArray(arr,0));
    }

   static int max = Integer.MIN_VALUE;
    public static int maxArray(int[] arr, int idx){
       if(idx==arr.length) return 0;
       int rans = maxArray(arr, idx+1);
       int max = Math.max(rans,arr[idx]);
       return max;
    }
}
