import java.util.Scanner;

public class allIndicesOfArray {
    

    private static int[] AllIndicesOfArray(int arr[],int idx,int x,int fsf){
        if(idx == arr.length) return new int[fsf];
        if(x==arr[idx]){
            int ans[] = AllIndicesOfArray(arr,idx+1,x,fsf+1);
            ans[fsf] = idx;
            return ans;
        }
        return AllIndicesOfArray(arr,idx+1,x,fsf);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        sc.close();
        int ans[] = AllIndicesOfArray(arr,0,x,0);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
