import java.util.*;

class linkedlist {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        int size() {
            return size;
        }

        void display() {
            if(size==0) return;
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        void removeFirst() {
            if (size == 0) {
                System.out.println("list is empty");
                return;
            }
            if (size == 1) {
                head = tail = null;
            }
            head = head.next;
            size--;
        }

        void removeLast() {
            if (size == 0) {
                System.out.println("list is empty");
                return;
            }
            if (size == 1) {
                head = tail = null;
            }
            Node temp = head;
            for (int i = 2; i < size; i++) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
            size--;
        }

        int getFirst() {
            if (size == 0) {
                System.out.println("list is empty ");
                return -1;
            }
            return head.data;
        }

        int getLast() {
            if (size == 0) {
                System.out.println("list is empty ");
                return -1;
            }
            return tail.data;
        }

        int getAt(int idx) {
            if (size == 0) {
                System.out.println("list is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid Arguments");
                return -1;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp.data;
            }

        }

        void addAt(int idx, int val){
            if(idx<0 || idx>size){
                System.out.println("Invalid arguments");
            }else if(idx==0){
                addFirst(val);
            }else if(idx==size-1){
                addLast(val);
            }else{
                Node n = new Node();
                n.data = val;
                Node temp = head;
                for(int i=0;i<idx-1;i++){
                    temp = temp.next;
                }
                n.next = temp.next;
                temp.next = n;
                size++;
            }
        }

        void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            if (size == 0) {
                head = tail = temp;
            } else {
                head = temp;
            }
            size++;
        }

        void removeAt(int idx){
            if(idx<0 || idx>=size){
                System.out.println("Invalid Arguments");
            }else if(idx==0){
                removeFirst();
            }else if(idx==size-1){
                removeLast();
            }else{
                Node temp = head;
                for(int i=0;i<idx-1;i++){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        String str = sc.nextLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("addLast")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            } else if (str.startsWith("size")) {
                System.out.println(list.size());
            } else if (str.startsWith("display")) {
                list.display();
            } else if (str.startsWith("removeFirst")) {
                list.removeFirst();
            } else if (str.startsWith("getFirst")) {
                int val = list.getFirst();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("getLast")) {
                int val = list.getLast();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("getAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = list.getAt(idx);
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("addFirst")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addFirst(val);
            } else if (str.startsWith("addAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = Integer.parseInt(str.split(" ")[2]);
                list.addAt(idx, val);
            } else if (str.startsWith("removeLast")) {
                list.removeLast();
            } else if (str.startsWith("removeAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                list.removeAt(idx);
            }
            str = sc.nextLine();
        }
        sc.close();
    }
}