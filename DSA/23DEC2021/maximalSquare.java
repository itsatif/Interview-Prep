public class maximalSquare {
    public static void main(String[] args) {
        
    }

    public static int areaSquare(int[][] mat,int r,int c){
        if(r==mat.length){
            return mat[r][c];
        }
        if(c==mat[0].length){
            return mat[r][c];
        }

        int rans = 0;
        int cans = 0;
        rans += areaSquare(mat, r, c+1);
        cans += areaSquare(mat, r+1, c);
        return rans*cans;
    }
   
}
