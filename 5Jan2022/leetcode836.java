import java.util.*;
import java.io.*;
class leetcode836 {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static void prinktKlevel(TreeNode node, int k, TreeNode blocker, ArrayList<Integer> ans) {
        if (node == null || k < 0 || node == blocker)
            return;

        if (k == 0) {
            ans.add(node.val);
        }
        prinktKlevel(node.left, k - 1, blocker, ans);
        prinktKlevel(node.right, k - 1, blocker, ans);
    }

    static int distanceK(TreeNode node, int target, int k, ArrayList<Integer> ans) {
        // base case if node is null
        if (node == null)
            return -1;

        // node value is equal to target
        if (node.val == target) {
            prinktKlevel(node, k, null, ans);
            return 1;
        }

        // left side distance
        int ld = distanceK(node.left, target, k, ans);
        if (ld != -1) {
            prinktKlevel(node, k - ld, node.left, ans);
            return 1 + ld;
        }

        // right side distance
        int rd = distanceK(node.right, target, k, ans);
        if (rd != -1) {
            prinktKlevel(node, k - rd, node.right, ans);
            return 1 + rd;
        }
        return -1;
    }

    //arraylist for printing data in leetcode insted of int target there is TreeNode target so use target,val there
    static ArrayList<Integer> distanceK(TreeNode root, int target, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        distanceK(root, target, k, ans);
        return ans;
    }


    //boiler-plate input-section
    public static TreeNode createTree(Integer[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == null) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void main(String[] args) throws Exception {
        //Integer arr[] = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          if (values[i].equals("n") == false) {
            arr[i] = Integer.parseInt(values[i]);
          } else {
            arr[i] = null;
          }
        }
    
        int target = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        TreeNode root = createTree(arr, new int[1]);
        ArrayList<Integer> ans = distanceK(root, target, k);
        for(Integer el:ans){
            System.out.println(el + " k = " + k +" distance nodes print karde ");
        }
    }
}