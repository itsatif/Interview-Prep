import java.util.Queue;
import java.util.Stack;
import java.util.*;

public class binarytree{

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair{
        Node node;
        int state;

        Pair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }

    public static int size(Node node){
        if(node == null) return 0;
        return size(node.left) + size(node.right) + 1;
    }

    public static int sum(Node node){
        if(node == null) return 0;
        return node.data + sum(node.left) + sum(node.right);
    }

    public static int max(Node node){
        if(node == null) return Integer.MIN_VALUE;
        return Math.max(node.data,Math.max(max(node.left),max(node.right)));
    }

    public static int height(Node node){
        if(node == null) return -1;
        return 1+ Math.max(height(node.left),height(node.right));
    }

    public static Node construct(Integer[] arr){
        Node root = new Node(arr[0],null,null);
        Pair rootpair = new Pair(root,1);
        Stack<Pair>st = new Stack<>();
        st.push(rootpair);
        int idx = 0;
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state == 1){
                idx++;
                if(arr[idx] != null){
                    top.node.left = new Node(arr[idx],null,null);
                    Pair lp = new Pair(top.node.left,1);
                    st.push(lp);
                }else{
                    top.node.left = null;
                }
                top.state++;
            }else if(top.state == 2){
                idx++;
                if(arr[idx] != null){
                    top.node.right = new Node(arr[idx],null,null);
                    Pair rp = new Pair(top.node.right,1);
                    st.push(rp);
                }else{
                    top.node.right = null;
                }
                top.state++;
            }else{
                st.pop();
            }
        }
        return root;
    }
    static ArrayList<Integer> path;
    public static boolean find(Node node, int data){
        if(node == null) return false;
        if(node.data == data){ 
            path.add(data);
            return true;
        }
        if(find(node.left,data)){
            path.add(data);
            return true;
        }

        if(find(node.right,data)){
            path.add(data);
            return true;
        }

        return false;
    }

    public static void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(queue.size()>0){
            int count = queue.size();
            for(int i=0;i<count;i++){
                node = queue.remove();
                System.out.print(node.data + " ");
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }

    public static Node removeLeaves(Node node){
        if(node == null) return null;
        if(node.left==null && node.right == null) return null;                   //agar wo leaf toh usko hata do
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node;
    }
    public static void display(Node node){
        if(node == null) return;
        String str = "";
        str += node.left == null ? "." : node.left.data + " ";
        str += " <-- " + node.data + " --> ";
        str += node.right == null ? "." : node.right.data + " ";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void printKLevelsDown(Node node,int k){
        if(node == null) return;

        if(k==0) System.out.println(node.data);

        printKLevelsDown(node.left,k-1);
        printKLevelsDown(node.right,k-1);
    }
    public static void main(String[] args) {
        Integer arr[] = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node root = construct(arr);
        display(root);
        System.out.println(height(root));
        System.out.println(size(root));
        System.out.println(max(root));
        System.out.println(sum(root));
        levelOrder(root);
        path = new ArrayList<>();
        boolean ans = find(root,30);
        System.out.println(ans);
        System.out.println(path);
        printKLevelsDown(root,2);
        Node withoutLeaf = removeLeaves(root);
        display(root);
    }
}