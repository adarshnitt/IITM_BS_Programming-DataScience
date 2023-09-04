public class abstract1 {
    public static void main(String[] args) {
        c11 abs_class = new c11();
        
    }
}

abstract class c1 {
    // abstract class and method
    public c1() {
        System.out.println("i m  c1 class constructor");
    }

    abstract public void f1_abstract();
}

class c11 extends c1 {
    public void f1_abstract() {
        System.out.println("i m c11 extended class constructor");
    }

}