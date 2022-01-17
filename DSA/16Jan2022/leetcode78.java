import java.util.*;

public class leetcode78 {

    private static void Subsets(int nums[], int idx, List<List<Integer>> ans,ArrayList<Integer> res){
        if(idx==nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }

        Subsets(nums, idx+1, ans,res);
        res.add(nums[idx]);
        Subsets(nums, idx+1, ans,res);
        res.remove(res.size()-1);
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
        List<List<Integer>> ans = new ArrayList<>();
        Subsets(nums,0,ans,new ArrayList<Integer>());
        System.out.println(ans);

    }
}
