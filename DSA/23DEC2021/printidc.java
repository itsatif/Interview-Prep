class printidc{
    public static void main(String[] args) {
        int n = 3;
        pdd(n);
    }

    public static void pdd(int n){
        if(n==0) { System.out.println(n); return;}
        System.out.println(n);
        pdd(n-1);
        System.out.println(n);
    }
}