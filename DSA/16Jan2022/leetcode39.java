import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class leetcode39 {


    private static void CombinationSum(int [] arr,int idx,int target,List<List<Integer>> ans,ArrayList<Integer> res){

        if(idx==arr.length){
            if(target==0){
                ans.add(new ArrayList<Integer>(res));
            }
            return;
        }
        if(arr[idx]<=target){
            res.add(arr[idx]);
            CombinationSum(arr, idx, target-arr[idx], ans, res);
            res.remove(res.size()-1);
        }
        CombinationSum(arr, idx+1, target, ans, res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        sc.close();
        List<List<Integer>> ans = new ArrayList<>();
        CombinationSum(arr,0,target,ans,new ArrayList<>());
        System.out.println(ans);
    }
}
