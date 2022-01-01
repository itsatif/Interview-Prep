import java.util.ArrayList;

import java.util.*;
class leetcode39{
    public static void main(String[] args){
        int [] arr = {2,3,6,7};
        int target = 7;
        ArrayList<List<Integer>> ans = new ArrayList<>();
        findCombinationSum(arr,0,target,ans,new ArrayList<>());
        System.out.println(ans);
    }
    private static void findCombinationSum(int[] arr,int idx,int tar,List<List<Integer>> ans, ArrayList<Integer> ds){
        if(idx == arr.length){
            if(tar==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[idx]<=tar){
            ds.add(arr[idx]);
            findCombinationSum(arr, idx, tar-arr[idx], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombinationSum(arr, idx+1, tar, ans, ds);
    }



}