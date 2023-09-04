public class interface1 {
 public static void main()
 {
    System.out.println(" interface class ");
    c2 c=new c2();
    c2.c11();
    int z=c2.sum(2,3);
    System.out.println(z);
 }   
}

abstract class c1{
    int x;
    int y;
    // abstract can have instance var/constructors/regular methods, but interface dont have
    public static void c11()
    {

    }
}
 class c2 extends c1 implements i1
 {
    public  static void c11()
    {
      System.out.println("c2");
    }

    public static int sum(int x, int y)
    {
        return x+y;
    }
}


interface i1 
{
    // interface have final variables and abstract methods
    int x=2;
    int  sum(int x)
    {
        return 1;
    }
}

interface i2 extends i1
{
    // interface have final variables and abstract methods
    int x=2;
    void sum();
}