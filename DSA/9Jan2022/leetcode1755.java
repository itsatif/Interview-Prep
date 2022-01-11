import java.util.*;
class leetcode1755{


    static int i =0;
    public static void subSum(int[] nums,int idx,int[] sum,int ans){
        if(idx==nums.length){
            sum[i] = ans;
            i++;
            return;
        }
        int val = nums[idx];
        subSum(nums,idx+1,sum,ans+val);
        subSum(nums,idx+1,sum,ans);
    }
    
     public static int getClosest(int val1, int val2, int target){
        if (target - val1 >= val2 - target) 
            return val2;        
        else 
            return val1;        
    }
    
    public static int search(int []sum,int low,int high,int tar){
        int mid = 0;
        while(low<high){
            mid = (low+high)/2;
            if(tar == sum[mid]){
                return sum[mid];
            }
            if(tar<sum[mid]){
                if(mid>0 && tar>sum[mid-1]){
                    return getClosest(sum[mid-1],sum[mid],tar);
                }
               high = mid; 
            }else{
                if(mid<high-1 && tar<sum[mid+1]){
                    return getClosest(sum[mid],sum[mid+1],tar);
                }
            }
            low--;
            high++;
        }
        return mid;
    }
    public static int minAbsDifference(int[] nums, int goal) {
        int [] sum = new int[(int)Math.pow(2,nums.length)];
        subSum(nums,0,sum,0);
        Arrays.sort(sum);
        int near = 0;
        if(goal<=sum[0]){
            near = sum[0];
        }
        if(goal>=sum[sum.length-1]){
            near = sum[sum.length-1];
        }
         near = search(sum,0,sum.length,goal);
        return Math.abs(near-goal);
    }
    public static void main(String[] args) {
        int arr[] = {5,-7,3,5};
        System.out.println(minAbsDifference(arr,6));
    }

    
}