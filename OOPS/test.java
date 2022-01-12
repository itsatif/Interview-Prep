public class test {

    static int a = 5;     
    //int b = 6;

    static int ans(){
        int c = 50;    
        System.out.println("mein kab aunga");  //function ke local scope jab function call hoga toh funct chalega tbhi yeh print hoga
        return c;                          
    }

    static void mns(){
        System.out.println("print 5");
        System.out.println(a);
        int sol = ans();
        System.out.println(sol);
        System.out.println("7");
    }

    public class Car{
        int speed;
        String Color;

        void print(){
            System.out.println(speed + " " + Color);
        }
    }

    // {
    //     System.out.println("instance block");                             //static block , 5 , instance block , 5 , 6, 0-1, 5, 6, 6  => Nitin
    //     System.out.println(a);                                            //error marega 
    //     System.out.println(b);                                            
    // }

    // static {
    //     System.out.println("static block");
    //     System.out.println(a);
    //     //System.out.println(t.b);
    // }

    // test(){
    //     System.out.println("0-1");
    //     System.out.println(b);
    // }

    public static void main(String[] args) {                        
    //    test t = new test();
    //    test t1 = new test();
     //  System.out.println(a);
    //    System.out.println(t.b);
    //  int a = 10;
    System.out.println(a);
    //    System.out.println(t1.b);
    int sol = ans();   //sol 50 ko catch krlega 
    System.out.println(sol);
    mns();
   // System.out.println(c);  => ans ke local scope ke andar h 
     

    }
}



//5, mein kab , print 5, 5, mein kab aunga , 7 => Nitin
//5, mein kab , 50, print 5 , 5 , mein kab aunga, 50 , 7