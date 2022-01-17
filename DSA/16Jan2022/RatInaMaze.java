import java.util.ArrayList;
import java.util.Scanner;

public class RatInaMaze {

    private static void RatMaze(int [][] maze,int sr,int sc,int n,boolean [][] vis,ArrayList<String> ans,String asf){

        if(sr<0 || sc<0 || sr>=n || sc>=n || maze[sr][sc] == 0 || vis[sr][sc] == true) return;

        if(sr==n-1 && sc==n-1){
            ans.add(asf);
            return;
        }


        vis[sr][sc] = true;
        RatMaze(maze, sr-1, sc, n, vis, ans,asf+"U");
        RatMaze(maze, sr+1, sc, n, vis, ans,asf+"D");
        RatMaze(maze, sr, sc-1, n, vis, ans,asf+"L");
        RatMaze(maze, sr, sc+1, n, vis, ans,asf+"R");
        vis[sr][sc] = false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maze[][] = new int[n][n];
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                maze[i][j] = sc.nextInt();
            }
        }
        sc.close();
        ArrayList<String> ans = new ArrayList<>();
        RatMaze(maze,0,0,n,new boolean [n][n],ans,"");
        System.out.print(ans);

    }
}
