class pdi{
    public static void main(String[] args) {
        int n = 5;
        pidi(n);
    }

    public static void pidi(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        pidi(n-1);
        System.out.println(n);
    }
}

//print increasing decreasing 