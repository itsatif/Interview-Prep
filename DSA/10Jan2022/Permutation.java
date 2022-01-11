import java.util.*;

public class Permutation {

    static void permutations(int[] boxes,int ci,int ti){
        if(ci>ti){
            for(int i=0;i<boxes.length;i++){
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }
        for(int i=0;i<boxes.length;i++){
            if(boxes[i]==0){
                boxes[i] = ci;
                permutations(boxes,ci+1,ti);
                boxes[i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nofBoxes = sc.nextInt();
        int nofItems = sc.nextInt();
        permutations(new int[nofBoxes],1,nofItems);
    }
}
