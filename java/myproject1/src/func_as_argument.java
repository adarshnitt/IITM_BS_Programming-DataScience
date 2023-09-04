
public class func_as_argument {
    public static void main(String[] args) {
        System.out.println("Main class");
        calculate cal = new calculate();
        int z = cal.calc1(8, 9, new temp_implement());
        System.out.println(z);
    }
}

// class to take input as methods
class calculate {
    // syntax for providing method as an argument: (interface_name
    // class_implementing_interace)
    // temp1: concrete data data, interface temp1{}
    // int x: here int replace by temp1 and x replace by rand_meth
    public int calc1(int x, int y, temp1 rand_meth) {
        return rand_meth.add(x, y);
    }
}

// step-1 define template
interface temp1 {
    int add(int x, int y);
}

// step-2 define template impletation
class temp_implement implements temp1 {
    public int add(int x, int y) {
        return x + y;
    }
}