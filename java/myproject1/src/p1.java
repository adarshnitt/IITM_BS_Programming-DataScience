public class p1 {
    public static void main() {
        Parent p = new Parent();
    }
}

class Parent {
    public Parent() {
        System.out.println("Parent constructor");
    }

    public static void f1() {
        System.out.println("Parent f1 function calling");
    }

    public void f2() {
        System.out.println("Parent f2 function calling");
    }
}

class Child extends Parent {
    public Child() {
        System.out.println("Child constructor");
    }

    public static void f1() {
        System.out.println("Child f1 function calling");
    }

    public void f2() {
        System.out.println("Parent f2 function calling");
    }
}
