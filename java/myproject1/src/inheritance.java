public class inheritance {
    public  void main() {
    c11 x=new c11();
    // aceess of interface var
    System.out.println(x.x1+" val of x1");
    }
}

abstract class c1 {
    // abstract class and method
    public c1() {
        System.out.println("i m  c1 abstract class constructor");
    }

    abstract public void f1_abstract();
}

interface  inter1
  {
  int x1=89;
  void f1();
  void f2();
  }


class c11   extends c1  implements inter1{
    public  c11() {
        System.out.println("i m c11 child class constructor");
    }
    public void f1() {
        System.out.println("i m implementing interface method f1");
    }
    public void f2() {
        System.out.println("i m implementing interface method f2");
    }

    public void f1_abstract()
    {
      System.out.println("i m implementing abstract method f1_abstract");
    }
}
