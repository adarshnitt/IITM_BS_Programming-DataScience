import java.util.Arrays;
class one {
    public void f1() {
        System.out.println("one function");
    }
}

class two extends one {
    public void f1() {
        System.out.println("two function");
    }
    public void f11() {
        System.out.println("two function f11");
    }
}

public class dynamic_dispatch_polymorphism {
    public static void main()

    {
        int [] x={1,22,3,4,222,19,11,89};
        Arrays.sort(x);
        for(int i: x)
        {
          //System.out.println(i);
        }
        
        one o = new two();
        o.f1();
        //o.f11(); if parent class is reference then it wont run child functions. 
        // it will call two function not one; o have "two" properties not one
    }
}
