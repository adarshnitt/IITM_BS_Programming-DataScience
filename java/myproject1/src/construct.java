import java.util.*;

public class construct {

    public static void main() {
        System.out.println("main method");

        // Scanner s= new Scanner(System.in);
        // for(int i=0; i<5;i++)
        // {
        // int z=s.nextInt();
        // System.out.println(z+"-------");
        // }
        par p = new par1(9, "p", 77);
        p.fun2();
        // p.fun1();
        // you canot access this fun1 function bcz its private function
    }
}

class par {
    public int x;
    public String y;

    public par(int ip1, String s1) {
        this.x = ip1;
        this.y = s1;
        System.out.println("constructor with no args ");
    }

    public par() {
        this(7, "pp");
    }

    public static void fun2() {
        System.out.println("fun2 in par ");
    }

    private static void fun1() {
        System.out.println("fun1 in par: private");
    }

    final public static void fun() {
        System.out.println("fun in sub");
    }
}

class par1 extends par {
    public int y;

    public par1(int ip1, String s1, int y1) {
        super(ip1, s1);
        this.y = y1;
        System.out.println("2nd constructor with no args ");
    }

    public static void fun1() {
        System.out.println("fun in sub");
    }

    public static void fun2() {
        System.out.println("fun2 in par1");
    }

}