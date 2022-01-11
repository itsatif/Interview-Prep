import java.io.*;
import java.util.HashSet;
class leetcode653{
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static boolean helper(TreeNode root,int data,HashSet<Integer> set){
        if(root==null) return false;
        int comp = data - root.val;
        if(set.contains(comp)) return true;

        set.add(root.val);
        return helper(root.left, data, set) || helper(root.right, data, set);
    }

    static boolean findTarget(TreeNode root,int k){
        HashSet<Integer> set = new HashSet<>();
        return helper(root,k,set);
    }

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
        Integer arr[] = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // Integer[] arr = new Integer[n];
        // String[] values = br.readLine().split(" ");
        // for (int i = 0; i < n; i++) {
        //   if (values[i].equals("n") == false) {
        //     arr[i] = Integer.parseInt(values[i]);
        //   } else {
        //     arr[i] = null;
        //   }
        // }
        // int k = Integer.parseInt(br.readLine());
        TreeNode root = createTree(arr, new int[1]);
        System.out.println(findTarget(root, 100));
    }

}