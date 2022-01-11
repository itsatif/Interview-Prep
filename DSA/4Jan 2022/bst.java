import java.util.*;
class bst{


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

    public static Node construct(Integer arr[]){
        Node root = new Node(arr[0],null,null);
        Pair rn = new Pair(root,1);
        Stack<Pair> st = new Stack<>();
        st.push(rn);
        int idx = 0;
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state == 1){
                idx++;
                if(arr[idx]!=null){
                    top.node.left = new Node(arr[idx],null,null);
                    Pair lp = new Pair(top.node.left,1);
                    st.push(lp);
                }else{
                    top.node.left = null;
                }
                top.state++;
            }else if(top.state==2){
                idx++;
                if(arr[idx]!=null){
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

    public static int sum(Node node){
        if(node == null) return 0;
        return node.data + sum(node.left) + sum(node.right);
    }

    public static int size(Node node){
        if(node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public static int height(Node node){
        if(node == null) return -1;
        return 1 + Math.max(height(node.left),height(node.right));        
    }

    public static void display(Node node){
        if(node == null) return;
        String str = "";
        str += node.left == null ? ".":node.data + " --> ";
        str+= " ---> " + node.data + " --> ";
        str+= node.right == null ? ".":node.data + " --> ";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static int max(Node node){
        if(node.right == null) return node.data;
        return max(node.right);
    }

    public static int min(Node node){
        if(node.left == null) return node.data;
        return min(node.left);
    }

    public static boolean find(Node node,int data){
        if(node == null) return false;
        if(data<node.data) return find(node.left, data);
        if(data>node.data) return find(node.right,data);
         return true;
    }
    public static Node add(Node node,int data){
        if(node == null){
            return new Node(data,null,null);
        }

        if(node.data<data){
            node.right = add(node.right,data);
        }
        if(node.data > data){
            node.left = add(node.right,data);
        }
        return node;
    }

    
    public static void main(String[] args) {
        Integer arr[] = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node root = construct(arr);
        display(root);
        System.out.println(sum(root));
        System.out.println(size(root));
        System.out.println(height(root));
        System.out.println(max(root));
        System.out.println(min(root));
        System.out.println(find(root,62));
        root = add(root,77);
        display(root);
    }
}