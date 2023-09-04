public class oop {
    public static void main() {
        // initiating child1 object
        child1 c1 = new child1();
        child1 c2 = new child1();

        c1.id = 8;
        c1.name = "adarsh";

        c2.id = 88;
        c2.salary = 1;
        c2.name = "bhanu";

        // System.out.println(c1.id);
        // System.out.println(c1.name);

        // c1.detail();
        // c2.detail();
        // c2.getsalary();

        // public private and default access modifier
        acess_modifier am = new acess_modifier();

        // am.var1=10; //---> throwing an error as var1 is private var in
        // acess_modifier.
        // am.set(111110);
        // am.get();

        // use_of_this uthis= new use_of_this();
        // uthis.set(12121212);

        // constructor
    }
}

class constructor1 {
    int x;

    public constructor1() {
        // class name  and method/unction name must be same
    }
}

class acess_modifier {
    private int var1;

    public void set(int v) {
        var1 = v;
    }

    public void get() {
        System.out.println(var1);
    }
}

class use_of_this {
    private int var1;

    public void set(int v) {
        this.var1 = v;
        System.out.println(this.var1 + "   use of this");
    }
}

class child1 {
    int id;
    int salary;
    String name;

    public void detail() {
        System.out.println("id is: " + id);
        System.out.println("name is : " + name);
    }

    public int getsalary() {
        return salary;
    }
}
